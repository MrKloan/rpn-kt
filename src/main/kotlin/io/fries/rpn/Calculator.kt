package io.fries.rpn

import java.util.*

class Calculator {

    private val operations = mapOf(
            "+" to { stack: Stack<Double> ->
                val secondOperand = stack.pop()
                val firstOperand = stack.pop()
                stack.push(firstOperand + secondOperand)
            },
            "-" to { stack: Stack<Double> ->
                val secondOperand = stack.pop()
                val firstOperand = stack.pop()
                stack.push(firstOperand - secondOperand)
            }
    )

    fun compute(expression: String): Double {
        val tokens = expression
                .split(" ")
                .map(::Token)

        val stack = Stack<Double>()

        tokens.forEach { token ->
            if (token.isDouble()) {
                stack.push(token.asDouble())
            } else {
                operations[token.asString()]?.invoke(stack)
            }
        }

        return stack.pop()
    }
}