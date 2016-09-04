package com.example.zhangali.vivzdagger;

import android.app.Application;

import com.example.zhangali.vivzdagger.components.DaggerStorageComponent;
import com.example.zhangali.vivzdagger.components.StorageComponent;
import com.example.zhangali.vivzdagger.modules.StorageModule;

/**
 * Created by zhangali on 04.09.16.
 */
public class MyApplication extends Application {

    StorageComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerStorageComponent
                .builder()
                .storageModule(new StorageModule(this))
                .build();
    }

    public StorageComponent getComponent() {
        return component;
    }
}
