package com.example.rxjava_with_mvp_in_kotlin.di.module

import com.example.rxjava_with_mvp_in_kotlin.di.scope.ActivityScope
import com.example.rxjava_with_mvp_in_kotlin.remote.ApiService
import com.example.rxjava_with_mvp_in_kotlin.paging.dataSource.DataPagingDataSource
import dagger.Module
import dagger.Provides

/**
 * Created by aria rostami farah on 7/6/21
 */
@Module
class PagingDataSourceModule {


    @ActivityScope
    @Provides
    fun provideDataPagingDataSource(remote:ApiService): DataPagingDataSource = DataPagingDataSource(remote)


}