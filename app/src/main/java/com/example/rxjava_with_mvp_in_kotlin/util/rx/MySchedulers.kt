package com.example.rxjava_with_mvp_in_kotlin.util.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by aria rostami farah on 7/5/21
 */
class MySchedulers @Inject constructor(){


    fun io():Scheduler = Schedulers.io()

    fun computation():Scheduler = Schedulers.computation()

    fun ui():Scheduler = AndroidSchedulers.mainThread()


}