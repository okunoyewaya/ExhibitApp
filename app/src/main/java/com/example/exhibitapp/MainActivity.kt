package com.example.exhibitapp

import com.example.exhibitapp.adapters.ParentAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import com.example.exhibitapp.repository.Repository
import com.example.exhibitapp.viewmodel.ExhibitViewModel
import com.example.exhibitapp.viewmodel.ExhibitViewModelFactory

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: ExhibitViewModel
    private val myAdapter by lazy { ParentAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecyclerView()

        val repository = Repository()
        val viewModelFactory = ExhibitViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ExhibitViewModel::class.java)

        viewModel.getExhibit()
        viewModel.exhibitResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                // Response exhibit list with duplicates filtered out
                val exhibitList = response.body()?.take(3)
                myAdapter.differ.submitList(exhibitList)
            } else {
                Toast.makeText(this, response.errorBody().toString(), Toast.LENGTH_LONG).show()
            }
        })


    }

    //sets recyclerView in activity
    private fun setUpRecyclerView() {
        rvParent.adapter = myAdapter
        rvParent.layoutManager = LinearLayoutManager(this)
        rvParent.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

}