package com.example.rxjava_with_mvp_in_kotlin.di.module

import com.example.rxjava_with_mvp_in_kotlin.activities.mainActivity.MainActivity
import com.example.rxjava_with_mvp_in_kotlin.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by aria rostami farah on 7/4/21
 */

@Module
abstract class BuildersModule {


    @ActivityScope
    @ContributesAndroidInjector(modules = [
        UtilsModule::class,
        RemoteModule::class,
        PresentersModule::class,
        ViewsModule::class,
        RepositoryModule::class,
        PagingDataSourceModule::class
    ])
    abstract fun bindMainActivity(): MainActivity


}