package com.example.rxjava_with_mvp_in_kotlin.activities.mainActivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.doOnPreDraw
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import butterknife.BindView
import butterknife.ButterKnife
import com.example.rxjava_with_mvp_in_kotlin.R
import com.example.rxjava_with_mvp_in_kotlin.activities.base.BaseActivity
import com.example.rxjava_with_mvp_in_kotlin.util.activity.autoCleared
import com.example.rxjava_with_mvp_in_kotlin.activities.detailsActivity.DetailsActivity
import com.example.rxjava_with_mvp_in_kotlin.activities.loadStateAdapter.LoadAdapter
import com.example.rxjava_with_mvp_in_kotlin.model.Data
import com.example.rxjava_with_mvp_in_kotlin.presenter.MainPresenter
import com.example.rxjava_with_mvp_in_kotlin.view.MainView
import dagger.android.AndroidInjection


import javax.inject.Inject


@SuppressLint("NonConstantResourceId")
class MainActivity : BaseActivity(), MainView, DataAdapter.OnClickListener {


    companion object {

        const val IntentDataKey = "dataOfIntent_MainActivity"
        const val IntentSignatureUrlKey = "signatureUrl_MainActivity"
    }


    @Inject
    lateinit var presenter: MainPresenter


    private var dataAdapter by autoCleared<DataAdapter>()


    @BindView(R.id.activity_main_RecyclerView)
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        //get Products
        presenter.getProducts()

        //toolBar
        initAppBar(resources.getString(R.string.mainActivity_title), false)


    }


    override fun successGetProducts(pagingData: PagingData<Data>) {


        dataAdapter = DataAdapter()
        //set listener
        dataAdapter.onClickListener = this




        recyclerView.apply {

            adapter = dataAdapter.apply {

                submitData(lifecycle, pagingData)
            }

            adapter = dataAdapter.withLoadStateAll(
                LoadAdapter { dataAdapter.retry() },
                LoadAdapter { dataAdapter.retry() },
                LoadAdapter { dataAdapter.retry() }
            )

            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

            setHasFixedSize(true)
            setItemViewCacheSize(25)

        }


    }


    override fun onClickItem(data: Data, signatureUrl: Long) {

        val intent = Intent(this@MainActivity, DetailsActivity::class.java)

        intent.putExtra(IntentDataKey, data)
        intent.putExtra(IntentSignatureUrlKey, signatureUrl)


        val activityOptions =
            ActivityOptionsCompat.makeSceneTransitionAnimation(this)

        startActivity(
            intent,
            activityOptions.toBundle()
        )

    }

    override fun onActivityReenter(resultCode: Int, data: Intent?) {
        super.onActivityReenter(resultCode, data)
        postponeEnterTransition()
        recyclerView.doOnPreDraw {
            startPostponedEnterTransition()
        }

    }


}