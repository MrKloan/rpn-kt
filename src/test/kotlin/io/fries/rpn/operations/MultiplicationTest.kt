package io.fries.rpn.operations

import org.assertj.core.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.util.*

object MultiplicationTest : Spek({

    describe("Multiplication") {
        val multiplication by memoized { Multiplication() }
        val stack by memoized { Stack<Double>() }

        it("should multiply two values") {
            stack.push(2.0)
            stack.push(3.5)

            multiplication.compute(stack)

            Assertions.assertThat(stack.pop()).isEqualTo(7.0)
        }
    }
})