package com.carlosmonjaraz.devmon.test2.ui.infrastucture

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carlosmonjaraz.devmon.test2.R
import com.carlosmonjaraz.devmon.test2.ui.home.model.Product

class ProductAdapter(
    private var listProducts : List<Product> = emptyList(),
    private val onItemClick : (Product) -> Unit
) : RecyclerView.Adapter<ProductHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductHolder(layoutInflater.inflate(R.layout.item_product, parent, false))
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val item = listProducts[position]

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }

        holder.render(item)
    }

    override fun getItemCount(): Int = listProducts.size

    fun updateList(list: List<Product>) {
        this.listProducts = list
        notifyDataSetChanged()
    }
}