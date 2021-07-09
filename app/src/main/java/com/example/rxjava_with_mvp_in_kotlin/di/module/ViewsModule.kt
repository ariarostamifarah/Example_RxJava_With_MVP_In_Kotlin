package com.example.rxjava_with_mvp_in_kotlin.di.module

import com.example.rxjava_with_mvp_in_kotlin.activities.mainActivity.MainActivity
import com.example.rxjava_with_mvp_in_kotlin.di.scope.ActivityScope
import com.example.rxjava_with_mvp_in_kotlin.view.MainView
import dagger.Binds
import dagger.Module

/**
 * Created by aria rostami farah on 7/4/21
 */

@Module
abstract class ViewsModule {


    @ActivityScope
    @Binds
    abstract fun bindMainView(mainActivity: MainActivity):MainView




}