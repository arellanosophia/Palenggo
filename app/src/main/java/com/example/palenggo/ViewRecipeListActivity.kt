package com.example.palenggo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import android.widget.Toast

class ViewRecipeListActivity : AppCompatActivity() {

    //var modalList = ArrayList<Modal>()
    private var recipeNames = arrayOf("Adobo" , "Afritada" , "Dinakdakan", "Kare-kare", "Monggo", "Sisig")

    private var recipeImages = intArrayOf(R.drawable.adobo, R.drawable.afritada , R.drawable.dinakdakan, R.drawable.karekare,
                                         R.drawable.monggo,R.drawable.sisig)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridView = findViewById<GridView>(R.id.gridView)
        //val imageView = findViewById<ImageView>(R.id.imgView)
        val mainAdapter = MainAdapter(this , recipeNames , recipeImages)
        gridView.adapter = mainAdapter
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, id ->
            Toast.makeText(applicationContext, "You CLicked " + recipeNames[+position],
                Toast.LENGTH_SHORT).show()
            val intent = Intent(this, RecipeDetailsActivity::class.java)
            intent.putExtra("position", recipeNames[position])
            startActivity(intent)
        }
    }
}