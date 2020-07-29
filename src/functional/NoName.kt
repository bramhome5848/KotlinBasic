package functional

/**
 * 익명함수
 * 함수의 이름이 없는 함수
 * 함수를 변수에 담아 관리할 때 사용
 * 뒤에서 배울 고차함수와 관련이 깊음
 */
fun main() {
    //기존 함수 호출 -> 이름을 통해
    noNameTestFunction1()

    //Kotlin -> 함수의 이름을 가지고 함수의 주소값을 가지고와서 변수에 담는 것이 불가능
    //val testFunction2 = noNameTestFunction1

    //이름이 없는 함수
    //이름이 없기 때문에 이름을 통해서는 접근 불가능
    //변수를 통해서 접근 가능
    val testFunction2 = fun() {
        println("testFunction2 입니다")
    }

    testFunction2()

}

fun noNameTestFunction1() {
    println("testFunction1 입니다")
}
