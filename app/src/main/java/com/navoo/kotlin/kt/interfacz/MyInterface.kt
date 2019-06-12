package com.navoo.kotlin.kt.interfacz

interface MyInterface {
    val prop: Int//抽象的

    val propertyWithImplemention: String
        get() = "foo"

    fun foo() {
        println(prop)
    }
}