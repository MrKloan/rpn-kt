package io.fries.rpn

import io.fries.rpn.operations.Addition
import io.fries.rpn.operations.Division
import io.fries.rpn.operations.Multiplication
import io.fries.rpn.operations.Subtraction
import java.util.*

class Calculator {

    private val operations = mapOf(
            "+" to Addition(),
            "-" to Subtraction(),
            "*" to Multiplication(),
            "/" to Division()
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
                operations[token.asString()]?.compute(stack)
            }
        }

        return stack.pop()
    }
}