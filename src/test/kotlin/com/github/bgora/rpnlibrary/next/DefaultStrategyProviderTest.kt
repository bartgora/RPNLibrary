package com.github.bgora.rpnlibrary.next

import com.github.bgora.rpnlibrary.operators.*
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class DefaultStrategyProviderTest : FreeSpec({
    val tested = DefaultStrategyProvider()
    val operatorList = listOf(
        row("+", AddOperatorStrategy()),
        row("-", SubtractOperatorStrategy()),
        row("*", MultiplyOperatorStrategy()),
        row("/", DivideOperatorStrategy()),
        row("^", PowerOperatorStrategy()))

    "getOperator should return Operators" - {

        operatorList.forEach {
            it
            val operator = it.a;
            val result = tested.getOperator(operator)
            result.operator shouldBe it.a
            result.priority shouldBe it.b.priority
        }

    }

    "Should Return null for Invalid Operator Name"-{

        val result = tested.getOperator("@")
        result shouldBe null
    }

    "Should Return false for not exiting operator"-{
        val result = tested.isOperatorAvailable("@")
        result shouldBe false
    }

    "isOperatorAvailable should return true for existing operator "-{
        operatorList.forEach {
            it
            val operator = it.a;
            val result = tested.isOperatorAvailable(operator)
            result shouldBe true
        }
    }

})