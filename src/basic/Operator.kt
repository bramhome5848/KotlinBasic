package basic

/**
 * 일부를 제외한 대부분의 특수 문자를 연산자로 사용
 * 주어진 값을 정해진 방식에 따라 계산하고 그 값을 되돌려 줌
 * Kotlin 은 연산자와 함수 두 가지를 제공한다.
 */
fun main() {
    //단항 연산자

    // + : 양수 -> 양수, 음수 -> 음수
    val a1:Int = 10
    val a2:Int = -10

    val r1:Int = +a1
    val r2:Int = +a2

    println("a1 = $a1, r1 = $r1")
    println("a2 = $a2, r2 = $r2")

    // - : 음수-> 양수, 양수 -> 음수

    val r3:Int = -a1
    val r4:Int = -a2

    println("a1 = $a1, r3 = $r3")
    println("a2 = $a2, r4 = $r4")

    // ! : true -> false, false -> true
    val a3:Boolean = true
    val a4:Boolean = false

    val r5:Boolean = !a3
    val r6:Boolean = !a4

    println("a3 = $a3, r5 : $r5")
    println("a4 = $a4, r6 : $r6")

    println("-------------------------------------------")

    var a5:Int = 10;
    var a6:Int = 10;

    val r7:Int = a5++
    val r8:Int = a6--

    println("a5 = $a5, r7 : $r7")
    println("a6 = $a6, r8 : $r8")

    var a7:Int = 10;
    var a8:Int = 10;

    val r9 = ++a7
    val r10 = --a8

    println("a7 = $a7, r9 : $r9")
    println("a8 = $a8, r10 : $r10")

    println("-------------------------------------------")
    val r11:Int = 10 + 3
    val r12:Int = 10 - 3
    val r13:Int = 10 * 3
    val r14:Int = 10 / 3
    val r15:Int = 10 % 3

    println("$r11, $r12, $r13, $r14, $r15")
    val r16:IntRange = 10..20   //10부터 20까지 값을 관리하는 요소
    println("r16 = $r16")

    var a9:Int = 10;
    var a10:Int = 10;
    var a11:Int = 10;
    var a12:Int = 10;
    var a13:Int = 10;

    a9 += 3
    a10 -= 3
    a11 *= 3
    a12 /= 3
    a13 %= 3

    println("$a9, $a10, $a11, $a12, $a13")

    println("-------------------------------------------")

    val a14:Int = 10;

    val r17:Boolean = a14 == 10
    val r18:Boolean = a14 != 10

    println("$r17, $r18")
    val r19:Boolean = a14 == 20
    val r20:Boolean = a14 != 20

    println("$r19, $r20")

    println("-------------------------------------------")
    val a15:Int = 10

    val r21:Boolean = a15 < 20
    val r22:Boolean = a15 > 20
    val r23:Boolean = a15 <= 10
    val r24:Boolean = a15 >= 10

    println("$r21, $r22, $r23, $r24")
}