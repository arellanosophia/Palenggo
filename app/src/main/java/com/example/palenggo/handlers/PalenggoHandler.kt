package com.example.palenggo.handlers

import com.example.palenggo.models.Cart
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class PalenggoHandler {
    var database : FirebaseDatabase

//ADD AND DELETE CART FUNCTION
    var addItemRef: DatabaseReference

    init {
        database = FirebaseDatabase.getInstance()
        addItemRef = database.getReference("add_item")
    }
    fun addItem (cart: Cart): Boolean{
        val id = addItemRef.push().key
        cart.id = id

        addItemRef.child(id!!).setValue(cart)
        return true
    }
    fun deleteItem (cart: Cart):Boolean{
        addItemRef.child(cart.id!!).removeValue()
        return true
    }

}