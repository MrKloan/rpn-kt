package io.fries.rpn

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe


object CalculatorTest : Spek({

    describe("a Reverse Polish Notation Calculator") {
        val calculator by memoized { Calculator() }

        describe("addition") {

            it("should add two values") {
                assertThat(calculator.compute("1 2 +")).isEqualTo(3)
            }
        }
    }
})