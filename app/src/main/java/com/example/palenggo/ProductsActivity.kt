package com.example.palenggo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.*

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val productsName = arrayOf("F R U I T S","P O U L T R Y","S E A F O O D", "S E A S O N I N G S", "V E G E T A B L E S")
        val productsImage = intArrayOf(R.drawable.fruits, R.drawable.poultry, R.drawable.seafood, R.drawable.seasonings, R.drawable.vegetables)

        val gridView = findViewById<GridView>(R.id.gridView)
        val mainAdapter = AdapterProducts(this , productsName , productsImage)
        gridView.adapter = mainAdapter
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _ , _ , position , id ->
            val intent = Intent(this , ProductListActivity::class.java)
            intent.putExtra("category" , productsName[position])
            startActivity(intent)
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
                true
            }
            R.id.go_to_products -> {
                val intent = Intent(this , ProductsActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.go_to_bills -> {
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

}