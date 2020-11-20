package com.example.palenggo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class RecipeDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)

        //recipe imageView
        val repImage = findViewById<ImageView>(R.id.recipeImage)
        //recipe name
        val repName = findViewById<TextView>(R.id.recipeName)

        //recipe description
        val repDesc = findViewById<TextView>(R.id.recipeDesc)

        //get ingredients; put into listview
        var toDo :Array<String> =arrayOf()

        //get ingredients; put into listview
        var step :Array<String> =arrayOf()


        //prep time,cooktime, total time, servings
        var pt = findViewById<TextView>(R.id.prepTime)
        var ct = findViewById<TextView>(R.id.ckTime)
        var tt= findViewById<TextView>(R.id.totalTime)
        var s = findViewById<TextView>(R.id.serv)

        val position = intent.extras!!.getString("position")

        if (position.equals("Adobo")){
            repName.text = position
            repImage.setImageResource(R.drawable.adobo)
            repDesc.text = "a Philippine dish of fish or meat usually marinated in a sauce containing vinegar and garlic, browned in fat, and simmered in the marinade."
            toDo = arrayOf("Ingredients:",
                    "2 tbsps canola oil",
                    "6 cloves garlic crushed",
                    "1 pc onion, sliced",
                    "1 kilogram chicken cut ups",
                    "2 tbsps vinegar",
                    "1/4 cup soy sauce",
                    "1 cup water",
                    "2 pcs bay leaves",
                    "1 tsp whole black peppercorns, slightly crushed",
                    "1 pc Knorr chicken cubes",
                    "1 tsp brown sugar packed",
                    "Steps:",
                    "1: Heat oil in pan and saute garlic and onions.",
                    "2 : Add chicken and sear on all sides.",
                    "3 : Pour in vinegar, soy sauce and water. Add bay leaves, pepper and Knorr Chicken Cube. Bring to a boil over high heat then reduce heat to simmer. Continue to simmer for 10 mins.",
                    "4 : Remove chicken pieces from sauce and fry in another pan until nicely browned.",
                    "5 : Put back fried chicken pieces into sauce. Add sugar and let simmer again for another 10 minutes or until sauce has thickened. Serve warm.")

            pt.text = "10-15 mins"
            ct.text = "30-40 mins"
            tt.text = "40-55 mins"
            s.text = "4 pax"
        }
        else if (position.equals("Remote")){
            repName.text = position
            repImage.setImageResource(R.drawable.afritada)
            toDo = arrayOf("Wish Me Luck","Coastlines", "Virtual Aerobics","Dig What You Dug","Nobody Gets Me(Like You)","Talk Like That")
        }
        else if (position.equals("Spring")){
            repName.text = position
            repImage.setImageResource(R.drawable.dinakdakan)
            toDo = arrayOf("Pictures of Girls","These Days","1980s Horror Film","Ground","Let The Sun In", "It's Only Right")
        }
        var iAdapter = ArrayAdapter(this , android.R.layout.simple_list_item_1 , toDo)
        var ingrListView = findViewById<ListView>(R.id.ingrListView)
        ingrListView.adapter = iAdapter

    }
}
