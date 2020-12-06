package com.example.palenggo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class UtilitiesActivity : AppCompatActivity() {

    var utilityNames = arrayOf("BENECO", "BAWADI")
    var utilityImages = intArrayOf(R.drawable.beneco, R.drawable.bawadi)

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_utilities)

        val utilityGridView = findViewById<GridView>(R.id.utilityGridView)
        val utilityAdapter = UtilityAdapter(this , utilityNames , utilityImages)
        utilityGridView.adapter = utilityAdapter
        utilityGridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, id ->
            val intent = Intent(this, PayBillActivity::class.java)
            intent.putExtra("utilityPosition",utilityNames[position])
            startActivity(intent)
        }
    }
}