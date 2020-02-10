package io.fries.rpn

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object TokenTest : Spek({

    describe("Token") {

        it("should be a double") {
            assertThat(Token("3").isDouble()).isTrue()
        }

        it("should not be a double") {
            assertThat(Token("+").isDouble()).isFalse()
        }

        it("should convert to double") {
            assertThat(Token("3").asDouble()).isEqualTo(3.0)
        }

        it("should convert to string") {
            assertThat(Token("value").asString()).isEqualTo("value")
        }
    }
})