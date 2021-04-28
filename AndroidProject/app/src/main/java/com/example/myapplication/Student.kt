package com.example.myapplication


class Student(var studentNo: String, var name: String) : Person(name) , Study {

    override fun printNo()
    {
        println(studentNo)
    }
}