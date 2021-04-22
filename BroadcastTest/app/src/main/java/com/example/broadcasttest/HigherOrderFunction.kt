package com.example.broadcasttest
fun main()
{
    val num1 = 100
    val num2 = 80
    val result1 = num1AndNum2(num1, num2) { n1, n2 ->
        n1 + n2
    }
    val result2 = num1AndNum2(num1, num2) { n1, n2 ->
        n1 - n2
    }
    println("result1 is $result1")
    println("result2 is $result2")
}


fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int) : Int{
    val result = operation(num1, num2)
    return result
}