package oopClass

import control.testFun1

/**
 * Any
 * Kotlin 에서 사용하는 모든 클래스의 부모 클래스 -> Java 의 Object
 * Kotlin 은 클래스를 작성할 때 상속받지 않는다면 자동으로 Any 클래스를 상속
 * Any 클래스에는 모든 객체가 가지고 있어야할 메서드가 제공되고 있으며 이 메서드들을 Overriding 하여
 * 각 클래스의 성격에 맞게 재 구현하여 사용할 수 있음
 */
fun main() {

    val obj1 = AnyTestClass1()
    println("obj1 = $obj1")

    val obj2 = AnyTestClass2()
    val obj3 = AnyTestClass3()

    testFun1(obj1)
    testFun1(obj2)
    testFun1(obj3)
}

class AnyTestClass1 {   //자동으로 any 상속

    override fun toString(): String {
        return "TestClass1의 객체입니다"
    }
}

class AnyTestClass2 {   //자동으로 any 상속

    override fun toString(): String {
        return "TestClass2의 객체입니다"
    }
}

class AnyTestClass3 {   //자동으로 any 상속

    override fun toString(): String {
        return "TestClass3의 객체입니다"
    }
}

//부모 클래스의 참조 변수를 가지고 -> 각각의 자식들의 함수 호출
//오버라이딩 된 경우 가능
fun testFun1(a1:Any) {
    println("any = $a1")
}