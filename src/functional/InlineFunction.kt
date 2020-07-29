package functional

/**
 * 인라인 함수
 * Kotlin 코드가 Java 코드로 변경될 때 함수를 호출하는 코드를 함수내에 구현한 코드로 변경하는 함수
 * 함수 호출 방식은 전체 코드양이 줄어들어 메모리를 적게 쓴다는 장점이 있지만 호출 시 코드 흐름이 이동하고 다시 돌아와야 하기 때문에 작업량이 늘어남
 * 인라인 함수는 전체 코드양이 늘어 메모리를 더 많이 사용하지만 코드 흐름의 이동 없이 수행되기 때문에 작업량이 늘어나지 않음
 * *** 함수가 호출되는 것이 아닌 함수의 코드가 복사되어 수행되는 함수를 inline 함수라고 함 ***
 */
fun main() {
    inlineFunctionTestFunction1()
    inlineFunctionTestFunction1()

    //실제 함수 호출은 똑같이 이루어지지만
    //변경된 자바 코드로 확인했을 경우 testFunc2의 내용이
    //main 에 덮어 씌워져 있음
    //미세한 성능 차이
    //메모리냐 성능이냐
    inlineFunctionTestFunction2()
    inlineFunctionTestFunction2()
}

fun inlineFunctionTestFunction1() {
    println("-------------------")
    println("testFunc1")
    println("-------------------")
}

inline fun inlineFunctionTestFunction2() {
    println("-------------------")
    println("testFunc2")
    println("-------------------")
}