package functional

/**
 * 함수형 프로그래밍
 * 자바 언어는 완벽한 객체지향 프로그래밍 언어
 * 모든 코드는 클래스를 설계하고 메서드를 만들어주고 클래스를 통해 객체를 생성해서 사용해야함
 * 하지만 Kotlin는 함수만 만들어 사용하는 것을 지원
 * Kotlin은 함수 사용을 보다 편리하게 할 수 있도록 다양한 개념들이 제공
 */
fun main() {
    val r1 = testFun1(100, 200)
    println("r1 = $r1")

    val r2 = testFun2(100, 200)
    println("r2 = $r2")

    val r3 = testFun3(100, 200)
    println("r3 = $r3")

    /**
     * 람다식
     * 람다식으로 간단하게 표현 가능
     * 특정 함수 내에서만 사용하는 연산 코드를 사용할 때 사용
     */

    //변수 : 타입 = 바디
    val lambda1 : (Int, Int) -> Int = {a1:Int, a2:Int -> a1 + a2}

    //추론 가능하면 타입 생략 가능 -> 가장 많이 사용하는 형태
    val lambda2 = {a1:Int, a2:Int -> a1 + a2}

    //이렇게 사용하는 것도 가능
    val lambda3 : (Int, Int) -> Int = {a1, a2 -> a1 + a2}

    val r4 = lambda1(100, 200)
    println("r4 = $r4")

    val r5 = lambda2(100, 200)
    println("r5 = $r5")

    val r6 = lambda3(100, 200)
    println("r6 = $r6")

    val r7 = testFun4(100, 200)
    println("r7 = $r7")

    val lambda4 = {a1:Int, a2:Int ->
        val r1 = a1 + a2
        val r2 = a1 - a2
        r1 * r2     //람다식의 결과 자바의 경우는 return 필요
    }

    val r8 = lambda4(100, 200)
    println("r8 = $r8")

}

fun testFun1(a1:Int, a2:Int) : Int {
    return a1 + a2;
}

//한 줄 밖에 없는 경우 간단하게 표현 가능
fun testFun2(a1:Int, a2:Int) : Int = a1 + a2

//추론이 가능하면 리턴 타입 생략 가능생략가능
fun testFun3(a1:Int, a2:Int) = a1 + a2

fun testFun4(a1:Int, a2:Int) : Int {
    val r1 = a1 + a2
    val r2 = a1 - a2
    return r1 * r2
}
