package com.example.palenggo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.palenggo.handlers.PalenggoHandler
import com.example.palenggo.models.Bills

class PaidBillsActivity : AppCompatActivity() {
    lateinit var palenggoHandler: PalenggoHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paid_bills)

        val utility_name = findViewById<TextView>(R.id.utility_name)
        val full_nameUt = findViewById<TextView>(R.id.full_nameUt)
        val full_addressUt = findViewById<TextView>(R.id.full_addressUt)
        val utility_account = findViewById<TextView>(R.id.utility_account)
        val payment_name = findViewById<TextView>(R.id.payment_name)
        val okButton = findViewById<Button>(R.id.okButton)

        palenggoHandler = PalenggoHandler()

        okButton.setOnClickListener {
            val ut = utility_name.text.toString()
            val fn = full_nameUt.text.toString()
            val fa = full_addressUt.text.toString()
            val ua = utility_account.text.toString()
            val pn = payment_name.text.toString()

            val bills = Bills(utility_name = ut, full_name = fn, full_address = fa, utility_account = ua, payment_name = pn)
            palenggoHandler.utilityRef(bills)
            val intent = Intent (this, HomePageActivity::class.java)
            startActivity(intent)
        }

        val utility = intent.extras!!.getString("utility_name")
        val fname = intent.extras!!.getString("full_name")
        val faddress = intent.extras!!.getString("full_address")
        val accnumber = intent.extras!!.getString("account_number")
        val payname = intent.extras!!.getString("payment_name")


        utility_name.text = utility
        full_nameUt.text = fname
        full_addressUt.text= faddress
        utility_account.text = accnumber
        payment_name.text = payname

    }
}