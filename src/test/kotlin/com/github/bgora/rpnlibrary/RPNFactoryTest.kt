package com.github.bgora.rpnlibrary

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class RPNFactoryTest : FreeSpec({

    val tested = RPNFactory(RPNChecker(DefaultStrategyProvider()))
            "should Return RPN" - {
                val text = "( 2 + 3 ) * 5"
                val result = tested.apply(text)
                result shouldBe "2 3 + 5 *"
            }
            "should Return RPN for Function call" - {
                val text = "sin ( 1 )"
                val result = tested.apply(text)
                result shouldBe "1 sin"
            }
            "should Return RPN for Function and equation" - {
                val text = "sin ( 1 ) + 27 * 8"
                val result = tested.apply(text)
                result shouldBe "1 sin 27 8 * +"
            }
            "should Return RPN for  two Functions call" - {
                val text = "sin ( 1 ) + ctg ( 0 )"
                val result = tested.apply(text)
                result shouldBe "1 sin 0 ctg +"
            }
})
