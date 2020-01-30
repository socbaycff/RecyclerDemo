package com.example.recyclerdemo.di.modules

import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    fun provideArray(): ArrayList<String> = arrayListOf<String>("asd", "dsa", "pop", "dqwdqqd")
}