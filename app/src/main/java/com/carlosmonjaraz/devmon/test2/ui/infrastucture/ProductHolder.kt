package com.carlosmonjaraz.devmon.test2.ui.infrastucture

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.carlosmonjaraz.devmon.test2.databinding.ItemProductBinding
import com.carlosmonjaraz.devmon.test2.ui.home.model.Product

class ProductHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemProductBinding.bind(view)

    fun render(product: Product) {
        binding.txtTitle.setText("Nombre: ${product.title}")
        binding.txtDescription.setText(product.description)
        binding.txtPrice.setText("Precio: ${product.price}")
    }
}