package io.fries.rpn

import java.util.*

class Calculator {

    fun compute(expression: String): Double {
        val tokens = expression.split(" ")
        val stack = Stack<Double>()

        tokens.forEach { token ->
            val doubleValue = token.toDoubleOrNull()

            if (doubleValue != null) {
                stack.push(doubleValue)
            } else {
                stack.push(stack.pop() + stack.pop())
            }
        }

        return stack.pop()
    }
}