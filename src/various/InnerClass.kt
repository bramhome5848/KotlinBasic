package various

/**
 * 중첩 클래스
 * 클래스안에 만드는 클래스
 * 중첩 클래스에서는 각 클래스에 정의한 멤버를 사용할 수 있는가를 숙지
 */

/**
 * 익명 중첩 클래스
 * 이름이 없는 클래스를 익명 중첩 클래스
 * 인터페이스나 추상클래스를 사용할 때 이용
 * 인터페이스를 구현한 클래스나 추상 클래스를 상속받은 클래스를 만듬과 동시에 메서드를 Overriding 하고 객체를 생성하는 것 까지 수행
 * 이름이 없으므로 다시는 객체를 생성할 수 없음
 */
fun main() {

    val obj1 = Outer1()
    val obj2 = obj1.Inner1()

    obj2.innerMethod2()
    obj1.outerMethod1()
    obj1.outerMethod2()

    println("------------------------------")

    val t1 = InnerClassTestClass2()
    t1.testMethod1()

    val t2 = InnerClassTestClass3()
    t2.interMethod1()

    val t3 = object : InnerClassTestClass1() {
        override fun testMethod1() {
            println("익명 충첩 클래스이 testMethod1")
        }
    }

    t3.testMethod1()

    val t4 = object : InnerClassTestInter1 {
        override fun interMethod1() {
            println("익명 중첩 클래스의 interMethod1")
        }
    }

    t4.interMethod1()
}

/**
 * 내부 클래스는 외부 클래스로부터 생성된 객체를 통해서만 객체 생성이 가능
 * 외부 클래스는 내부 클래스의 멤버를 자유롭게 사용할 수 없지만 내부 클래스는 외부 클래스의 멤버를 자유롭게 사용할 수 있음
 */
class Outer1 {

    val outerMember1 = 100

    fun outerMethod1() {
        println("Outer Method")
    }

    fun outerMethod2() {

        //println("innerMember1 = ${innerMember1}")
        //innerMethod1()
        val obj3 = Inner1()
        println("obj3.innerMember = ${obj3.innerMember1}")
        obj3.innerMethod1()
    }

    //안쪽에서는 바깥쪽에 대한 접근이 자유로움
    //바깥쪽 객체 생성 후에 안쪽 생성이 가능하기 때문
    inner class Inner1 {
        val innerMember1 = 200

        fun innerMethod1() {
            println("Inter Method")
        }

        fun innerMethod2() {
            println("outerMember1 = $outerMember1")
            outerMethod1()
        }
    }
}

abstract class InnerClassTestClass1 {

    abstract fun testMethod1()
}

interface InnerClassTestInter1 {
    fun interMethod1()
}

class InnerClassTestClass2 : InnerClassTestClass1() {

    override fun testMethod1() {
        println("TestClass2의 testMethod1")
    }
}

class InnerClassTestClass3 : InnerClassTestInter1 {
    override fun interMethod1() {
        println("TestClass3의 interMethod1")
    }

}