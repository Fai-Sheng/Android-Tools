package com.fai.autoassignment.imp;
import android.os.Build;
import android.support.annotation.RequiresApi;
import com.fai.autoassignment.annotations.EntityParam;
import com.fai.autoassignment.bean.ObjectWrapper;
import com.fai.autoassignment.core.Resolver;
import java.lang.reflect.Field;

/**
 * Created by PVer on 2018/6/4.
 */

public class FieldResolver implements Resolver{

    @Override
    public <T, K> K execSetParam(T src, K goal) {
        return null;
    }

    // 1.两个相同的CParam 的name值

    // 2.只有goal上面有 name值

    // 3.两个字段上面都没有值

    // 4.存在内部类对象 的情况如何处理

    // 5.内部类的对象 的值 赋值给一个goal的普通值

    // 6.多重内部类 对象（特殊情况）

    // 7.数组和对象如何判断，String类型的判断

    // 8.多个 内部的对象有相同的 字段



    @RequiresApi(api = Build.VERSION_CODES.N)
    private<K> void resolveGoalObj(K goal) {
        if(goal == null)
        {
            return;
        }

        Field[] fields = goal.getClass().getDeclaredFields();

        for(Field field : fields)
        {

        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void resolveGoalObjField(Field field) {
        if(field.getDeclaredAnnotation(EntityParam.class) != null){
            //对象
            try {
                EntityParam clsParam = field.getDeclaredAnnotation(EntityParam.class);
                String clsNameVal  = clsParam.name();
                Object obj = field.getType().newInstance();
                Field[] fields = obj.getClass().getDeclaredFields();
                for(int i = 0;i < fields.length;i++){

                }
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            //不是 对象
            ObjectWrapper wrapper = new ObjectWrapper();
            
        }
    }


    private<T> void resolveSrcObj(T goal){

    }
}
