package com.example.threetabapp

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}