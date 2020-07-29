package functional

/**
 * 고차 함수
 * 함수를 매개변수로 받거나 반환 타입이 함수인 함수를 고차 함수라고 부름
 * 함수 호출 시 전달하는 함수와 반환 하는 함수는 람다식을 사용할 수도 있음
 */
fun main() {

    //일반 함수는 전달할 수 없고 익명함수의 경우 전달 가능
    val t1 = fun(x1:Int, x2:Int) : Int {
       return  x1+x2
    }

    highOrderFunctionTestFunc1(t1, 100, 200)

    //익명함수 이기 때문에 바로 넣어줄 있음
    highOrderFunctionTestFunc1(fun(x1:Int, x2:Int) : Int {
        return x1 - x2
    }, 100, 200)

    //lambda 를 넘기는 것도 가능
    val lambda1 = {x1:Int, x2:Int -> x1 * x2}
    highOrderFunctionTestFunc1(lambda1, 100, 200)

    highOrderFunctionTestFunc1({x1:Int, x2:Int -> x1 / x2}, 200, 100)

    val t2 = highOrderFunctionTestFunc2()
    val r2 = t2(100, 200)
    println("r2 = $r2")

    val t3 = highOrderFunctionTestFunc3()
    val r3 = t3(100, 200)
    println("r3 = $r3")

    //Kotlin 에서 고차 함수를 사용하면 편한 경우, lambda
    highOrderFunctionTestFunc4({x1:Int -> x1 + 100}, 200)
    //매개 변수가 1개일 경우 it 사용, 2개 이상의 경우는 모두 작성
    highOrderFunctionTestFunc4({it+100}, 200)

    //람다식이 맨 뒤에 있는 경우, 작성이 용이하도록 지원
    //highOrderFunctionTestFunc5(100, 200, {x1:Int, x2:Int -> x1 + x2})
    highOrderFunctionTestFunc5(100, 200) { x1:Int, x2:Int
        -> x1 + x2
    }

    highOrderFunctionTestFunc6 ({x1:Int -> println(x1)})
    //파라미터가 1개이기 때문에 it으로 표현 가능
    highOrderFunctionTestFunc6 { println(it) }
}

fun highOrderFunctionTestFunc1(m1:(Int, Int) -> Int, a1:Int, a2:Int) {

    val r1 = m1(a1, a2)
    println("r1 = $r1")
}

fun highOrderFunctionTestFunc2() : (Int, Int) -> Int {
    //익명함수 반환
    return fun(x1:Int, x2:Int) : Int {
        return x1 + x2
    }
}

fun highOrderFunctionTestFunc3() : (Int, Int) -> Int {
    //람다 반환
    return {x1:Int, x2:Int -> x1 - x2}
}

fun highOrderFunctionTestFunc4(m1:(Int) -> Int, a1:Int) {
    val r4 = m1(a1)
    println("r4 = $r4")
}

fun highOrderFunctionTestFunc5(a1:Int, a2:Int, m1:(Int, Int) -> Int) {
    val r5 = m1(a1, a2)
    println("r5 = $r5")
}

fun highOrderFunctionTestFunc6(m1:(Int) -> Unit) {
    m1(100)
}

