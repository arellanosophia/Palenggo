package com.example.palenggo.models

import java.io.Serializable

class Modal: Serializable{
    var name: String? = ""
    var image: Int? = 0

    constructor(name:String , image:Int){
        this.name = name
        this.image = image

    }
}