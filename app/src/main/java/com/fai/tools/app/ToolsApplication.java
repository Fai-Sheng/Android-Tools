package com.fai.tools.app;

import android.app.Application;
import android.widget.Toast;

import com.fai.tools.dagger.component.AppComponent;
import com.fai.tools.dagger.component.DaggerAppComponent;
import com.fai.tools.dagger.module.AppModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by PVer on 2018/3/15.
 */

public class ToolsApplication extends Application{

    private AppComponent appComponent = null;

    @Override
    public void onCreate() {
        super.onCreate();

        if(appComponent == null)
        {
            appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        }

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }


    public AppComponent getAppComponent()
    {
        return appComponent;
    }


    public void toast()
    {
        Toast.makeText(this,"sssss",Toast.LENGTH_SHORT).show();
    }
}
