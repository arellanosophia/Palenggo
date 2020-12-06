package com.example.palenggo

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class PayBillActivity : AppCompatActivity() {

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "i.apps.notifications"
    private val description = "Test notification"
    @SuppressLint("WrongViewCast")

    var options = arrayOf("Payment option", "Gcash", "MasterCard")
    lateinit var selectedItem : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay_bill)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val utilityImageView = findViewById<ImageView>(R.id.utilityImageView)
        val utilityName = findViewById<TextView>(R.id.utilityName)
        val utName = findViewById<EditText>(R.id.utName)
        val utAdd = findViewById<EditText>(R.id.utAdd)
        val utAccountNum = findViewById<EditText>(R.id.utAccountNum)
        val paymentSpinner = findViewById<Spinner>(R.id.paymentSpinner)
        val tvAccountName = findViewById<TextView>(R.id.tvAccountName)
        val tvAccountNum = findViewById<TextView>(R.id.tvAccountNum)
        val tvYear = findViewById<TextView>(R.id.tvYear)
        val payName = findViewById<EditText>(R.id.payName)
        val payNumber = findViewById<EditText>(R.id.payNumber)
        val payExpiry = findViewById<EditText>(R.id.payExpiry)
        val payBillButton = findViewById<Button>(R.id.payBillButton)
        payBillButton.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setMessage("Your total utility bill will be deducted to your balance. Do you wish to proceed?")
                .setCancelable(false)
                .setPositiveButton("Yes") { _, _ ->


                    val intent = Intent(this, PaidBillsActivity::class.java)

                    intent.putExtra("utility_name",utilityName.text.toString() )
                    intent.putExtra("full_name", utName.text.toString())
                    intent.putExtra("full_address", utAdd.text.toString())
                    intent.putExtra("account_number", utAccountNum.text.toString())
                    intent.putExtra("payment_name", selectedItem)


                    startActivity(intent)

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        notificationChannel = NotificationChannel(
                            channelId, description, NotificationManager.IMPORTANCE_HIGH
                        )
                        notificationChannel.enableLights(true)
                        notificationChannel.lightColor = Color.BLUE
                        notificationChannel.enableVibration(true)
                        notificationManager.createNotificationChannel(notificationChannel)

                        builder = Notification.Builder(this, channelId)
                            .setContentTitle("Utility Bills")
                            .setContentText("Your bills have been paid.")
                            .setSmallIcon(R.drawable.ic_launcher_background)

                    } else {
                        builder = Notification.Builder(this)
                            .setContentTitle("Utility Bills")
                            .setContentText("Your bills have been paid.")
                            .setSmallIcon(R.drawable.ic_launcher_background)
                    }
                    notificationManager.notify(1234, builder.build())
                }.setNegativeButton("No") { dialog, _ ->
                    dialog.cancel()
                }

            val alert = dialogBuilder.create()
            alert.setTitle("Notification Manager")
            alert.show()
        }


        val utilityPosition = intent.extras!!.getString("utilityPosition")

        if(utilityPosition.equals("BENECO")){
            utilityImageView.setImageResource(R.drawable.beneco)
            utilityName.text = "Benguet Electric Cooperative"
        }else if (utilityPosition.equals("BAWADI")){
            utilityImageView.setImageResource(R.drawable.bawadi)
            utilityName.text = "Baguio Water District"
        }


        paymentSpinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        paymentSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectedItem = parent?.getItemAtPosition(p2).toString()
                if (selectedItem == "Payment option"){
                    payName.visibility = View.INVISIBLE
                    payNumber.visibility = View.INVISIBLE
                    payExpiry.visibility = View.INVISIBLE
                    tvAccountName.visibility = View.INVISIBLE
                    tvAccountNum.visibility = View.INVISIBLE
                    tvYear.visibility = View.INVISIBLE
                    payBillButton.visibility = View.INVISIBLE

                } else if (selectedItem == "Gcash") {
                    payName.visibility = View.VISIBLE
                    payNumber.visibility = View.VISIBLE
                    payExpiry.visibility = View.INVISIBLE
                    tvAccountName.visibility = View.VISIBLE
                    tvAccountNum.visibility = View.VISIBLE
                    tvYear.visibility = View.INVISIBLE
                    payBillButton.visibility = View.VISIBLE

                } else if (selectedItem == "MasterCard"){
                    payName.visibility = View.VISIBLE
                    payNumber.visibility = View.VISIBLE
                    payExpiry.visibility = View.VISIBLE
                    tvAccountName.visibility = View.VISIBLE
                    tvAccountNum.visibility = View.VISIBLE
                    tvYear.visibility = View.VISIBLE
                    payBillButton.visibility = View.VISIBLE
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

    }
}