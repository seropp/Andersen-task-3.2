package com.example.imageloader.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.imageloader.R
import androidx.lifecycle.ViewModelProvider
import com.example.imageloader.databinding.ActivityMainBinding
import com.example.imageloader.di.App
import com.example.imageloader.presentation.mvvm.MainViewModel
import com.example.imageloader.presentation.mvvm.MainViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: MainViewModel

    @javax.inject.Inject
    lateinit var vmFactory: MainViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)

        vm = ViewModelProvider(this, vmFactory)[MainViewModel::class.java]

        vm.getLiveData().observe(this, Observer {
            if ( it == null) {
                binding.image.setImageDrawable(null)
                binding.image.setBackgroundResource(R.drawable.whoops)
            }
            else binding.image.setImageBitmap(it)
        })

        binding.btnLoad.setOnClickListener {
            val url: String = binding.etUrl.text.toString()
            vm.loadBitmap(url = url)
        }
    }
}