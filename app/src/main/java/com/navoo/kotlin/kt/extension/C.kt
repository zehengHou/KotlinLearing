package com.navoo.kotlin.kt.extension

open class C {
}

class D : C() {}

fun C.foo() = "C"

fun D.foo() = "D"


fun printFoo(c: C) {
    println(c.foo())
}

fun main() {
    val c = C()
    val d = D()
    c.foo()
    d.foo()


    /**
     * 扩展函数是静态解析的
     * 扩展函数是静态解析的，并不是接收者类型的虚拟成员，在调用扩展函数时，具体被调用的的是哪一个函数，由调用函数的的对象表达式来决定的，而不是动态的类型决定的:
     */
    printFoo(c)
    printFoo(d)
}