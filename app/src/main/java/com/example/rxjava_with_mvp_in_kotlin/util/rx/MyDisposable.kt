package com.example.rxjava_with_mvp_in_kotlin.util.rx

import androidx.lifecycle.*
import io.reactivex.disposables.Disposable


/**
 * Created by aria rostami farah on 7/5/21
 */
class MyDisposable : AutoDispose {

    private lateinit var observer: LifecycleObserver

    override fun Disposable.disposeWith(lifecycleOwner: LifecycleOwner) {


        observer = object : LifecycleObserver {


            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            fun onStop() {

                this@disposeWith.dispose()
                lifecycleOwner.lifecycle.removeObserver(observer)


            }


        }

        lifecycleOwner.lifecycle.addObserver(observer)

    }
}