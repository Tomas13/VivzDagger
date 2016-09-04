package com.example.zhangali.vivzdagger.modules;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.zhangali.vivzdagger.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangali on 04.09.16.
 */

@Module
public class StorageModule {
    private final MyApplication application;

    public StorageModule(MyApplication application) {
        this.application = application;
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}
