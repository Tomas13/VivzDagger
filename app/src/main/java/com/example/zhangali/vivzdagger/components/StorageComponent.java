package com.example.zhangali.vivzdagger.components;

import com.example.zhangali.vivzdagger.modules.StorageModule;
import com.example.zhangali.vivzdagger.views.FragmentA;
import com.example.zhangali.vivzdagger.views.FragmentB;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhangali on 04.09.16.
 */

@Singleton
@Component(modules = StorageModule.class)
public interface StorageComponent {
    void inject(FragmentA fragmentA);
    void inject(FragmentB fragmentb);
}
