package oopClass

/**
 * 추상 메서드와 추상 클래스
 * 추상 메서드는 구현되지 않은 메서드를 의미
 * 추상 클래스는 추상 메서드를 가지고 있는 클래스를 의미
 * 추상 클래스는 구현 되지 않은 추상 메서드를 가지고 있기 때문에 완벽한 설계도라고 할 수 없음
 * 이 때문에 추상클래스를 통해서는 객체를 생성할 수 없다.
 */

/**
 * 추상 클래스의 상속
 * 추상 클래스는 완벽한 클래스가 아니기 때문에 객체를 생성할 수 없음
 * 객체를 생성하려면 추상 클래스를 상속받은 클래스를 만들고 추상 메서드를 구현하여 자식 클래스를 통해 객체를 생성
 * 추상 클래스의 목적은 자식 클래스에서 메서드를 Overriding 을 하게 하기 위한 강제성을 부여하기 위함
 */
fun main() {
    //추상 클래스는 직접 객체 생성 안됨
    //val obj1 = AbstractSuper1()
    //testFun1(obj1)

    val obj2 = AbstractSub1()
    testFun1(obj2)

    val obj3 = AbstractSub2()
    testFun1(obj3)
}

open abstract class AbstractSuper1 {

    fun method1() {
        println("Super1의 method1입니다")
    }

    open abstract fun method2()
}

class AbstractSub1 : AbstractSuper1() {

    //추상 클래스의 추상 메서드 구현
    override fun method2() {
        println("Sub1의 method2입니다")
    }
}

//상속 받은 클래스에서 반드시 override 하게끔 강제하기 위해 추상메서드를 사용
class AbstractSub2: AbstractSuper1() {

    override fun method2() {
        println("Sub2의 method2입니다")
    }
}

fun testFun1(obj1:AbstractSuper1) {
    obj1.method1()
    obj1.method2()
}

/**
 * 구현되지 않은 메서드를 추상 메서드라고 부르며 추상 메서드를 가지고 있는 클래스를 추상 클래스
 * 추상 클래스는 자식 클래스에서 메서드를 Overriding 하게 하기 위함
 */
