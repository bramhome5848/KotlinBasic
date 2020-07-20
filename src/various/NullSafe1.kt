package various

/**
 * NullPointerException
 * Java 언어로 소프트웨어를 개발하다 보면 NullPointerException 이라는 오류를 자주 만나게 됨
 * 이는 객체의 주소 값이 담겨져 있지 않는 (null 값이 들어있는) 참조 변수를 통해 객체 접근을 시도하면 발생되는 오류
 */

/**
 * Null Safe
 * Kotlin 은 개발자가 null이 담겨 있는 참조변수를 통해 객체 접근을 시도할 때 오류가 발생되는 것을 방지하고자 다양한 방법을 제공
 * 이를 통해 null 값에 대한 안정성을 확보(null safe)할 수 있음
 */
fun main() {

    testFun1("문자열")
    //testFun1(null)  //kotlin.KotlinNullPointerException

    println("--------------------------")

    testFun2("문자열")
    testFun2(null)  //null 안전성을 보장받을 수 있음, null 일 경우 어떤 값을 사용할지 결정할 수 있을 떄 사용

    println("--------------------------")
    testFun3("문자열")
    testFun3(null)

}

/**
 * !! 연산자
 * !! 연산자는 null을 허용하는 변수에 담긴 객체의 주소 값을 null을 허용하지 않는 형태의 값으로 변환하는 연산자
 * null 을 허용하는 변수에 담긴 값을 null을 허용하지 않는 형태의 변수에 담을 경우 사용
 * 변환 과정에서 null 값이 들어 있을 경우 오류가 발생
 * 이 연산자의 사용은 권장하지 않음
 */
fun testFun1(str:String?) {
    val value1:String = str!!   //str -> null 허용, value1: null 불허
    println("value1 = $value1")
}

/**
 * ?: 연산자
 * 참조변수에 null 이 들어있으면 지정된 기본값을 반환
 */
fun testFun2(str:String?) {
    val value1:String = str ?: "기본문자열"  //str - >null 인 경우 "기본문자열"
    println("value1 = $value1")
}

/**
 * ?.
 * 참조변수를 통해 메서드를 호출하거나 멤버 변수를 사용할 때 참조변수에 객체의 주소값이 들어 있다면 객체에 접근해서 메서드나 변수를 사용
 * 만약 참조변수에 null이 들어 있다면 오류가 발생하지 않고 null 을 반환
 */
fun testFun3(str:String?) {
    println("str = $str")
    println("str.length = ${str?.length}")  //null이 아니면 length 실행, null이면 자체가 null이기 때문에 null값을 반환
}

/**
 * !! - null을 허용하지 않는 형태로 변환
 * ?: - null이라면 지정된 기본값이 반환
 * ?. – 메서드 호출 시 null 이라면 메서드가 호출되지 않고 null 반환
 */