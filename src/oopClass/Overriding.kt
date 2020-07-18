package oopClass

fun main() {

    val obj1:OverridingSubClass1 = OverridingSubClass1()
    println("obj1.subA1 = ${obj1.subA1}")
    obj1.subMethod1()

    println("obj1.superA1 = ${obj1.superA1}")
    obj1.superMethod1()

    println("-----------------------------------------")

    val obj2:OverridingSuperClass1 = obj1   //상속관계이기 때문에 가능

    println("obj2.superA1 = ${obj2.superA1}")
    obj2.superMethod1()

    //부모 클래스형 참조 변수를 사용하면 부모 클래스에 정의되어 있는 멤버만 사용 가능
    //println("obj2.subA1 = ${obj2.subA1}")
    //obj2.subMethod1()

    println("-----------------------------------------")
    val obj3:OverridingSubClass2 = OverridingSubClass2()
    obj3.superMethod2()

    /**
     * Overriding 의 효과
     * 만약 객체가 부모형 참조변수에 담겨 있다면 부모 영역에 정의한 맴버만 사용 가능
     * 만약 부모의 메서드를 자식에서 Overriding 을 했다면 부모형 참조 변수를 통해 자식의 메서드를 호출 할 수 있음
     * 이는 이벤트 처리 방식에서 사건이 발생했을 경우 개발자가 만든 메서드를 호출하기 위해 사용하는 매우 중요한 개념
     */

    val obj4:OverridingSuperClass2 = obj3
    obj4.superMethod2() //부모의 함수를 재정의 한 것이기 때문에 부모의 영역을 벗어나도 접근 가능

    println("-----------------------------------------")
    val obj5:OverridingSuperClass3 = OverridingSuperClass3()
    overridingTest(obj5)

    val obj6:OverridingSubClass3 = OverridingSubClass3()
    overridingTest(obj6)
}

open class OverridingSuperClass1 {

    var superA1 = 100

    fun superMethod1() {
        println("SuperClass1의 superMethod1 입니다")
    }
}

class OverridingSubClass1 : OverridingSuperClass1() {

    var subA1 = 200

    fun subMethod1() {
        println("SubClass1의 subMethod1 입니다")
    }
}

open class OverridingSuperClass2 {

    //open 키워드를 추가할시 자식 메서드에서 재정의가 가능
    open fun superMethod2() {
        println("SuperClass2의 superMethod2")
    }
}

class OverridingSubClass2 : OverridingSuperClass2() {

    override fun superMethod2() {
        println("SubClass2의 superMethod2")
    }
}

open class OverridingSuperClass3 {

    open fun superMethod3() {
        println("SuperClass3의 superMethod3")
    }
}

class OverridingSubClass3 : OverridingSuperClass3() {

    override fun superMethod3() {
        super.superMethod3()    //부모 클래스의 method 호출
        println("SubClass3의 superMethod3")
    }
}

fun overridingTest(obj1:OverridingSuperClass3) {

    obj1.superMethod3()
}

/**
 * 부모형 참조변수에 객체에 자식형 객체를 담으면 부모 클래스 영역에 정의한 맴버에 접근할 수 있음
 * 만약 자식에서 메서드를 Overriding 했다면 부모형 참조 변수에서 자식의 메서드를 호출 할 수 있음
 */