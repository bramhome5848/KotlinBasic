package functional

/**
 * Infix 함수
 * 함수를 연산자처럼 사용할 수 있는 함수
 */
fun main() {

    val r1 = 100.add1(50)
    println("r1 = $r1")

    val r2 = 100 add2 50
    println("r2 = $r2")
    val r3 = 100.add2(50)
    println("r3 = $r3")

    val r4 = 100 minus2 50
    println("r4 = $r4")
    val r5 = 100.minus2(50)
    println("r5 = $r5")
}

//인라인으로 만든 경우
inline fun Int.add1(a1:Int) : Int {
    return this + a1
}

//infix로 만든 경우
infix fun Int.add2(a1:Int) : Int {
    return this + a1
}

infix fun Int.minus2(a1:Int) : Int {
    return this - a1;
}