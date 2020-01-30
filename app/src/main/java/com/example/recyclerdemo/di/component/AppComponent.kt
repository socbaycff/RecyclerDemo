package com.example.recyclerdemo.di.component

import com.example.recyclerdemo.di.builder.ActivityBuilder
import com.example.recyclerdemo.di.modules.ActivityModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication


@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilder::class, ActivityModule::class])
interface AppComponent: AndroidInjector<DaggerApplication> {

    @Component.Factory
    interface Factory {

        fun create(): AppComponent
    }
}