package com.example.foodmenu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {

    var adapter:FoodAdapter?=null
    var listOfFood = ArrayList<Food>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load Foods
        listOfFood.add(Food("coffee","Coffee description",R.drawable.coffee_pot))
        listOfFood.add(Food("espresso","espresso description",R.drawable.espresso))
        listOfFood.add(Food("french_fries","french_fries description",R.drawable.french_fries))
        listOfFood.add(Food("honey","honey description",R.drawable.honey))
        listOfFood.add(Food("sugar cubes","sugar description",R.drawable.sugar_cubes))
        listOfFood.add(Food("Ice-cream","Ice-cream description",R.drawable.strawberry_ice_cream))
        adapter = FoodAdapter(this,listOfFood)
        gvListFood.adapter = adapter
    }
    class FoodAdapter:BaseAdapter{
        var listOfFood = ArrayList<Food>()
        var context:Context?=null
        constructor(context:Context,ListOfFood:ArrayList<Food>):super(){
            this.context = context
            this.listOfFood = ListOfFood
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val food = this.listOfFood[position]
            val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val foodView = inflator.inflate(R.layout.food_ticket,null)
            foodView.ivFoodImage.setImageResource(food.image!!)
            foodView.tvTextView.text = food.name!!
            foodView.ivFoodImage.setOnClickListener{
                val intent = Intent(context,FoodDetails::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)
            }
            return foodView
        }

        override fun getItem(position: Int): Any {
            return listOfFood[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfFood.size
        }

    }


}
