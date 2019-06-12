package com.navoo.kotlin.kt.extension

class MyClass {
    companion object {}


    fun caller(sec: Sec): Unit {
        sec.print()
    }

    private fun Sec.print(): Unit {
        println("print")
    }

}

class Sec {

}

fun MyClass.Companion.foo() {
    println("伴生对象的扩展函数")
}


val MyClass.Companion.value: Int
    get() = 10

fun main() {

    /**
     * 像伴生对象的其他普通成员，只需用类名作为限定符去调用他们
     */
    println("value:${MyClass.value}")
    MyClass.foo()
    /**
     * 伴生对象内的成员相当于 Java 中的静态成员,其生命周期伴随类始终,在伴生对象内部可以定义变量和函数,这些变量和函数可以直接用类名引用.
     * 对于伴生对象扩展函数,有两种形式,一种是在类内扩展,一种是在类外扩展,这两种形式扩展后的函数互不影响（甚至名称都可以相同）,即使名称相同,它们也完全是两个不同的函数,并且有以下特点:
     * （1）类内扩展的伴随对象函数和类外扩展的伴随对象可以同名,它们是两个独立的函数,互不影响;
     * （2）当类内扩展的伴随对象函数和类外扩展的伴随对象同名时，类内的其它函数优先引用类内扩展的伴随对象函数，即对于类内其它成员函数来说,类内扩展屏蔽类外扩展;
     * （3）类内扩展的伴随对象函数只能被类内的函数引用,不能被类外的函数和伴随对象内的函数引用;
     * （4）类外扩展的伴随对象函数可以被伴随对象内的函数引用;
     */

    val myClass = MyClass()
    myClass.caller(Sec())
}