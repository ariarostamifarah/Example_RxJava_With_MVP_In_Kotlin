package com.example.rxjava_with_mvp_in_kotlin.di.module

import com.example.rxjava_with_mvp_in_kotlin.di.scope.ActivityScope
import com.example.rxjava_with_mvp_in_kotlin.paging.dataSource.DataPagingDataSource
import com.example.rxjava_with_mvp_in_kotlin.paging.repo.PagingRepository
import dagger.Module
import dagger.Provides

/**
 * Created by aria rostami farah on 7/6/21
 */

@Module
class RepositoryModule {


    @ActivityScope
    @Provides
    fun providePagingRepository(dataPagingDataSource: DataPagingDataSource): PagingRepository =
        PagingRepository(dataPagingDataSource)


}