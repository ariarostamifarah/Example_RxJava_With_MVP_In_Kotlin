package com.example.rxjava_with_mvp_in_kotlin.activities.mainActivity

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.paging.LoadStateAdapter
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.bumptech.glide.signature.ObjectKey
import com.example.rxjava_with_mvp_in_kotlin.R
import com.example.rxjava_with_mvp_in_kotlin.model.Data
import com.example.rxjava_with_mvp_in_kotlin.model.DiffData

/**
 * Created by aria rostami farah on 7/6/21
 */
class DataAdapter : PagingDataAdapter<Data, DataAdapter.DataViewHolder>(DiffData) {


    interface OnClickListener {

        fun onClickItem(
            data: Data,
            signatureUrl: Long
        )
    }


    var onClickListener: OnClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)

        return DataViewHolder(view)
    }


    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {


        getItem(position)?.also { holder.bindItems(it) }


    }




    fun withLoadStateAll(
        header: LoadStateAdapter<*>,
        footer: LoadStateAdapter<*>,
        refresh: LoadStateAdapter<*>
    ): ConcatAdapter {
        addLoadStateListener { loadStates ->
            header.loadState = loadStates.prepend
            footer.loadState = loadStates.append
            refresh.loadState = loadStates.refresh
        }
        return ConcatAdapter(refresh, header, this, footer)
    }


    //Holder-----------------------------------------------------------------------------

    @SuppressLint("NonConstantResourceId")
    inner class DataViewHolder( val view: View) : RecyclerView.ViewHolder(view) {


        @BindView(R.id.item_data_rootView)
        lateinit var rootView: ConstraintLayout

        @BindView(R.id.item_data_Image)
        lateinit var image: ImageView

        @BindView(R.id.item_data_Title)
        lateinit var title: TextView

        @BindView(R.id.item_data_TitlePrice)
        lateinit var titlePrice: TextView

        @BindView(R.id.item_data_PriceValue)
        lateinit var priceValue: TextView

        init {
            ButterKnife.bind(this, view)
        }


        fun bindItems(data: Data) {



            val signatureUrl = System.currentTimeMillis()

            Glide.with(image).load(data.image).signature(ObjectKey(signatureUrl)).centerCrop()
                .into(image)
            title.text = data.name
            titlePrice.text = view.resources.getString(R.string.label_priceProducts)
            priceValue.text = data.price


            //rootView click listener
            rootView.setOnClickListener {

                 onClickListener?.onClickItem(
                    data,
                    signatureUrl
                )

            }



        }


    }


}