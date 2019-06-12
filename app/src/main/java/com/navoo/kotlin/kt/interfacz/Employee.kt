package com.navoo.kotlin.kt.interfacz

data class Employee(
    override val firstName: String,
    override val lastName: String,
    val position: Int
) : Person {
}