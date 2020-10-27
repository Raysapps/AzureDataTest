package com.temp.azuredatatest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.azure.data.AzureData
import com.azure.data.model.PermissionMode
import com.temp.azuredatatest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mainModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.apply {
            viewmodel = mainModel
            lifecycleOwner = this@MainActivity
        }



    }

}