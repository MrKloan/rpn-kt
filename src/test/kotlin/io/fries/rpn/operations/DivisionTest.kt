package io.fries.rpn.operations

import org.assertj.core.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.util.*

object DivisionTest : Spek({

    describe("Division") {
        val division by memoized { Division() }
        val stack by memoized { Stack<Double>() }

        it("should divide two values") {
            stack.push(5.0)
            stack.push(2.0)

            division.compute(stack)

            Assertions.assertThat(stack.pop()).isEqualTo(2.5)
        }
    }
})