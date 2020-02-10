package io.fries.rpn.operations

import java.util.*

object NoopOperation : Operation {
    override fun compute(stack: Stack<Double>) = Unit
}