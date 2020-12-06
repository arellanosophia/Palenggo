package com.example.palenggo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.palenggo.handlers.PalenggoHandler
import com.example.palenggo.models.Cart

var addedToCart = arrayListOf<String>()

class ProductDetailsActivity : AppCompatActivity() {

    lateinit var productImage : ImageView
    lateinit var productName : TextView
    lateinit var productUnit : TextView
    lateinit var productQuantity : TextView
    lateinit var productPrice : TextView
    lateinit var palenggoHandler: PalenggoHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val position = intent.extras!!.getString("position")
        productImage = findViewById(R.id.productImageView)
        productName = findViewById(R.id.productNameTextView)
        productUnit = findViewById(R.id.productQuantityTextView)
        productQuantity = findViewById(R.id.quantityNumber)
        productPrice = findViewById(R.id.productPriceTextView)
        palenggoHandler = PalenggoHandler()


//FRUITS SECTION
        when {
            position.equals("Apple") -> {
                productPrice.text = "40"
                productImage.setImageResource(R.drawable.apple2)
                productName.text = position
                productUnit.text = "1 pc (100- 120 grams)"

                findViewById<SeekBar>(R.id.quantitySeekBar).setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        productQuantity.text = progress.toString().toInt().toString()

                        val product_quantity = productQuantity.text.toString().toInt()
                        val product_price = productPrice.text.toString().toInt()

                        findViewById<Button>(R.id.addToCartButton).setOnClickListener{
                            val cart = Cart(product_name = position, product_quantity = product_quantity, product_price = product_price)
                            if (palenggoHandler.addItem(cart)) {
                                Toast.makeText(applicationContext , "Added To Cart", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                })
            }
            position.equals("Banana") -> {
                productPrice.text = "80"
                productImage.setImageResource(R.drawable.banana2)
                productName.text = position
                productUnit.text = "1 branch (800 grams - 1 kg)"

                findViewById<SeekBar>(R.id.quantitySeekBar).setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        productQuantity.text = progress.toString().toInt().toString()

                        val product_quantity = productQuantity.text.toString().toInt()
                        val product_price = productPrice.text.toString().toInt()

                        findViewById<Button>(R.id.addToCartButton).setOnClickListener{
                            val cart = Cart(product_name = position, product_quantity = product_quantity, product_price = product_price)
                            if (palenggoHandler.addItem(cart)) {
                                Toast.makeText(applicationContext , "Added To Cart", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                })
            }
            position.equals("Mango") -> {
                productPrice.text = "30"
                productImage.setImageResource(R.drawable.mango2)
                productName.text = position
                productUnit.text = "1 pc (100 - 200 grams)"

                findViewById<SeekBar>(R.id.quantitySeekBar).setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        productQuantity.text = progress.toString().toInt().toString()

                        val product_quantity = productQuantity.text.toString().toInt()
                        val product_price = productPrice.text.toString().toInt()

                        findViewById<Button>(R.id.addToCartButton).setOnClickListener{
                            val cart = Cart(product_name = position, product_quantity = product_quantity, product_price = product_price)
                            if (palenggoHandler.addItem(cart)) {
                                Toast.makeText(applicationContext , "Added To Cart", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                })
            }
            position.equals("Mangosteen") -> {
                productImage.setImageResource(R.drawable.mangosteen2)
                productName.text = position
                productUnit.text = "3 pcs (300 - 450 grams)"
                productPrice.text = "50"
                findViewById<SeekBar>(R.id.quantitySeekBar).setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        productQuantity.text = progress.toString().toInt().toString()

                        val product_quantity = productQuantity.text.toString().toInt()
                        val product_price = productPrice.text.toString().toInt()

                        findViewById<Button>(R.id.addToCartButton).setOnClickListener{
                            val cart = Cart(product_name = position, product_quantity = product_quantity, product_price = product_price)
                            if (palenggoHandler.addItem(cart)) {
                                Toast.makeText(applicationContext , "Added To Cart", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                })
            }
            position.equals("Orange") -> {
                productImage.setImageResource(R.drawable.orange2)
                productName.text = position
                productUnit.text = "1 pc (100 - 200 grams)"
                productPrice.text = "15"
                findViewById<SeekBar>(R.id.quantitySeekBar).setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        productQuantity.text = progress.toString().toInt().toString()

                        val product_quantity = productQuantity.text.toString().toInt()
                        val product_price = productPrice.text.toString().toInt()

                        findViewById<Button>(R.id.addToCartButton).setOnClickListener{
                            val cart = Cart(product_name = position, product_quantity = product_quantity, product_price = product_price)
                            if (palenggoHandler.addItem(cart)) {
                                Toast.makeText(applicationContext , "Added To Cart", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                })
            }
            position.equals("Persimmon") -> {
                productImage.setImageResource(R.drawable.persimmon2)
                productName.text = position
                productUnit.text = "1 pc (100 - 200 grams)"
                productPrice.text = "20"
                findViewById<SeekBar>(R.id.quantitySeekBar).setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        productQuantity.text = progress.toString().toInt().toString()

                        val product_quantity = productQuantity.text.toString().toInt()
                        val product_price = productPrice.text.toString().toInt()

                        findViewById<Button>(R.id.addToCartButton).setOnClickListener{
                            val cart = Cart(product_name = position, product_quantity = product_quantity, product_price = product_price)
                            if (palenggoHandler.addItem(cart)) {
                                Toast.makeText(applicationContext , "Added To Cart", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                })
            }
            position.equals("Pineapple") -> {
                productImage.setImageResource(R.drawable.pineapple2)
                productName.text = position
                productUnit.text = "1 pc (300 - 600 grams)"
                productPrice.text = "70"
                findViewById<SeekBar>(R.id.quantitySeekBar).setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        productQuantity.text = progress.toString().toInt().toString()

                        val product_quantity = productQuantity.text.toString().toInt()
                        val product_price = productPrice.text.toString().toInt()

                        findViewById<Button>(R.id.addToCartButton).setOnClickListener{
                            val cart = Cart(product_name = position, product_quantity = product_quantity, product_price = product_price)
                            if (palenggoHandler.addItem(cart)) {
                                Toast.makeText(applicationContext , "Added To Cart", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                })
            }
            position.equals("Strawberry") -> {
                productImage.setImageResource(R.drawable.strawberry2)
                productName.text = position
                productUnit.text = "10 pcs (100 - 200 grams)"
                productPrice.text = "80"
                findViewById<SeekBar>(R.id.quantitySeekBar).setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        productQuantity.text = progress.toString().toInt().toString()

                        val product_quantity = productQuantity.text.toString().toInt()
                        val product_price = productPrice.text.toString().toInt()

                        findViewById<Button>(R.id.addToCartButton).setOnClickListener{
                            val cart = Cart(product_name = position, product_quantity = product_quantity, product_price = product_price)
                            if (palenggoHandler.addItem(cart)) {
                                Toast.makeText(applicationContext , "Added To Cart", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                })
            }
            position.equals("Watermelon") -> {
                productImage.setImageResource(R.drawable.watermelon2)
                productName.text = position
                productUnit.text = "1 pc (500 - 800 grams)"
                productPrice.text = "90"
                findViewById<SeekBar>(R.id.quantitySeekBar).setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        productQuantity.text = progress.toString().toInt().toString()

                        val product_quantity = productQuantity.text.toString().toInt()
                        val product_price = productPrice.text.toString().toInt()

                        findViewById<Button>(R.id.addToCartButton).setOnClickListener{
                            val cart = Cart(product_name = position, product_quantity = product_quantity, product_price = product_price)
                            if (palenggoHandler.addItem(cart)) {
                                Toast.makeText(applicationContext , "Added To Cart", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                })
            }
// POULTRY SECTION
            position.equals("Beef") ->{
                productImage.setImageResource(R.drawable.beef2)
                productName.text = position
                productUnit.text = "1/2 kg"
                productPrice.text = "80"
                findViewById<SeekBar>(R.id.quantitySeekBar).setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        productQuantity.text = progress.toString().toInt().toString()

                        val product_quantity = productQuantity.text.toString().toInt()
                        val product_price = productPrice.text.toString().toInt()

                        findViewById<Button>(R.id.addToCartButton).setOnClickListener{
                            val cart = Cart(product_name = position, product_quantity = product_quantity, product_price = product_price)
                            if (palenggoHandler.addItem(cart)) {
                                Toast.makeText(applicationContext , "Added To Cart", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                })
            }
            position.equals("Chicken Drumstick") ->{
                productImage.setImageResource(R.drawable.drumstick2)
                productName.text = position
                productUnit.text = "1/2 kg"
                productPrice.text = "60"
                findViewById<SeekBar>(R.id.quantitySeekBar).setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        productQuantity.text = progress.toString().toInt().toString()

                        val product_quantity = productQuantity.text.toString().toInt()
                        val product_price = productPrice.text.toString().toInt()

                        findViewById<Button>(R.id.addToCartButton).setOnClickListener{
                            val cart = Cart(product_name = position, product_quantity = product_quantity, product_price = product_price)
                            if (palenggoHandler.addItem(cart)) {
                                Toast.makeText(applicationContext , "Added To Cart", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                })
            }
            position.equals("Longganisa") ->{
                productImage.setImageResource(R.drawable.longganisa2)
                productName.text = position
                productUnit.text = "1/2 kg"
                productPrice.text = "50"
                findViewById<SeekBar>(R.id.quantitySeekBar).setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        productQuantity.text = progress.toString().toInt().toString()

                        val product_quantity = productQuantity.text.toString().toInt()
                        val product_price = productPrice.text.toString().toInt()

                        findViewById<Button>(R.id.addToCartButton).setOnClickListener{
                            val cart = Cart(product_name = position, product_quantity = product_quantity, product_price = product_price)
                            if (palenggoHandler.addItem(cart)) {
                                Toast.makeText(applicationContext , "Added To Cart", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                })
            }
            position.equals("Pork Belly") ->{
                productImage.setImageResource(R.drawable.porkbelly2)
                productName.text = position
                productUnit.text = "1/2 kg"
                productPrice.text = "70"
                findViewById<SeekBar>(R.id.quantitySeekBar).setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        productQuantity.text = progress.toString().toInt().toString()

                        val product_quantity = productQuantity.text.toString().toInt()
                        val product_price = productPrice.text.toString().toInt()

                        findViewById<Button>(R.id.addToCartButton).setOnClickListener{
                            val cart = Cart(product_name = position, product_quantity = product_quantity, product_price = product_price)
                            if (palenggoHandler.addItem(cart)) {
                                Toast.makeText(applicationContext , "Added To Cart", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                })
            }
            position.equals("Pork Loin") ->{
                productImage.setImageResource(R.drawable.porkloin2)
                productName.text = position
                productUnit.text = "1/2 kg"
                productPrice.text = "60"
                findViewById<SeekBar>(R.id.quantitySeekBar).setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        productQuantity.text = progress.toString().toInt().toString()

                        val product_quantity = productQuantity.text.toString().toInt()
                        val product_price = productPrice.text.toString().toInt()

                        findViewById<Button>(R.id.addToCartButton).setOnClickListener{
                            val cart = Cart(product_name = position, product_quantity = product_quantity, product_price = product_price)
                            if (palenggoHandler.addItem(cart)) {
                                Toast.makeText(applicationContext , "Added To Cart", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                })
            }
            position.equals("Pork Sinigang") ->{
                productImage.setImageResource(R.drawable.porksinigang2)
                productName.text = position
                productUnit.text = "1/2 kg"
                productPrice.text = "80"
                findViewById<SeekBar>(R.id.quantitySeekBar).setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        productQuantity.text = progress.toString().toInt().toString()

                        val product_quantity = productQuantity.text.toString().toInt()
                        val product_price = productPrice.text.toString().toInt()

                        findViewById<Button>(R.id.addToCartButton).setOnClickListener{
                            val cart = Cart(product_name = position, product_quantity = product_quantity, product_price = product_price)
                            if (palenggoHandler.addItem(cart)) {
                                Toast.makeText(applicationContext , "Added To Cart", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                })
            }
            position.equals("Whole Chicken") ->{
                productImage.setImageResource(R.drawable.wholechicken2)
                productName.text = position
                productUnit.text = "1 pc"
                productPrice.text = "90"
                findViewById<SeekBar>(R.id.quantitySeekBar).setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        productQuantity.text = progress.toString().toInt().toString()

                        val product_quantity = productQuantity.text.toString().toInt()
                        val product_price = productPrice.text.toString().toInt()

                        findViewById<Button>(R.id.addToCartButton).setOnClickListener{
                            val cart = Cart(product_name = position, product_quantity = product_quantity, product_price = product_price)
                            if (palenggoHandler.addItem(cart)) {
                                Toast.makeText(applicationContext , "Added To Cart", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                })
            }
            position.equals("Chicken Wings") ->{
                productImage.setImageResource(R.drawable.wings2)
                productName.text = position
                productUnit.text = "1/2 kg"
                productPrice.text = "60"
                findViewById<SeekBar>(R.id.quantitySeekBar).setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        productQuantity.text = progress.toString().toInt().toString()

                        val product_quantity = productQuantity.text.toString().toInt()
                        val product_price = productPrice.text.toString().toInt()

                        findViewById<Button>(R.id.addToCartButton).setOnClickListener{
                            val cart = Cart(product_name = position, product_quantity = product_quantity, product_price = product_price)
                            if (palenggoHandler.addItem(cart)) {
                                Toast.makeText(applicationContext , "Added To Cart", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                })
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