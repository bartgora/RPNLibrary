package com.github.bgora.rpnlibrary

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class InputTransformerTest : FreeSpec({
    val tested = InputTransformer(RPNChecker(DefaultStrategyProvider()));
    "should Return transferred Text" - {

        val text = "(1+2)*5"

        val result = tested.apply(text)

        result shouldBe "( 1 + 2 ) * 5"
    }
 })
