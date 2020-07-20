package various

/**
 * Sealed Class
 * 열거형은 특정 값을 의미하는 상수들을 모아 관리하는 개념이라면 Sealed Class를 객체를 모아 관리하는 개념
 * 열거형의 경우 상수에 지정된 값은 절대로 변경이 불가능 하지만
 * Sealed Class를 객체를 관리하는 개념이므로 객체가 가지고 있는 변수에 값을 설정하여 지정된 값을 변경하는 것이 가능
 * 열거형 사용 시 상수가 의미하는 값을 수시로 변경하거나 다양한 형태로 사용하고자 할 때 사용
 */
fun main() {

    val v1 = SealedClassNumber.TWO  //이 값은 변경 불가능
    checkNumber(v1)

    println("--------------------------")

    val v2 = SealedClassNumber2.SealedTwo(1)
    val v3 = SealedClassNumber2.SealedTwo(2)
    val v4 = SealedClassNumber2.SealedOne(100,200)
    val v5 = SealedClassNumber2.SealedThree(100,11.11)

    checkNumber2(v2)
    checkNumber2(v3)
    checkNumber2(v4)
    checkNumber2(v5)
}

enum class SealedClassNumber(val num:Int) {
    ONE(1)
    , TWO(2)
    , THREE(3)
}

fun checkNumber(a1:SealedClassNumber) {
    when(a1) {
        SealedClassNumber.ONE -> println("1입니다")
        SealedClassNumber.TWO -> println("2입니다")
        SealedClassNumber.THREE -> println("3입니다")
    }

    when(a1.num) {
        1 -> println("1입니다")
        2 -> println("2입니다")
        3 -> println("3입니다")
    }
}

//열거형의 경우 실제 값을 지정하지만
//sealed는 구성하는 클래스 타입만 지정
sealed class SealedClassNumber2 {
    //다양한 형태로 사용가능
    //각각이 클래스이기 때문에 내부에 메서드 정의도 가능
    class SealedOne(val a1:Int, val a2:Int) : SealedClassNumber2()
    class SealedTwo(val a1:Int) : SealedClassNumber2() {
        fun sealedFun2() {
            println("SealedTwo의 sealedFun2 입니다")
        }
    }
    class SealedThree(val a1:Int, val a2:Double) : SealedClassNumber2()
}

fun checkNumber2(obj1:SealedClassNumber2) {
    when(obj1) {
        //if문 처럼 smart casting 발생
        is SealedClassNumber2.SealedOne -> {
            println("One 입니다")
            println(obj1.a1)
            println(obj1.a2)
        }
        is SealedClassNumber2.SealedTwo -> {
            println("Two 입니다")
            println(obj1.a1)
            when(obj1.a1) {
                1 -> println("1 입니다")
                2 -> println("2 입니다")
            }
            obj1.sealedFun2()
        }
        is SealedClassNumber2.SealedThree -> {
            println("Three 입니다")
            println(obj1.a1)
            println(obj1.a2)
        }
    }
}