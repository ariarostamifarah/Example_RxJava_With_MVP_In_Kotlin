package com.example.rxjava_with_mvp_in_kotlin.util.rx

import androidx.lifecycle.LifecycleOwner
import io.reactivex.disposables.Disposable

/**
 * Created by aria rostami farah on 7/5/21
 */
interface AutoDispose {

     infix fun Disposable.disposeWith(lifecycleOwner: LifecycleOwner)
}