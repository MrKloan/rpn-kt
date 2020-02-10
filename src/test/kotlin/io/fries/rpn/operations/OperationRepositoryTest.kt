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

        it("should throw when the operation repository is empty") {
            assertThatExceptionOfType(IllegalArgumentException::class.java)
                    .isThrownBy { OperationRepository(mapOf()) }
                    .withMessage("Operation repository cannot be empty")
                    .withNoCause()
        }
    }

    describe("Operation Repository builder") {
        val builder by memoized { OperationRepository.Builder() }

        it("should trim the registered operator") {
            builder.register(" NOOP   ", NoopOperation)

            assertThat(builder.build().find("NOOP")).isEqualTo(NoopOperation)
        }
    }
})