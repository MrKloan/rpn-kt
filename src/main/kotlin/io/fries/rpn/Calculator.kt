package io.fries.rpn

import io.fries.rpn.operations.OperationRepository
import java.util.*

class Calculator(initializer: OperationRepository.Builder.() -> Unit) {

    private val operationRepository: OperationRepository = OperationRepository.Builder().apply(initializer).build()

    fun compute(expression: String): Double {
        val stack = Stack<Double>()

        tokensOf(expression).forEach {
            compute(it, stack)
        }

        return stack.pop()
    }

    private fun tokensOf(expression: String): List<Token> {
        return expression
                .split(" ")
                .map(::Token)
    }

    private fun compute(token: Token, stack: Stack<Double>) {
        if (token.isDouble()) {
            stack.push(token.asDouble())
            return
        }

        operationRepository
                .find(token.asString())
                .compute(stack)
    }
}