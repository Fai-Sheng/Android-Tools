package com.fai.tools.dagger.component;

import android.content.Context;

import com.fai.tools.app.ToolsApplication;
import com.fai.tools.retrofit.RetrofitApi;
import com.fai.tools.dagger.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by PVer on 2018/3/15.
 *
 * 全局的 Component
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    RetrofitApi provideRestApi();

    Context provideContext();

    ToolsApplication provideApplication();

}
