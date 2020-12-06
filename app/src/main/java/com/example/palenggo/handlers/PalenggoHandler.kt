package com.example.palenggo.handlers

import com.example.palenggo.models.Cart
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class PalenggoHandler {
    var database : FirebaseDatabase

//ADD AND DELETE CART FUNCTION
    var orders: DatabaseReference

    init {
        database = FirebaseDatabase.getInstance()
        orders = database.getReference("orders")
    }
    fun addItem (cart: Cart): Boolean{
        val id = orders.push().key
        cart.id = id

        orders.child(id!!).setValue(cart)
        return true
    }
    fun deleteItem (cart: Cart):Boolean{
        orders.child(cart.id!!).removeValue()
        return true
    }


//UTILITY FUNC
    var utilityRef: DatabaseReference

    init {
        database = FirebaseDatabase.getInstance()
        utilityRef = database.getReference("utilities")
    }
    fun utilityRef (bills: Bills):Boolean{
        val id = utilityRef.push().key
        bills.id = id

        utilityRef.child(id!!).setValue(bills)
        return true
    }

//RECIPES FUNCTION
    var addRecipe: DatabaseReference
    init {
        database = FirebaseDatabase.getInstance()
        addRecipe = database.getReference("add_recipe")
    }
    fun addRecipes (recipes: Recipes): Boolean{
        val id = addRecipe.push().key
        recipes.id = id

        addRecipe.child(id!!).setValue(recipes)
        return true
    }
    fun updateRecipe(recipes: Recipes): Boolean {
        addRecipe.child(recipes.id!!).setValue(recipes)
        return true
    }
}