package com.example.rxjava_with_mvp_in_kotlin.presenter



import com.example.rxjava_with_mvp_in_kotlin.remote.ApiService
import com.example.rxjava_with_mvp_in_kotlin.paging.repo.PagingRepository
import com.example.rxjava_with_mvp_in_kotlin.util.rx.AutoDispose
import com.example.rxjava_with_mvp_in_kotlin.util.rx.MyDisposable
import com.example.rxjava_with_mvp_in_kotlin.util.rx.MySchedulers
import com.example.rxjava_with_mvp_in_kotlin.view.MainView



/**
 * Created by aria rostami farah on 7/4/21
 */


class MainPresenter(
    private val view: MainView,
    private val remote: ApiService,
    private val pagingRepository: PagingRepository,
    private val mySchedulers: MySchedulers,
    myDisposable: MyDisposable
) : AutoDispose by myDisposable {



    fun getProducts() =  pagingRepository.getProducts()
        .subscribeOn(mySchedulers.computation())
        .observeOn(mySchedulers.ui())
        //check null value
//            .map { pagingData ->
//                pagingData.filter { it != null }
//            }
        .subscribe({

            view.successGetProducts(it)
        }, {}).disposeWith(view)


    fun getProductsWithOutPaging(page: Long) =
        remote.getProducts(page).subscribeOn(mySchedulers.io()).observeOn(mySchedulers.ui())
            .subscribe({

                view.successGetProducts(it)

            }, {

                view.errorGetProducts(it)
            }).disposeWith(view)


}