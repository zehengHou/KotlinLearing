package com.navoo.kotlin.kt.interfacz

interface Person : Name {
    val firstName: String
    val lastName: String
    override val name: String get() = "$firstName $lastName"
}