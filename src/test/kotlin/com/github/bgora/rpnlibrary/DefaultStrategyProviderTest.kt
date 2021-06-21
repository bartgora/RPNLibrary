package com.github.bgora.rpnlibrary

import com.github.bgora.rpnlibrary.functions.*
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
        row("^", PowerOperatorStrategy())
    )

    "getOperator should return Operators" - {

        operatorList.forEach {
            val operator = it.a
            val result = tested.getOperator(operator)
            result.operator shouldBe it.a
            result.priority shouldBe it.b.priority
        }

    }

    "getOperator should Return null for Invalid Operator Name" - {

        val result = tested.getOperator("@")
        result shouldBe null
    }

    "isOperator should Return false for not exiting operator" - {
        val result = tested.isOperatorAvailable("@")
        result shouldBe false
    }

    "isOperatorAvailable should return true for existing operator " - {
        operatorList.forEach {
            val operator = it.a
            val result = tested.isOperatorAvailable(operator)
            result shouldBe true
        }
    }

    val functionList = listOf(
        row("sin", SinusFunctionStrategy()),
        row("cos", CosFunctionStrategy()),
        row("fib", FibFunctionStrategy()),
        row("tg", TanFunctionStrategy()),
        row("ctg", CtgFunctionStrategy()),
        row("max", MaxFunctionStrategy()),
        row("min", MinFunctionStrategy()),
        row("fib", FibFunctionStrategy())
    )

    "getFunction should return Functions" - {

        functionList.forEach {
            val function = it.a
            val result = tested.getFunction(function)
            result.name shouldBe it.a
            result.paramCount shouldBe it.b.paramCount
        }

    }

    "getFunction should Return null for Invalid function name" - {

        val result = tested.getFunction("@")
        result shouldBe null
    }

    "isFunction should return false for not exiting function" - {
        val result = tested.isFunctionAvailable("@")
        result shouldBe false
    }

    "isFunctionAvailable should return true for existing function " - {
        functionList.forEach {
            val function = it.a
            val result = tested.isFunctionAvailable(function)
            result shouldBe true
        }
    }

})