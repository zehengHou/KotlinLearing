package com.navoo.kotlin.kt.extension

class User(val userName: String) {}

/**
 * 扩展函数:Kotlin 可以对一个类的属性和方法进行扩展，且不需要继承或使用 Decorator 模式。
 * 扩展是一种静态行为，对被扩展的类代码本身不会造成任何影响
 *
 *
 */
private fun User.print() {
    print("用户名 $userName")
}

fun main() {
    val user = User("Owen hou")
    user.print()
}

