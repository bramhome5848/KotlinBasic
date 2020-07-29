package functional

/**
 * 확장함수
 * 기존 클래스에 새로운 함수를 추가하는 개념
 * Kotlin 코드에서는 기존 클래스에 메서드를 추가해 사용 하는 것처럼 보이지만
 * 사실 객체의 주소 값을 받은 함수가 만들어지고 그 함수를 호출하는 방식으로 동작
 */
fun main() {

    val str1 = "abcd"
    //String 에 getUpperString() 이 있는 것 처럼 구현
    //실제로 함수가 추가되는 것은 아님
    println(str1.getUpperString())

    //변경된 자바 코드 -> 메서드는 정의 되고, 일반 메서드 호출 방식처럼
    //String str = "abcd";
    //String var1 = getUpperString(str);
}

fun String.getUpperString() : String {
    return this.toUpperCase()
}

