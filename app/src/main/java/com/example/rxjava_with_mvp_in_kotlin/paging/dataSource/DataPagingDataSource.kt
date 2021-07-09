package com.example.rxjava_with_mvp_in_kotlin.paging.dataSource


import androidx.paging.rxjava2.RxPagingSource

import com.example.rxjava_with_mvp_in_kotlin.model.Data
import com.example.rxjava_with_mvp_in_kotlin.model.ProductsResult
import com.example.rxjava_with_mvp_in_kotlin.remote.ApiService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers


/**
 * Created by aria rostami farah on 7/6/21
 */
class DataPagingDataSource(private val remote: ApiService) : RxPagingSource<Long, Data>() {


    override fun loadSingle(params: LoadParams<Long>): Single<LoadResult<Long, Data>> {

        val page = params.key ?: 1


        return remote.getProducts(page).subscribeOn(Schedulers.io()).map {

            loadResult(it, page)

        }.onErrorReturn {
            LoadResult.Error(it)
        }


    }


    private fun loadResult(
        productsResult: ProductsResult,
        page: Long
    ): LoadResult<Long, Data> {


        return LoadResult.Page(
            data = productsResult.data,
            prevKey = if (page == 1L) null else page - 1,
            nextKey = if (page == productsResult.meta.pagination.pages.toLong()) null else page + 1
        )


    }


}