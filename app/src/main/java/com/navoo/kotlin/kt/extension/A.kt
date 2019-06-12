package com.navoo.kotlin.kt.extension

/**扩展属性允许定义在类或者kotlin文件中，不允许定义在函数中。初始化属性因为属性没有后端字段（backing field），所以不允许被初始化，
 * 只能由显式提供的 getter/setter 定义。
 * val Foo.bar = 1 // 错误：扩展属性不能有初始化器
 * 扩展属性只能被声明为 val。
 */
class A {
    var name: String = ""
    var age: Int = 0

}

val A.secName: String
    get() = "Owen$name"


fun main() {
    val a = A()
    println(a.secName)
}

val <T> List<T>.lastIndex: Int
    get() = size + 1
