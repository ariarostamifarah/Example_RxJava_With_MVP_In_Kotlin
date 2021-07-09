package com.example.rxjava_with_mvp_in_kotlin.view

import androidx.lifecycle.LifecycleOwner
import androidx.paging.PagingData
import com.example.rxjava_with_mvp_in_kotlin.model.Data
import com.example.rxjava_with_mvp_in_kotlin.model.ProductsResult

/**
 * Created by aria rostami farah on 7/4/21
 */

interface MainView : LifecycleOwner  {



    fun successGetProducts(pagingData: PagingData<Data>)
    //if you won't want use to paging
    fun successGetProducts(result: ProductsResult){}
    fun errorGetProducts(throwable: Throwable){}




}