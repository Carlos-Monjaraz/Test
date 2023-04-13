package com.carlosmonjaraz.devmon.test2.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlosmonjaraz.devmon.test2.domain.usecases.GetProducts
import com.carlosmonjaraz.devmon.test2.ui.home.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getProducts: GetProducts
) : ViewModel() {
    private val _products = MutableLiveData<List<Product>>()
    val products : LiveData<List<Product>>
        get() = _products


    fun loadData() {
        viewModelScope.launch {
            _products.value = getProducts()!!
        }
    }
}