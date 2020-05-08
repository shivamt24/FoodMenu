package com.example.foodmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_details.*
import kotlinx.android.synthetic.main.food_ticket.*

class FoodDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)
        val bundle = intent.extras
        ivImage.setImageResource(bundle.getInt("image"))
        tvText.text = bundle.getString("name")
        tvDetails.text = bundle.getString("des")
    }
}
