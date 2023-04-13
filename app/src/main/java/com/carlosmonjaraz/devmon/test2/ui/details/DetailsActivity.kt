package com.carlosmonjaraz.devmon.test2.ui.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.carlosmonjaraz.devmon.test2.R
import com.carlosmonjaraz.devmon.test2.databinding.ActivityDetailsBinding
import com.carlosmonjaraz.devmon.test2.ui.home.model.Product

class DetailsActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_ID = "product"

        fun create(context: Context, product : Product): Intent {
            return Intent(context, DetailsActivity::class.java).apply {
                putExtra(EXTRA_ID, product)
            }
        }
    }

    private lateinit var binding : ActivityDetailsBinding
    private lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        product = intent.getSerializableExtra(EXTRA_ID) as Product

        initUI()
    }

    private fun initUI() {
        binding.txtTitle.setText(product.title)
        binding.txtDescription.setText(product.description)
        binding.txtPrice.setText("Precio: ${product.price}")
        Glide.with(this).load(product.image).into(binding.img)

        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}