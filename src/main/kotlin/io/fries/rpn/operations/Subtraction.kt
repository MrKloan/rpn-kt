package io.fries.rpn.operations

import java.util.*

class Subtraction : Operation {

    override fun compute(stack: Stack<Double>) {
        val secondOperand = stack.pop()
        val firstOperand = stack.pop()

        stack.push(firstOperand - secondOperand)
    }
}