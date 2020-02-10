package io.fries.rpn.operations

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object OperationRepositoryTest : Spek({

    describe("Operation Repository") {
        val operationRepository by memoized {
            OperationRepository(mapOf(
                    "NOOP" to NoopOperation
            ))
        }

        it("should find an operation by its operator") {
            assertThat(operationRepository.find("NOOP")).isEqualTo(NoopOperation)
        }

        it("should throw when the operator does not exist") {
            assertThatExceptionOfType(IllegalArgumentException::class.java)
                    .isThrownBy { operationRepository.find("UNKNOWN") }
                    .withMessage("Unknown operator: UNKNOWN")
                    .withNoCause()
        }
    }
})