package com.example.recyclerdemo.di.builder

import com.example.recyclerdemo.ui.list.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
 abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMain(): MainActivity
}