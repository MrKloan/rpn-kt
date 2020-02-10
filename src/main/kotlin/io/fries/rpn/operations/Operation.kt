package io.fries.rpn.operations

import java.util.*

@FunctionalInterface
interface Operation {
    fun compute(stack: Stack<Double>)
}