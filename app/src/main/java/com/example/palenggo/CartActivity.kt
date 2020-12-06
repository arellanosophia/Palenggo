package com.example.palenggo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.example.palenggo.handlers.PalenggoHandler
import com.example.palenggo.models.Cart
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class CartActivity : AppCompatActivity() {

    lateinit var palenggoHandler: PalenggoHandler
    lateinit var products: ArrayList<Cart>
    lateinit var cartListView : ListView
    lateinit var checkOutButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        palenggoHandler = PalenggoHandler()
        products = ArrayList()
        cartListView = findViewById(R.id.cartListView)


        registerForContextMenu(cartListView)
    }
    override fun onStart(){
        super.onStart()
        palenggoHandler.orders.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                products.clear()
                snapshot.children.forEach{
                    val product = it.getValue(Cart::class.java)
                    products.add(product!!)
                }
                val adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1, products)
                cartListView.adapter = adapter
            }

            override fun onCancelled(p0: DatabaseError) {

            }

        })
    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        val inflater = menuInflater
        inflater.inflate(R.menu.cart_options, menu)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        return when(item.itemId){

            R.id.remove_item -> {
                if(palenggoHandler.deleteItem(products[info.position])){
                    Toast.makeText(applicationContext, "Item Deleted.", Toast.LENGTH_SHORT).show()
                }
                true
            }
            else -> super.onContextItemSelected(item)
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