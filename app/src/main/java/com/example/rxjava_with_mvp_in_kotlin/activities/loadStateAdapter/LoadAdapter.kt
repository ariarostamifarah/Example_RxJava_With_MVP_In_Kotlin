package com.example.rxjava_with_mvp_in_kotlin.activities.loadStateAdapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.rxjava_with_mvp_in_kotlin.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Created by aria rostami farah on 7/6/21
 */
class LoadAdapter(private val reply: () -> Unit) : LoadStateAdapter<LoadAdapter.LoadHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadHolder {


        return LoadHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_loadstate, parent, false)
        )

    }


    override fun onBindViewHolder(holder: LoadHolder, loadState: LoadState) {

        holder.setLoadState(loadState)
    }


    @SuppressLint("NonConstantResourceId")
    inner class LoadHolder(private val view: View) : RecyclerView.ViewHolder(view) {


        @BindView(R.id.progressBar)
        lateinit var progressBar: ProgressBar

        @BindView(R.id.reply)
        lateinit var replyView: FloatingActionButton

        init {

            ButterKnife.bind(this, view)
            replyView.setOnClickListener { reply.invoke() }

        }


        fun setLoadState(loadState: LoadState) {


            when (loadState) {

                is LoadState.Loading -> {

                    progressBar.visibility = View.VISIBLE
                    replyView.visibility = View.GONE

                }
                is LoadState.Error -> {

                    progressBar.visibility = View.GONE
                    replyView.visibility = View.VISIBLE

                    Toast.makeText(
                        view.context,
                        view.context.resources.getString(R.string.error_unavailable_network),
                        Toast.LENGTH_LONG
                    ).show()

                }
                else -> {

                    progressBar.visibility = View.GONE
                    replyView.visibility = View.GONE

                }


            }


        }


    }


}