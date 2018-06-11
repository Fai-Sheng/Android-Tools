package com.fai.autoassignment.imp;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.fai.autoassignment.annotations.EntityParam;
import com.fai.autoassignment.annotations.Param;
import com.fai.autoassignment.core.Resolver;
import java.lang.reflect.Field;

/**
 * Created by PVer on 2018/6/4.
 */


// 1.两个相同的CParam 的name值

// 2.只有goal上面有 name值

// 3.两个字段上面都没有值

// 4.存在内部类对象 的情况如何处理

// 5.内部类的对象 的值 赋值给一个goal的普通值

// 6.多重内部类 对象（特殊情况）

// 7.数组和对象如何判断，String类型的判断

// 8.多个 内部的对象有相同的 字段

public class FieldResolver implements Resolver {

    private Object src;
    private Object goal;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public <T, K> K execSetParam(T src, K goal) {
        this.src = src;
        this.goal = goal;
        try {
            resolve(src,goal);
        } catch (NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return goal;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void resolve(Object src,Object goal) throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        if(null == src){
            return;
        }
        if (null == goal) {
            return;
        }
        Field[] fields = goal.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            resolveField(field,goal,src);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void resolveField(Field goalField,Object goal, Object src) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        if (null == goalField) {
            return;
        }
        Class goalFieldClass = goalField.getType();
        EntityParam goalEntityParam = (EntityParam) goalFieldClass.getDeclaredAnnotation(EntityParam.class);

        //1.对象Field
        if (null != goalEntityParam) {
            String goalEntityParamName = goalEntityParam.name();
            if(TextUtils.isEmpty(goalEntityParamName)){
                goalEntityParamName = goalField.getName(); //如果是空值，默认就是name
            }
            Field srcFieldWithParam = findFieldWithEntityAnnotation(src,goalEntityParamName);
            if(srcFieldWithParam != null){
                Object goalFieldObj = goalFieldClass.newInstance();
                goalField.set(goal,goalFieldObj);
                resolve(srcFieldWithParam.get(src),goalField.get(goal));
            }
            return;
        }
        //2.带Param的普通Field
        if (null != goalField.getDeclaredAnnotation(Param.class)) {
            //这个Field带有 Param
            Param goalParam = goalField.getDeclaredAnnotation(Param.class);
            String goalParamName = goalParam.name();

            if(TextUtils.isEmpty(goalParamName)){
                goalParamName = goalField.getName();
            }

            Field srcField = findFieldWithFieldAnnotation(src,goalParamName);
            if(null != srcField){
                goalField.set(goal,srcField.get(src));
            } else {
                //寻找 没有 Param 但是 Field的name相同的
                Field srcField2 = src.getClass().getDeclaredField(goalParamName);
                if(srcField2 != null){
                    goalField.set(goal,srcField2.get(src));
                }
            }
            return;
        }
        //3.不带注解的普通字段
        String goalFieldName = goalField.getName();
        Field srcField = src.getClass().getField(goalFieldName);
        if(null != srcField){
            goalField.set(goal,srcField.get(src));
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private Field findFieldWithEntityAnnotation(Object obj , String name)
    {
        if(null == obj || TextUtils.isEmpty(name)){
            return null;
        }
        Field[] fs = obj.getClass().getDeclaredFields();
        //先判断带有相同name的 EntityParam
        for(Field f : fs){
            f.setAccessible(true);
            Class fieldClass = f.getType();
            EntityParam entityParam = (EntityParam) fieldClass.getDeclaredAnnotation(EntityParam.class);
            if(null != entityParam){
                String entityParamName = entityParam.name();
                if(TextUtils.isEmpty(entityParamName)){
                    entityParamName = fieldClass.getSimpleName();
                }
                if(entityParamName.equals(name)){
                    return f;
                }
            }
        }
        //再去寻找不带EntityParam，但是类名和EntityParam的name相同的
        for(Field ff : fs) {
            ff.setAccessible(true);
            Class fieldCls = ff.getType();
            String clsName = fieldCls.getSimpleName();
            if(clsName.equals(name)){
                return ff;
            }
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private Field findFieldWithFieldAnnotation(Object obj , String name)
    {
        if(null == obj || TextUtils.isEmpty(name)){
            return null;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        //先找 带Param的字段
        for(Field f : fields){
            f.setAccessible(true);
            if(null != f.getDeclaredAnnotation(Param.class) && f.getDeclaredAnnotation(Param.class).name().equals(name)){
                return f;
            }
        }
        //在找没有Param的 普通字段
        for(Field ff : fields)
        {
            ff.setAccessible(true);
            String fieldName = ff.getName();
            if(fieldName.equals(name)){
                return ff;
            }
        }
        return null;
    }

}
