package io.fries.rpn.operations

import org.assertj.core.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.util.*

object SubtractionTest : Spek({

    describe("Subtraction") {
        val subtraction by memoized { Subtraction() }
        val stack by memoized { Stack<Double>() }

        it("should subtract two values") {
            stack.push(5.0)
            stack.push(3.0)

            subtraction.compute(stack)

            Assertions.assertThat(stack.pop()).isEqualTo(2.0)
        }
    }
})