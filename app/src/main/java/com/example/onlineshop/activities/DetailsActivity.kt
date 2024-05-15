package com.example.onlineshop.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineshop.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    val binding: ActivityDetailsBinding by lazy {
        ActivityDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val image = intent.getIntExtra("image", 0)
        val price = intent.getStringExtra("price")
        val title = intent.getStringExtra("title")
        val rating = intent.getStringExtra("rating")


        binding.productImage.setImageResource(image)
        binding.productRating.text = rating
        binding.productPRice.text = price
        binding.productTitle.text = title

        binding.back.setOnClickListener {
            finish()
        }

    }
}