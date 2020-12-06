package com.example.palenggo.models

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties

class Cart(var id: String? = "", var product_name: String? = "", var product_quantity: Int = 0, var product_price: Int = 0 ) {
   override fun toString(): String {
       var total = product_price*product_quantity
        return product_name.toString() + "      Price: $product_price    Quantity: $product_quantity            TOTAL: " + total
    }

    override fun compareTo(other : Cart) : Int {
        return if(this.product_price != other.product_price){
            this.product_price - other.product_price
        }else{
            0
        }
    }
}