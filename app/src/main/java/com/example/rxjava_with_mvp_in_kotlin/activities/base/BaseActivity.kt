package com.example.rxjava_with_mvp_in_kotlin.activities.base

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.doOnPreDraw
import butterknife.BindView
import com.example.rxjava_with_mvp_in_kotlin.R

/**
 * Created by aria rostami farah on 7/4/21
 */

@SuppressLint("NonConstantResourceId")
@Suppress("DEPRECATION")
abstract class BaseActivity : AppCompatActivity() {


    @BindView(R.id.include_appbar)
    protected lateinit var appBar: View

    private lateinit var toolbar: Toolbar
    protected lateinit var back: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configStatusBar()
    }

    private fun configStatusBar() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.black)
        }
    }


    protected fun View.scheduleStartPostponedEnterTransition() {

        doOnPreDraw { startPostponedEnterTransition() }
    }


    //before use, you must implement appBar property
    protected fun initAppBar(title: String, showBack: Boolean) {

        toolbar = appBar.findViewById(R.id.appbar_toolbar)
        back = appBar.findViewById(R.id.appBar_back_toolbar)
        toolbar.title = title
        if (showBack) back.visibility = View.VISIBLE
        else back.visibility = View.GONE
    }


}