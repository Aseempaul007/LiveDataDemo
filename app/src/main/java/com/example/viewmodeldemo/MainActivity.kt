package com.example.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeldemo.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainViewModel= ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.liveString.observe(this){
            mainBinding.tv.text= it
        }

        mainBinding.btn.setOnClickListener {


            CoroutineScope(Dispatchers.Main).launch {
                mainViewModel.changeLiveString()
            }
        }



    }
}