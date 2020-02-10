package io.fries.rpn

import io.fries.rpn.operations.Addition
import io.fries.rpn.operations.Division
import io.fries.rpn.operations.Multiplication
import io.fries.rpn.operations.Subtraction
import java.util.*

class Calculator {

    private val operations = mapOf(
            "+" to { stack: Stack<Double> -> Addition().compute(stack) },
            "-" to { stack: Stack<Double> -> Subtraction().compute(stack) },
            "*" to { stack: Stack<Double> -> Multiplication().compute(stack) },
            "/" to { stack: Stack<Double> -> Division().compute(stack) }
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