package com.example.palenggo.handlers

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ChannelHandler {
    var database : FirebaseDatabase
    var channelReference: DatabaseReference

    init {
        database = FirebaseDatabase.getInstance()
        channelReference = database.getReference("palenggo")
    }


}