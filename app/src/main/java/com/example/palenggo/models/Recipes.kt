package com.example.palenggo.models

class Recipes(var id: String? = "", var recipe_name: String? = "", var desc: String? = "", var prep:  String? = "" , var cook:  String? = "" , var total:  String? = "" , var servings:  String? = "" , var toDo:  String? = "" ) {
    override fun toString(): String {
        return "$recipe_name"
    }
}