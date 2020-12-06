package com.example.palenggo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.GridView

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        val gridView = findViewById<GridView>(R.id.homeListView)

        var option_names = arrayOf("Buy Goods", "View Recipes", "Pay Bills")
        var option_images = intArrayOf(R.drawable.buy, R.drawable.view, R.drawable.pay)

        val homeAdapter = HomePage(this , option_names , option_images)
        gridView.adapter = homeAdapter
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, id ->

            if (option_names[position] == "Buy Goods") {
                val intent = Intent(this, ProductsActivity::class.java)
                startActivity(intent)
            } else if (option_names[position] == "View Recipes") {
                val intent = Intent(this, ViewRecipeListActivity::class.java)
                startActivity(intent)
            } else if (option_names[position] == "Pay Bills") {
                val intent = Intent(this, UtilitiesActivity::class.java)
                startActivity(intent)
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.home_page_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.go_to_cart -> {
                val intent = Intent(this, CartActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.go_to_recipes -> {
                val intent = Intent(this , ViewRecipeListActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.go_to_products -> {
                val intent = Intent(this , ProductsActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.go_to_bills -> {
                val intent = Intent(this ,  PayBillActivity::class.java)
                startActivity(intent)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}