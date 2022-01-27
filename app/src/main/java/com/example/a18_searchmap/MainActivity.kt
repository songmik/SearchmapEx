package com.example.a18_searchmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.a18_searchmap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SearchRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initAdapter()
        initViews()
    }

    private fun initViews() = with(binding) {
        emptyResultTextView.isVisible = false
        recyclerView.adapter = adapter

    }

    private fun initAdapter(){
        adapter = SearchRecyclerAdapter{
            Toast.makeText(this, "아이템 클릭" , Toast.LENGTH_SHORT).show()
        }
    }

    private fun initData(){
        
    }
}