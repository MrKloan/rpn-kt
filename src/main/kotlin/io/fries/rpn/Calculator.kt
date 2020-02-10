package io.fries.rpn

import java.util.*

class Calculator {

    fun compute(expression: String): Double {
        val tokens = expression
                .split(" ")
                .map(::Token)

        val stack = Stack<Double>()

        tokens.forEach { token ->
            if (token.isDouble()) {
                stack.push(token.asDouble())
            } else {
                stack.push(stack.pop() + stack.pop())
            }
        }

        return stack.pop()
    }
}