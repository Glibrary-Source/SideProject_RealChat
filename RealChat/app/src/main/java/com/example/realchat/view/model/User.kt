package com.example.realchat.view.model

data class User (
    var name: String,
    var email: String,
    var uid: String
) {
    constructor(): this("","","")
}