package com.example.rxjava_with_mvp_in_kotlin.di.component

import com.example.rxjava_with_mvp_in_kotlin.application.MyApplication
import com.example.rxjava_with_mvp_in_kotlin.di.module.BuildersModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by aria rostami farah on 7/4/21
 */

@Singleton
@Component(modules = [AndroidInjectionModule::class, BuildersModule::class])
interface AppComponent {


    fun inject(app: MyApplication)


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder
        fun build(): AppComponent
    }


}