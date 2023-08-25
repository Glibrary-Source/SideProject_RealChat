package com.example.realchat.view.model

data class Message (
    var message: String?,
    var sendId: String?
) {
    constructor(): this("","")
}