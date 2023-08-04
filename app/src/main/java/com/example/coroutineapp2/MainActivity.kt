package com.example.coroutineapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.coroutineapp2.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        SayHelloFromMainThread()
        SayHelloFromBackThread()
    }
    private fun SayHelloFromMainThread() {
        CoroutineScope(Dispatchers.Main).launch {
            binding.text1.text = "Hello From" +
                    "${Thread.currentThread().name}"
        }

    }

    private fun SayHelloFromBackThread() {
        CoroutineScope(Dispatchers.IO).launch {
            binding.text2.text = "Hello from" +
                    "${Thread.currentThread().name}"
        }

    }


}