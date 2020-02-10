package io.fries.rpn.operations

class OperationRepository(val operations: Map<String, Operation>) {

    fun find(operator: String): Operation = operations.getOrElse(operator) {
        throw IllegalArgumentException("Unknown operator: $operator")
    }

    class Builder {

        private val operations: MutableMap<String, Operation> = mutableMapOf()

        fun register(operator: String, operation: Operation) = apply {
            operations[operator] = operation
        }

        fun build(): OperationRepository {
            return OperationRepository(operations)
        }
    }
}