package com.example.rxjava_with_mvp_in_kotlin.application

import android.app.Activity
import android.app.Application
import com.example.rxjava_with_mvp_in_kotlin.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by aria rostami farah on 7/4/21
 */
class MyApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()


        //Initial dagger
        DaggerAppComponent.builder().application(this).build().inject(this)


    }

    override fun activityInjector(): AndroidInjector<Activity> {

        return dispatchingAndroidInjector
    }


}