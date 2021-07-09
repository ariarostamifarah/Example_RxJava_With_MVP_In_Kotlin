package com.example.rxjava_with_mvp_in_kotlin.di.module

import com.example.rxjava_with_mvp_in_kotlin.di.scope.ActivityScope
import com.example.rxjava_with_mvp_in_kotlin.presenter.MainPresenter
import com.example.rxjava_with_mvp_in_kotlin.remote.ApiService
import com.example.rxjava_with_mvp_in_kotlin.paging.repo.PagingRepository
import com.example.rxjava_with_mvp_in_kotlin.util.rx.MyDisposable
import com.example.rxjava_with_mvp_in_kotlin.util.rx.MySchedulers
import com.example.rxjava_with_mvp_in_kotlin.view.MainView
import dagger.Module
import dagger.Provides

/**
 * Created by aria rostami farah on 7/4/21
 */

@Module
class PresentersModule {




    @ActivityScope
    @Provides
    fun provideMainPresenter(
        mainView: MainView,
        apiService: ApiService,
        pagingRepository: PagingRepository,
        mySchedulers: MySchedulers,
        myDisposable: MyDisposable
    ): MainPresenter =
        MainPresenter(mainView, apiService, pagingRepository, mySchedulers, myDisposable)


}