package com.example.palenggo.models

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties

class Checkout(var id: String? = "", var name: String? = "", var address: String? = "", var items: ArrayList<Cart>, var total: Int = 0 ) {

}