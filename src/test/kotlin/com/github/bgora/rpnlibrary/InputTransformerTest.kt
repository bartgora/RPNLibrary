package com.github.bgora.rpnlibrary

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class InputTransformerTest : FreeSpec({
    val tested = InputTransformer(RPNChecker(DefaultStrategyProvider()))
     "should Return empty Text" - {
         val text = ""
         val result = tested.apply(text)
         result shouldBe ""
                                          }
    "should Return transferred Text" - {
        val text = "(1+2)*5"
        val result = tested.apply(text)
        result shouldBe "( 1 + 2 ) * 5"
    }
     "should Return Transferred Function Text" -{
         val text = "sin(15)"
         val result = tested.apply(text)
         result shouldBe "sin ( 15 )"

     }

     "should Return Transferred Text For Function and equation" -{
        val text = "sin(15) + (21 *5)"
        val result = tested.apply(text)
        result shouldBe "sin ( 15 ) + ( 21 * 5 )"

     }
 })
