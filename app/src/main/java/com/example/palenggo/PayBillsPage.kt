package com.example.palenggo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PayBillsPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay_bills)
        val op1 = findViewById<TextView>(R.id.textView)
        val op2 = findViewById<TextView>(R.id.textView2)

        op1.setOnClickListener {
            val intent= Intent(this, benecoForm::class.java)
            startActivity(intent)
        }
        op2.setOnClickListener {
            val intent = Intent(this, bawadiForm::class.java)
            startActivity(intent)

        }
    }
    }
