package com.fai.tools.dagger.module;

import dagger.Module;
import dagger.Provides;

/**
 * Created by PVer on 2018/3/22.
 */

@Module
public class ToolBarModule {

    @Provides
    public Integer provideInteger()
    {
        return new Integer(3);
    }
}
