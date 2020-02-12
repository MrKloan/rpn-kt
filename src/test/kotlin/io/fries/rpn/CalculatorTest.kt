package io.fries.rpn

import io.fries.rpn.operations.Addition
import io.fries.rpn.operations.Division
import io.fries.rpn.operations.Multiplication
import io.fries.rpn.operations.Subtraction
import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.math.sqrt

object CalculatorTest : Spek({

    describe("Reverse Polish Notation Calculator") {
        val calculator by memoized {
            Calculator {
                register("+", Addition())
                register("-", Subtraction())
                register("*", Multiplication())
                register("/", Division())
                register("SQRT") { it.push(sqrt(it.pop())) }
            }
        }

        describe("Addition") {

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

        describe("Subtraction") {

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

        describe("Multiplication") {

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

        describe("Division") {

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

        describe("Square Root") {

            it("should compute the square root of a value") {
                assertThat(calculator.compute("9 SQRT")).isEqualTo(3.0)
            }
        }
    }
})