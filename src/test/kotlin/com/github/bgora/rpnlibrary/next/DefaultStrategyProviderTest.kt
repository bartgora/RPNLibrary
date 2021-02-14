package com.github.bgora.rpnlibrary.next

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class DefaultStrategyProviderTest : BehaviorSpec({
    Given("Strategy Provider") {
        val tested = DefaultStrategyProvider()
        When("Ask for + operator") {
            val actual = tested.getOperator("+")
            Then("Should return not empty object")
            actual.operator shouldBe "+"
        }
    }
})