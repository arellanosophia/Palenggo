package com.example.palenggo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.palenggo.handlers.PalenggoHandler
import com.example.palenggo.models.Recipes
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class addRecipesActivity : AppCompatActivity() {
    lateinit var recipeNameET: EditText
    lateinit var descET: EditText
    lateinit var prepET: EditText
    lateinit var cookET: EditText
    lateinit var totalET: EditText
    lateinit var servingsET: EditText
    lateinit var toDoET: EditText
    lateinit var addRecipeBtn: Button

    lateinit var palenggoHandler: PalenggoHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipes)
        palenggoHandler = PalenggoHandler()

        recipeNameET = findViewById(R.id.recipeNameET)
        descET = findViewById(R.id.descET)
        prepET = findViewById(R.id.prepET)
        cookET = findViewById(R.id.cookET)
        totalET = findViewById(R.id.totalET)
        servingsET = findViewById(R.id.servingsET)
        toDoET = findViewById(R.id.toDoET)

        addRecipeBtn = findViewById(R.id.addRecipeBtn)

        addRecipeBtn.setOnClickListener {
            val recipe_name = recipeNameET.text.toString()
            val desc = descET.text.toString()
            val prep = prepET.text.toString()
            val cook = cookET.text.toString()
            val total = totalET.text.toString()
            val serving = servingsET.text.toString()
            val toDo = toDoET.text.toString()
            val recipe = Recipes(recipe_name = recipe_name, desc = desc, prep = prep, cook = cook, total = total, servings = serving, toDo = toDo)
            if (palenggoHandler.addRecipes(recipe)) {
                    Toast.makeText(applicationContext, "Recipe added", Toast.LENGTH_LONG).show()
                    clearFields()
            }
        }
    }
    fun clearFields() {
        recipeNameET.text.clear()
        descET.text.clear()
        prepET.text.clear()
        cookET.text.clear()
        totalET.text.clear()
        servingsET.text.clear()
        toDoET.text.clear()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.pending_recipes_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.edit_recipe -> {
                startActivity(Intent(applicationContext, PendingRecipeActivity::class.java))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
