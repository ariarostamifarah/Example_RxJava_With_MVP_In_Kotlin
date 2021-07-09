package com.example.rxjava_with_mvp_in_kotlin.util.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import java.lang.IllegalStateException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by aria rostami farah on 7/5/21
 */
class AutoClearedValue<T : Any>(private val activity: AppCompatActivity) :
    ReadWriteProperty<AppCompatActivity, T> {


    private var _tmpValue: T? = null
    private lateinit var observer: DefaultLifecycleObserver

    init {

        observer = object : DefaultLifecycleObserver {

            override fun onDestroy(owner: LifecycleOwner) {
                super.onDestroy(owner)

                _tmpValue = null
                activity.lifecycle.removeObserver(observer)
            }

        }

        activity.lifecycle.addObserver(observer)

    }


    override fun setValue(thisRef: AppCompatActivity, property: KProperty<*>, value: T) {

        _tmpValue = value
    }

    override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): T {


        return _tmpValue
            ?: throw IllegalStateException("should never call auto-cleared-value get when it might not be available")

    }


}

fun <T : Any> AppCompatActivity.autoCleared() = AutoClearedValue<T>(this)