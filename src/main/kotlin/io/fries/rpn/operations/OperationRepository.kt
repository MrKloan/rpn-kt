package io.fries.rpn.operations

import java.util.*

class OperationRepository(val operations: Map<String, Operation>) {

    init {
        if (operations.isEmpty()) {
            throw IllegalArgumentException("Operation repository cannot be empty")
        }
    }

    fun find(operator: String): Operation = operations.getOrElse(operator) {
        throw IllegalArgumentException("Unknown operator: $operator")
    }

    class Builder {

        private val operations: MutableMap<String, Operation> = mutableMapOf()

        fun register(operator: String, operation: Operation) = apply {
            operations[operator.trim()] = operation
        }

        fun register(operator: String, operation: (Stack<Double>) -> Unit) = register(
                operator,
                object : Operation {
                    override fun compute(stack: Stack<Double>) {
                        operation(stack)
                    }
                }
        )

        fun build(): OperationRepository {
            return OperationRepository(operations)
        }
    }
}