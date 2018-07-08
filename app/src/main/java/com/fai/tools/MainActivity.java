package com.fai.tools;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.fai.autoassignment.imp.FieldResolver;
import com.fai.tools.model.Crowd;
import com.fai.tools.model.People;
import com.fai.tools.model.Person;
import com.fai.tools.model.User;
import com.fai.tools.ui.imgpreview.GridImageActivity;
import com.fai.tools.ui.anim.AnimActivity;
import com.fai.tools.ui.base.BaseActivity;
import com.fai.tools.ui.fragment_viewpager.ViewPagerFragmentActivity;
import com.fai.tools.ui.fragments_in_one_activity.activity.FragmentsDemoNavActivity;
import com.fai.tools.ui.mvp.MVPLoginActivity;
import com.fai.tools.ui.toolbar.ToolBarActivity;
import com.fai.tools.ui.viewpagerdemo.ViewPagerActivity;
import com.fai.tools.ui.zxing.ZxingActivity;
import com.fai.tools.utils.JumpUtils;
import com.google.gson.Gson;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
public class MainActivity extends BaseActivity {


    @BindView(R.id.viewPagerDemoBtn)
    Button viewPagerDemoBtn;

    @BindView(R.id.oneActManyFratsBtn)
    Button oneActManyFragmetsBtn;

    @BindView(R.id.img_prev_btn)
    Button imgPrevBtn;

    @BindView(R.id.anim_demo_btn)
    Button animDemoBtn;

    @BindView(R.id.btn_to_zxing)
    Button btnZxing;

    @BindView(R.id.mvp_btn)
    Button btnMvp;

    @BindView(R.id.toolbar_btn)
    Button btnToolBar;

    @BindView(R.id.viewPagerFragmentBtn)
    Button viewPager_fragmentBtn;

    private List<JumpBtn> btnList = new ArrayList<>();

    private static final String TAG = "GoogleMainActivity";

    static class MainHandler extends Handler{

        private WeakReference<MainActivity> weakReferenceMainActivity;

        public MainHandler(MainActivity mainActivity)
        {
            WeakReference<MainActivity> weakReference = new WeakReference<>(mainActivity);
            this.weakReferenceMainActivity = weakReference;
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void init(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        init();
        ceshi();
    }

    private void ceshi2() throws IllegalAccessException {
        Person person = new Person();
        Field[] fields = person.getClass().getDeclaredFields();
        for(Field field : fields) {
            Class cls = field.getType();
            String clsName = cls.getSimpleName();
            String clsSS  = cls.getName();
            if(cls.isArray())
            {
                Class clsss = cls.getComponentType();
                Log.v("TAG",clsss.getName());
                Object[] arr = (Object[]) Array.newInstance(clsss,15);
            }
            Type type = field.getGenericType();
            if(type instanceof ParameterizedType) {
                ParameterizedType type1 = (ParameterizedType) field.getGenericType();
                Class ccc = (Class) type1.getActualTypeArguments()[0];
                String name = ccc.getSimpleName();
            }
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void ceshi()
    {
        User user = new User();
        user.setmAge(23);
        user.setmCareer("软件工程师");
        user.setmSex("男");
        user.setName("大圣");
        user.a = new User.A();
        user.a.b = new User.A.B();
        user.a.b.c = new User.A.B.C();
        user.a.b.c.d = new User.A.B.C.D();
        user.a.b.c.d.love = "zhege shi zhen shen";
        Person person = new Person();

        Crowd src = new Crowd();
        src.list = new User[4];
        src.list[0] = user;
        src.list[1] = user;
        src.list[2] = user;
        src.list[3] = user;

        People goal = new People();

        FieldResolver fieldResolver = new FieldResolver();
        person = fieldResolver.execSetParam(user,person);
        Gson gson = new Gson();
        String log = gson.toJson(person);
        Log.v("MainActivity",log);
        fieldResolver.toString();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private void init()
    {
        initAllBtn();
        MainHandler handler = new MainHandler(this);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),"测试Handler内存泄漏问题",Toast.LENGTH_SHORT).show();
            }
        },5*1000);
    }


    private void letBtnJump(final JumpBtn jumpBtn)
    {
        jumpBtn.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JumpUtils.jumpFromMain(MainActivity.this,jumpBtn.cls);
            }
        });
    }

    private List<JumpBtn> collectBtns()
    {
        btnList.clear();
        add(new JumpBtn(animDemoBtn,AnimActivity.class));
        add(new JumpBtn(imgPrevBtn,GridImageActivity.class));
        add(new JumpBtn(btnZxing,ZxingActivity.class));
        add(new JumpBtn(btnToolBar,ToolBarActivity.class));
        add(new JumpBtn(viewPager_fragmentBtn,ViewPagerFragmentActivity.class));
        add(new JumpBtn(viewPagerDemoBtn,ViewPagerActivity.class));
        add(new JumpBtn(oneActManyFragmetsBtn,FragmentsDemoNavActivity.class));
        add(new JumpBtn(btnMvp,MVPLoginActivity.class));
        return btnList;
    }

    private void add(JumpBtn jumpBtn)
    {
        btnList.add(jumpBtn);
    }

    private void initAllBtn()
    {
        collectBtns();
        for(int i = 0;i < btnList.size();i ++){
            letBtnJump(btnList.get(i));
        }
    }


    public class JumpBtn{
        public Button btn;
        public Class cls;

        public JumpBtn()
        {
        }

        public JumpBtn(Button btn , Class cls){
            this.btn = btn;
            this.cls = cls;
        }
    }
}
