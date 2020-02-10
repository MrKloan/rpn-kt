package io.fries.rpn

import io.fries.rpn.operations.OperationRepository
import java.util.*

class Calculator(private val operationRepository: OperationRepository) {

    fun compute(expression: String): Double {
        val tokens = expression
                .split(" ")
                .map(::Token)

        val stack = Stack<Double>()

        tokens.forEach { token ->
            if (token.isDouble()) {
                stack.push(token.asDouble())
            } else {
                operationRepository
                        .find(token.asString())
                        .compute(stack)
            }
        }

        return stack.pop()
    }
}