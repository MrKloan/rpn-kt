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
                if (token.asString() == "+") {
                    val secondOperand = stack.pop()
                    val firstOperand = stack.pop()
                    stack.push(firstOperand + secondOperand)
                } else if (token.asString() == "-") {
                    val secondOperand = stack.pop()
                    val firstOperand = stack.pop()
                    stack.push(firstOperand - secondOperand)
                }
            }
        }

        return stack.pop()
    }
}