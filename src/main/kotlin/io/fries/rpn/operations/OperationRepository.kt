package io.fries.rpn.operations

class OperationRepository(val operations: Map<String, Operation>) {

    fun find(operator: String): Operation = operations.getOrElse(operator) {
        throw IllegalArgumentException("Unknown operator: $operator")
    }
}