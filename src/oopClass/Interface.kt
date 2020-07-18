package oopClass

/**
 * 인터페이스
 * Kotlin은 다중 상속을 지원하지 않음
 * 이 때문에 자기 타입의 변수나 부모형 타입 변수에만 담을 수 있음
 * 만약 생성된 객체의 주소 값을 다양한 타입에 변수에 담을 수 있도록 한다면 인터페이스를 활용
 *
 * 인터페이스는 클래스가 아니므로 객체를 생성할 때 사용할 수 없음
 * 단, 클래스는 한 개 이상의 인터페이스를 구현할 수 있으며 생성된 객체는 구현한 인터페이스형 참조 변수에 담을 수 있음
 * 인터페이스에는 추상 메서드와 일반 메서드 모두를 구현해서 사용할 수 있음
 * 인터페이스는 추상 클래스와 목적이 비슷하지만 하나의 클래스에 여러 인터페이스를 구현할 수 있는 장점
 */

/**
 * Java 추상 클래스와 인터페이스
 * 추상 클래스
 * -> 클래스 내 추상 메서드가 하나 이상 포함되거나 abstract 로 정의된 경우
 * -> 추상 클래스를 상속 받아 기능을 이용하고 확장시키는 것이 목적
 * 인터페이스
 * -> 모든 메소드가 추상 메서드인 경우(자바 8에서 default 함수를 통해 일반 베서드 기능도 구현 가능)
 * -> 함수의 껍데기만 있는데, 함수의 구현을 강제하여 같은 동작을 보장하기 위함
 * 추상 클래스와 인터페이스는 상속 받는 클래스 혹은 구현하는 인터페이스 안에 있는 추상메서드를 구현하도록 강제함
 * 정리
 * 추상 클래스는 슈퍼클래스의 기능을 이용하거나 확장하기 위해 사용되고, 다중 상속의 모호성 때문에 하나만 상속 가능
 * 인터페이스는 해당 인터페이스를 구현한 객체들에 대해서 동일한 동작을 약속하기 위해 존재
 */
fun main() {

    val obj1 = InterfaceTestClass1()
    val obj2 = InterfaceTestClass2()

    testFun1(obj1)
    testFun2(obj2)

    println("-----------------------------")

    val obj3 = InterfaceTestClass3()
    val obj4 = InterfaceTestClass4()

    testFun3(obj3)
    testFun4(obj4)

    println("-----------------------------")

    //interface 다중 상속의 경우, 각각의 부모 객체로 접근할 수 있는 범위는
    //부모의 함수를 오버라이드한 부분까지
    val obj5 = InterfaceTestClass5()
    testFun3(obj5)
    testFun4(obj5)

    val obj6:Inter1 = InterfaceTestClass5()
    //obj6.inter2Method2()    //Inter1 형의 변수로 Inter2의 함수를 오버라이딩 한 함수에 접근 불가능

}

open abstract class AbstractClass1 {
    open abstract fun abstractMethod1()
}

open abstract class AbstractClass2 {
    open abstract fun  abstractMethod2()
}

class InterfaceTestClass1 : AbstractClass1() {
    override fun abstractMethod1() {
        println("TestClass1의 abstractMethod1")
    }
}

class InterfaceTestClass2 : AbstractClass2() {
    override fun abstractMethod2() {
        println("TestClass2의 abstractMethod2")
    }
}

fun testFun1(obj1:AbstractClass1) {
    obj1.abstractMethod1()
}

fun testFun2(obj2:AbstractClass2) {
    obj2.abstractMethod2()
}

//인터페이스는 모두 추상메서드여야 하지만
//자바8에의 default 메서드 처럼 일반 함수의 구현도 가능함
interface Inter1 {
    fun inter1Method1() {
        println("Inter1의 inter1Method1입니다")
    }

    fun inter1Method2()
}

interface Inter2 {
    fun inter2Method1() {
        println("Inter2의 inter2Method1입니다")
    }

    fun inter2Method2()
}

fun testFun3(obj1:Inter1) {
    obj1.inter1Method1()
    obj1.inter1Method2()
}

fun testFun4(obj2:Inter2) {
    obj2.inter2Method1()
    obj2.inter2Method2()
}

class InterfaceTestClass3: Inter1 {
    override fun inter1Method2() {
        println("TestClass3의 inter1Method2입니다")
    }
}

class InterfaceTestClass4: Inter2 {
    override fun inter2Method2() {
        println("TestClass4의 inter2Method2입니다")
    }
}

class InterfaceTestClass5: Inter1, Inter2 {
    override fun inter1Method2() {
        println("TestClass5의 inter1Method2입니다")
    }

    override fun inter2Method2() {
        println("TestClass5의 inter2Method2입니다")
    }
}



