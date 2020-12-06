package com.example.palenggo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.example.palenggo.handlers.PalenggoHandler
import com.example.palenggo.models.Recipes
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class PendingRecipeActivity : AppCompatActivity() {

    lateinit var editRecipeNameET: EditText
    lateinit var editDescET: EditText
    lateinit var editPrepET: EditText
    lateinit var editCookET: EditText
    lateinit var editTotalET: EditText
    lateinit var editServingsET: EditText
    lateinit var editToDoET: EditText
    lateinit var updateRecipeBtn: Button
    lateinit var pendingRecipesLV: ListView

    lateinit var recipes: ArrayList<Recipes>
    lateinit var getRecipes: Recipes

    lateinit var PalenggoHandler: PalenggoHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pending_recipe)

        editRecipeNameET = findViewById(R.id.editRecipeNameET)
        editDescET = findViewById(R.id.editDescET)
        editPrepET = findViewById(R.id.editPrepET)
        editCookET = findViewById(R.id.editCookET)
        editTotalET = findViewById(R.id.editTotalET)
        editServingsET = findViewById(R.id.editServingsET)
        editToDoET = findViewById(R.id.editToDoET)

        updateRecipeBtn = findViewById(R.id.updateRecipeBtn)
        pendingRecipesLV = findViewById(R.id.pendingRecipesLV)
        PalenggoHandler = PalenggoHandler()
        recipes = ArrayList()
        updateRecipeBtn.setOnClickListener {
            val recipe_name = editRecipeNameET.text.toString()
            val desc = editDescET.text.toString()
            val prep = editPrepET.text.toString()
            val cook = editCookET.text.toString()
            val total = editTotalET.text.toString()
            val serving = editServingsET.text.toString()
            val toDo = editToDoET.text.toString()
            val recipe = Recipes(id = getRecipes.id, recipe_name = recipe_name, desc = desc, prep = prep, cook = cook, total = total, servings = serving, toDo = toDo)
            if (PalenggoHandler.updateRecipe(recipe)) {
                Toast.makeText(applicationContext, "Channel updated", Toast.LENGTH_LONG).show()
                }
            }
        registerForContextMenu(pendingRecipesLV)
        }
        override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
            val inflater = menuInflater
            inflater.inflate(R.menu.pending_recipes_menu,menu)
        }
        override fun onContextItemSelected(item: MenuItem): Boolean {
            val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
            return when (item.itemId) {
                R.id.edit_recipe -> {
                    getRecipes = recipes[info.position]
                    editRecipeNameET.setText(getRecipes.recipe_name)
                    editDescET.setText(getRecipes.desc)
                    editPrepET.setText(getRecipes.prep)
                    editCookET.setText(getRecipes.cook)
                    editTotalET.setText(getRecipes.total)
                    editServingsET.setText(getRecipes.servings)
                    editToDoET.setText(getRecipes.toDo)
                    true
                }
                else -> super.onContextItemSelected(item)
        }
    }override fun onStart(){
        super.onStart()

        PalenggoHandler.addRecipe.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                //TODO("Not yet implemented")
            }
            override fun onDataChange(p0: DataSnapshot) {
                //TODO("Not yet implemented")
                recipes.clear()
                p0.children.forEach{
                        it ->  val recipe = it.getValue(Recipes::class.java)
                    recipes.add(recipe!!)
                }

                val adapter = ArrayAdapter<Recipes>(applicationContext, android.R.layout.simple_list_item_1, recipes)
                pendingRecipesLV.adapter = adapter
            }

        })
    }
}