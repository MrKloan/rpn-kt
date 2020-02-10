package io.fries.rpn

import io.fries.rpn.operations.*
import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object CalculatorTest : Spek({

    describe("Reverse Polish Notation Calculator") {
        val calculator by memoized {
            Calculator(OperationRepository(mapOf(
                    "+" to Addition(),
                    "-" to Subtraction(),
                    "*" to Multiplication(),
                    "/" to Division()
            )))
        }

        describe("addition") {

            it("should add two values") {
                assertThat(calculator.compute("1 2 +")).isEqualTo(3.0)
            }

            it("should add multiple values") {
                assertThat(calculator.compute("1 2 + 3 +")).isEqualTo(6.0)
            }

            it("should add multiple values with stacked operators") {
                assertThat(calculator.compute("1 2 3 + +")).isEqualTo(6.0)
            }
        }

        describe("subtraction") {

            it("should subtract two values") {
                assertThat(calculator.compute("2 1 -")).isEqualTo(1.0)
            }

            it("should subtract multiple values") {
                assertThat(calculator.compute("5 1 - 2 -")).isEqualTo(2.0)
            }

            it("should subtract multiple values with stacked operators") {
                assertThat(calculator.compute("5 1 2 - -")).isEqualTo(6.0)
            }
        }

        describe("multiplication") {

            it("should multiply two values") {
                assertThat(calculator.compute("1 2 *")).isEqualTo(2.0)
            }

            it("should multiply multiple values") {
                assertThat(calculator.compute("1 2 * 3 *")).isEqualTo(6.0)
            }

            it("should multiply multiple values with stacked operators") {
                assertThat(calculator.compute("1 2 3 * *")).isEqualTo(6.0)
            }
        }

        describe("division") {

            it("should divide two values") {
                assertThat(calculator.compute("6 3 /")).isEqualTo(2.0)
            }

            it("should divide multiple values") {
                assertThat(calculator.compute("10 2 / 2 /")).isEqualTo(2.5)
            }

            it("should divide multiple values with stacked operators") {
                assertThat(calculator.compute("5 4 2 / /")).isEqualTo(2.5)
            }
        }
    }
})