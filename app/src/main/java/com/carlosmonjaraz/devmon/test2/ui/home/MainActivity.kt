package com.carlosmonjaraz.devmon.test2.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlosmonjaraz.devmon.test2.R
import com.carlosmonjaraz.devmon.test2.databinding.ActivityProductsBinding
import com.carlosmonjaraz.devmon.test2.ui.details.DetailsActivity
import com.carlosmonjaraz.devmon.test2.ui.home.model.Product
import com.carlosmonjaraz.devmon.test2.ui.infrastucture.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProductsBinding
    private val viewModel : MainActivityViewModel by viewModels()

    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        adapter = ProductAdapter {
            product -> navigateToDetail(product)
        }
        binding.rvProducts.layoutManager = LinearLayoutManager(this)
        binding.rvProducts.adapter = adapter

        initListeners()
        initObservers()
    }

    private fun initListeners() {
        viewModel.loadData()
    }

    private fun initObservers() {
        viewModel.products.observe(this) {
            adapter.updateList(it)
        }
    }

    private fun navigateToDetail(product: Product) {
        startActivity(DetailsActivity.create(this, product))
    }
}