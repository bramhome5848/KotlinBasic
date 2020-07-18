package oopClass

/**
 * This
 * 객체 자기 자신을 지칭
 * 멤버 변수와 메서드 내부의 변수를 구분할 때 사용
 * 멤버 메서드와 메서드 내부의 메서드를 구분할 때 사용
 * 생성자에서 다른 생성자를 호출할 때 사용
 */

/**
 * Super
 * 부모 영역을 지칭
 * 멤버 변수와 상속받은 멤버 변수를 구분할 때 사용
 * Overriding 한 메서드와 부모의 메서드를 구분할 때 사용
 * 부모의 생성자를 호출할 때 사용
 */
fun main() {

    val obj1 = ThisSuperTestClass1()
    obj1.testMethod1()

    println("----------------------------")

    val obj2 = ThisSuperSubClass()
    obj2.subMethod1()
}

class ThisSuperTestClass1 (var a2:Int){ //주 생성자

    var a1 = 100

    //보조 생성자
    constructor() :this(100){

    }

    fun testMethod1() {

        var a1 = 200    //같은 변수 명에 대해서 shadowing
        println("a1 = $a1")
        println("this.a1 = ${this.a1}") //객체에 대한 변수를 사용할 경우에도 사용 가능

        fun testMethod2() {
            println("testMethod1 내부의 testMethod2")
        }

        testMethod2()   //함수 또한 같은 명칭에 대해 shadowing -> 단 사용하기 전에 선언되어 있는 경우
        this.testMethod2()  //클래스의 testMethod2 실행
    }

    fun testMethod2() {
        println("testMethod2")
    }
}

open class ThisSuperSuperclass(var a2:Int) {

    open var a1 = 100

    open fun superMethod1() {
        println("SuperClass의 superMethod1")
    }
}

class ThisSuperSubClass : ThisSuperSuperclass(100) {   //부모 생성자 호출

    override var a1 = 1000  //변수 override

    fun subMethod1() {
        println("a1 = $a1")
        println("super.a1 = ${super.a1}")

        superMethod1()  //자기 자신것
        super.superMethod1()    //부모의 것
    }

    override fun superMethod1() {
        println("SubClass의 superMethod1")
    }
}

//보조 생성자들을 통해서 호출도 가능
//생성자는 부모의 생성자를 무조건 호출해야 함
class ThisSuperSubClass2 : ThisSuperSuperclass {

    constructor(a1:Int) : super(a1) {

    }

    constructor(a1:Int, a2:Int) : super(a1) {

    }
}