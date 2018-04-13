package com.fai.tools.dagger.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.fai.tools.app.ToolsApplication;
import com.fai.tools.retrofit.RetrofitApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by PVer on 2018/3/15.
 */

@Module
public class AppModule {

    private ToolsApplication application;
//    private static final String SP_NAME = "sp";

    public AppModule(ToolsApplication application) {
        this.application = application;
    }


    @Singleton
    @Provides
    public ToolsApplication provideApplication() {
        return application;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return application;
    }


    @Singleton
    @Provides
    public RetrofitApi provideRestApi() {
        return new RetrofitApi();
    }

    public SharedPreferences provideSharePreferences()
    {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}
