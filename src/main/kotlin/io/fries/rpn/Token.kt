package io.fries.rpn

data class Token(private val value: String) {

    fun isDouble(): Boolean = value.toDoubleOrNull() != null
    fun asDouble(): Double = value.toDouble()
}