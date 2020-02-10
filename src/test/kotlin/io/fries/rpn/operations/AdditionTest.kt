package io.fries.rpn.operations

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.util.*

object AdditionTest : Spek({

    describe("Addition") {
        val addition by memoized { Addition() }
        val stack by memoized { Stack<Double>() }

        it("should add two values") {
            stack.push(1.0)
            stack.push(2.0)

            addition.compute(stack)

            assertThat(stack.pop()).isEqualTo(3.0)
        }
    }
})