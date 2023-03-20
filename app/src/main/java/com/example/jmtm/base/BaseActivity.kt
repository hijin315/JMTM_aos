package com.example.jmtm.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes private val layoutResId: Int
) : AppCompatActivity() {

    abstract val viewModel: VM

    // 바인딩할 뷰 연결
    val binding: VB by lazy {
        DataBindingUtil.setContentView<VB>(this, layoutResId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
    }

    // viewModel 관찰
    abstract fun setUpObserve()
}