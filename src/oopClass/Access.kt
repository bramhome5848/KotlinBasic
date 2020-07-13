package oopClass

import oopClass.access.InternalClass2
import oopClass.access.PublicClass2
import oopClass.access.TestClass10
import pkg2.PublicClass3
import pkg2.TestClass11

/**
 * ****** Kotlin ******
 *
 * 동작원리
 * - Kotlin 에서는 클래스에 정의한 모든 변수는 Java 코드로 변경될 때 private가 설정
 * - 접근 제한자의 종류에 따라 Java 코드로 변경될 때 getter 메서드 추가 여부가 결정
 * - Kotlin 에서는 package 가 같냐 다르냐는 아무런 관계 없음, Java 와의 차이점
 *
 * 클래스
 * - private : 외부에서 객체를 생성할 수 없음
 * - public : 외부에서 객체를 생성할 수 있음
 * - protected : 클래스에 지정할 수 없음
 * - internal  : 모듈 같을 경우에만 객체를 생성할 수 있음
 *
 * 변수, 메서드
 * - private : 외부에서 접근할 수 없음
 * - public : 외부에서 접근이 자유로움(기본)
 * - protected : 상속관계일 경우에만 접근이 가능
 * - internal  : 모듈 같을 경우에만 접근이 가능
 *
 * ****** Java ******
 * private -> default -> protected -> public
 * 클래스
 * - private : 클래스에서 지정할 수 없음
 * - public : 외부에서 객체를 생성할 수 있음
 * - protected : 클래스에서 지정할 수 없음
 * - default(생략) : 동일 패키지 안에서 객체 생성 가능
 *
 * 변수, 메서드
 * - private : 외부에서 접근할 수 없음
 * - public : 외부에서 접근이 자유로움(기본)
 * - protected : 동일 패키지 안에서 접근 가능 + 상속관계에 있는 다른 패키지에서 접근 가능(부모가 protected)
 * - default  : 동일 패키지 안에서 접근 가능, 다른 패키지 상속도 접근 불가능
 */
fun main() {

    //private class는 외부에서 사용이 불가능, 상속도 불가능
    //val ojb1 = PrivateClass1()
    val obj2 = PublicClass1()
    val obj3 = InternalClass1()

    //private class는 외부에서 사용이 불가능, 상속도 불가능
    //val ojb4 = PrivateClass2()
    val obj5 = PublicClass2()
    val obj6 = InternalClass2()

    //private class는 외부에서 사용이 불가능, 상속도 불가능
    //val obj7 = PrivateClass3()
    val obj8 = PublicClass3()
    //Internal class 는 다른 모듈에서 사용할 수 없음
    //val obj9 = InternalClass3()

    val t1 = TestClass9()
    //private 멤버는 사용할 수 없음
    //println("t1.private1 = ${t1.private1}")
    println("t1.public1 = ${t1.public1}")
    //protected 멤버는 상속관계가 아니므로 사용할 수 없음
    //println("t1.procted1 = ${t1.procted1}")
    println("t1.internal1 = ${t1.internal1}")

    val t2 = TestClass10()
    //private 멤버는 사용할 수 없음
    //println("t2.private2 = ${t2.private2}")
    println("t2.public2 = ${t2.public2}")
    //protected 멤버는 상속관계가 아니므로 사용할 수 없음
    //println("t2.protected = ${t2.protected2}")
    println("t2.internal2 = ${t2.internal2}")

    val t3 = TestClass11()
    ////private Member 사용 불가
    //println("t3.private3 = ${t3.private3}")
    println("t3.public3 = ${t3.public3}")
    //protected 멤버는 상속관계가 아니므로 사용 불가
    //println("t3.protected3 = ${t3.protected3}")
    //같은 모듈이 아니기 때문에 internal 사용 불가
    //println("t3.internal3 = ${t3.internal3}")
}

class SubClass4: TestClass9() {

    fun subMethod1() {
        //private Member 사용 불가
        //println("private1 = $private1")
        println("public1 = $public1")
        //protected는 상속관계에서만 사용 가능, 자바와 다름
        println("protected1 = $protected1")
        println("internal1 = $internal1")
    }
}

class SubClass5: TestClass10() {

    fun subMethod2() {
        //private Member 사용 불가
        //println("private2 = $private2")
        println("public2 = $public2")
        //상속 관계이기 때문에 protected 사용 가능
        println("protected2 = $protected2")
        println("internal2 = $internal2")
    }
}

class SubClass6: TestClass11() {

    fun subMethod3() {
        //private Member 사용 불가
        //println("private3 = $private3")
        println("public3 = $public3")
        //상속 관계이기 때문에 protected 사용 가능, 다른 모듈이라도 상속관계이면 사용 가능
        println("protected3 = $protected3")
        //같은 모듈이 아니기 때문에 사용 불가
        //println("internal3 = $internal3")
    }
}
