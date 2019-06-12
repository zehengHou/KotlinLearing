package com.navoo.kotlin.kt.extension

class F {
    fun foo(): Unit {
        println("成员函数")
    }
}

fun F.foo(): Unit {
    println("扩展函数")
}


fun main() {
    val f = F()
    /**
     * 若扩展函数和成员函数一致，则使用该函数时，会优先使用成员函数。
     */
    f.foo()
    val t = null
    println(t.toString())
}

/**
 * 在扩展函数内， 可以通过 this 来判断接收者是否为 NULL,这样，即使接收者为 NULL,也可以调用扩展函数
 */
fun Any?.toString(): String {
    if (this == null) return "null"
    // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
    // 解析为 Any 类的成员函数
    return toString()
}