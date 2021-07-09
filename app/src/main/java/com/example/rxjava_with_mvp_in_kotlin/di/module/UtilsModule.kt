package com.example.rxjava_with_mvp_in_kotlin.di.module

import com.example.rxjava_with_mvp_in_kotlin.di.scope.ActivityScope
import com.example.rxjava_with_mvp_in_kotlin.util.rx.MyDisposable
import com.example.rxjava_with_mvp_in_kotlin.util.rx.MySchedulers
import dagger.Module
import dagger.Provides

/**
 * Created by aria rostami farah on 7/5/21
 */
@Module
class UtilsModule {


    @ActivityScope
    @Provides
    fun provideMySchedulers():MySchedulers =  MySchedulers()


    @ActivityScope
    @Provides
    fun provideMyDisposable(): MyDisposable = MyDisposable()


}