package com.example.palenggo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.example.palenggo.handlers.PalenggoHandler
import com.example.palenggo.models.Modal
import com.example.palenggo.models.Recipes
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

var recipeNames = arrayOf("Adobo" , "Afritada" , "Dinakdakan", "Kare-kare", "Monggo", "Sisig")
var recipeImages = intArrayOf(R.drawable.adobo, R.drawable.afritada , R.drawable.dinakdakan,
                                       R.drawable.karekare, R.drawable.monggo,R.drawable.sisig)

class ViewRecipeListActivity : AppCompatActivity() {
    lateinit var adapter: ArrayAdapter<String>
    lateinit var PalenggoHandler: PalenggoHandler
    lateinit var recipes :ArrayList<Recipes>
    lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_recipe_list)

        gridView = findViewById(R.id.gridView)
        val mainAdapter = RecipeAdapter(this, recipeNames, recipeImages)
        gridView.adapter = mainAdapter
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, id ->

            val intent = Intent(this, RecipeDetailsActivity::class.java)
            intent.putExtra("position", recipeNames[position])
            startActivity(intent)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.recipes_option_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_recipe -> {
                startActivity(Intent(applicationContext, addRecipesActivity::class.java))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}