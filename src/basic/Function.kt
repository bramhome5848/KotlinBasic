package basic

/**
 * Java 에서는 클래스에 메서드를 만들어 사용하지만 Kotlin 은 c 언어처럼 함수라는 개념을 제공하고 있음
 */
fun main() {
    test1()
    test2(100, 55.55)
    test2(200, 66.66)
    test2(a2 = 77.7, a1 = 30)   //이름 설정으로 순서를 다르게 입력할 수 있음
    test3(100, 1.1)
    test3();    //기본값이 세팅 되어 있기 때문에 가능, 그렇지 않은 경우는 반드시 매개변수 이용
    test3(1);
    test3(a2=2.0);

    val a1:Int = test4(100, 200)
    val a2:Int = test4(1000, 2000)
    println("a1 = $a1")
    println("a2 = $a2")

    test5(10,20)
    test6(10,20)

    test7();
    test7(1);
    test7(1.3);
    test7(30,30);

    test8()
}

/**
 * fun 함수명(매개변) : 반환값 타입{
 * }
 */
fun test1() {
    println("test1 호출")

}

/**
 * 매개 변수 형태 변수명: 자료형
 * 자바 처럼 순서대로 쓰지 않고 호출시 해당 값에 매핑되도록 적어줘도 됨
 */
fun test2(a1:Int, a2:Double) {
    println("test2 호출")
    println("a1 = $a1")
    println("a2 = $a2")
}

/**
 * 기본 값을 설정할 경우 값을 전달하지 않으면 기본값이 변수에 설정
 */
fun test3(a1:Int = 0, a2:Double = 0.0){
    println("test3 호출")
    println("a1 = $a1")
    println("a2 = $a2")
}

/**
 * return type
 */
fun test4(a1:Int, a2:Int) : Int{
    println("test4 호출")
    return a1+a2
}

/**
 * Java 의 void -> Unit : 생략가능
 */
fun test5(a1:Int, a2:Int):Unit {
    println("test5 호출")
}

fun test6(a1:Int, a2:Int) {
    println("test6 호출")
}

/**
 *  함수 오버로딩 : 매개 변수의 형태를 다르게 하여 같은 이름으로 여러 함수 정의
 */
fun test7(){
    println("test7이 호출 - 매개변수 없음")
}

fun test7(a1:Int){
    println("test7이 호출 - 정수형 매개변수 : $a1")
}

fun test7(a1:Double){
    println("test7이 호출 - 실수형 매개변수 : $a1")
}

fun test7(a1:Int, a2:Int){
    println("test7이 호출 - 매개변수 두 개 : $a1, $a2")
}

/**
 * 지역함수
 * - 함수 내에 함수
 * - 함수를 정의한 함수 안에서만 호출 가능
 */
fun test8() {
    println("test8이 호출")

    fun test9() {
        println("test9이 호출")
    }

    test9()
}

/**
 * Kotlin 은 함수로만 프로그램 작성이 가능
 * fun 함수명(매개변수) : 반환값 타입 {코드들..}
 */

