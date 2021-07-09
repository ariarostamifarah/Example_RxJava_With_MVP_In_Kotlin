package com.example.rxjava_with_mvp_in_kotlin.activities.detailsActivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.TransitionInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.lifecycle.lifecycleScope
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.bumptech.glide.signature.ObjectKey
import com.example.rxjava_with_mvp_in_kotlin.R
import com.example.rxjava_with_mvp_in_kotlin.activities.base.BaseActivity
import com.example.rxjava_with_mvp_in_kotlin.activities.mainActivity.MainActivity
import com.example.rxjava_with_mvp_in_kotlin.model.Data
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@SuppressLint("NonConstantResourceId")
class DetailsActivity : BaseActivity() {


    @BindView(R.id.activity_details_rootView)
    lateinit var rootView: ConstraintLayout

    @BindView(R.id.activity_details_Image)
    lateinit var image: ImageView

    @BindView(R.id.activity_details_Title)
    lateinit var title: TextView

    @BindView(R.id.activity_details_PriceValue)
    lateinit var priceValue: TextView

    @BindView(R.id.activity_details_description)
    lateinit var description: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        ButterKnife.bind(this)
        //toolBar
        initAppBar(resources.getString(R.string.detailsActivity_title), true)


        postponeEnterTransition()
        rootView.scheduleStartPostponedEnterTransition()
        //to call onActivityReenter in prev activity
        setResult(RESULT_OK)

        //inflate transition
        val mySlideTransition =
            TransitionInflater.from(this).inflateTransition(R.transition.myslide)
        mySlideTransition.interpolator = FastOutSlowInInterpolator()
        window.enterTransition = mySlideTransition


        //set content
        if (intent.hasExtra(MainActivity.IntentDataKey)) {

            intent.extras?.getSerializable(MainActivity.IntentDataKey)
                ?.let { it as? Data }
                ?.also { data ->

                    val signatureUrl = intent.getLongExtra(MainActivity.IntentSignatureUrlKey, 0L)

                    if (signatureUrl != 0L) Glide.with(image).load(data.image)
                        .signature(ObjectKey(signatureUrl))
                        .centerCrop().into(image)



                    title.text = data.name
                    priceValue.text = data.price
                    description.text = data.description
                }


        }


        //back listener
        back.setOnClickListener { onBackPressed() }


    }


    override fun onBackPressed() {
        lifecycleScope.launch {
            initAppBar(resources.getString(R.string.mainActivity_title), false)
            delay(30)
            super.onBackPressed()

        }
    }


}