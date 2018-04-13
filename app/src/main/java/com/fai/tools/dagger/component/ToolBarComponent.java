package com.fai.tools.dagger.component;

import com.fai.tools.dagger.annotations.PerActivity;
import com.fai.tools.dagger.module.ToolBarModule;
import com.fai.tools.ui.toolbar.ToolBarActivity;

import dagger.Component;

/**
 * Created by PVer on 2018/3/22.
 */
@PerActivity
@Component(dependencies = {AppComponent.class},modules = {ToolBarModule.class})
public interface ToolBarComponent {
    void inject(ToolBarActivity activity);
}
