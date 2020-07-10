package oopClass

/**
 * 객체 지향 프로그래밍이란 프로그램에서 사용되는 여러 데이터나 기능을 객체로 묶어서 관리하는 프로그래밍 기법
 * 특정 매개체의 데이터를 관리하기 위해 사용 하는 것이 kotlin 의 객체
 * Kotlin 에서 객체는 자바와 동일하게 클래스를 설계하고 이를 통해 생성
 * Java 는 모든 코드들을 클래스 안에 작성, 기능등을 구현하는 코드를 작성해도 무조건 클래스를 만들고 그 안에 작성
 * 하지만 kotlin 은 함수를 지원하기 때문에
 * kotlin 에서 객체는 매개체 하나에 대한 정보와 기능을 담고 있는 프로그램 요소
 */
fun main() {

    val obj1:TestClass1 = TestClass1()
    println("obj1 = $obj1") //객체 주소값

    val obj2:TestClass1 = TestClass1()
    println("obj2 = $obj2")

    val obj3 = obj1;
    println("obj3 = $obj3")

    val obj4 = TestClass2()
    println("obj4 = $obj4")

    val obj5 = TestClass3()
    println("obj5.a1 = ${obj5.a1}")
    println("obj5.a2 = ${obj5.a2}")

    //obj5.a1 = 100
    obj5.a2 = 200

    println("obj5.a2 = ${obj5.a2}")

    obj5.testMethod1()
    obj5.testMethod2()
}

class TestClass1 {  //내용이 없다면 {} 생략 가능
}

class TestClass2

class TestClass3 {

    //멤버 변수
    val a1 = 0
    var a2 = 0

    //멤버 메서드, 함수와 구분 -> Java 와 코드 구조가 조금 다른 부분
    fun testMethod1() {
        println("testMethod1")
    }

    fun testMethod2() {
        println("testMethod2")
    }
}