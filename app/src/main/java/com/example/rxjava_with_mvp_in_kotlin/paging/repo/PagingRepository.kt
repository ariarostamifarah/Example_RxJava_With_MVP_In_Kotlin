package com.example.rxjava_with_mvp_in_kotlin.paging.repo

import androidx.paging.*
import androidx.paging.rxjava2.observable
import com.example.rxjava_with_mvp_in_kotlin.paging.dataSource.DataPagingDataSource


/**
 * Created by aria rostami farah on 7/6/21
 */
class PagingRepository(private val dataPagingDataSource: DataPagingDataSource) {


    fun getProducts() = Pager(
        config = PagingConfig(20 , 4 , true , 20  , 30),
        initialKey = 1,
        pagingSourceFactory = { dataPagingDataSource }
    ).observable





}