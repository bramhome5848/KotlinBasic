package oopClass

/**
 * 클래스를 통해 객체를 생성할 때 자동으로 수행될 코드를 작성하는 곳
 * 메서드와 비슷해 보이지만 반환 타입이 없어 메서드라고 부르지 않음
 * 생성자의 역할은 클래스가 가지고 있는 변수의 값을 초기화 하는데 주로 이용
 */
fun main() {

    val obj1 = TestClass4()
    println("obj1 = $obj1")

    println("-------------------------------------------")

    val obj2 = TestClass5()
    println("obj2 = $obj2")
    println("obj2.v1 = ${obj2.v1}")
    println("obj2.v2 = ${obj2.v2}")

    println("-------------------------------------------")

    val obj3 = TestClass5(100,200)
    println("obj3 = $obj3")
    println("obj3.v1 = ${obj3.v1}")
    println("obj3.v2 = ${obj3.v2}")

    println("-------------------------------------------")

    val obj4 = TestClass6(100, 200)
    val obj5 = TestClass7(1000, 2000)

    println("obj4.a1 = ${obj4.a1}")
    println("obj4.a2 = ${obj4.a2}")

    println("obj5.a1 = ${obj5.a1}")
    println("obj5.a2 = ${obj5.a2}")

    println("-------------------------------------------")
    //객체를 생성하면 주 생성자 먼저 동작하고, init 블록 수행
    val obj6 = TestClass8(100, 200)
    println("obj6.a1 = ${obj6.a1}")
    println("obj6.a2 = ${obj6.a2}")

    println("-------------------------------------------")
    //주 생성자가 있는 경우 보조 생성자는 무조건 주 생성자를 먼저 호출해야함
    //파라미터 1개로 보조 생성자를 호출 하지만
    //보조 생성자는 내부 코드 실행 전에 주 생성자를 호출하게 되고
    //주 생성자 실행 -> init -> 보조 생성자
    val obj7 = TestClass8(100)
}

/**
 * Kotlin 은 클래스에 init 코드 블록을 만들어 주면 객체 생성시 자동으로 처리되는 코드를 만들 수 있음
 */
class TestClass4{
    init {
        println("객체가 생성되면 자동으로 동작")
    }
}

/**
 * Constructor 를 이용하여 생성자 정의 가능
 */
class TestClass5 {
    var v1:Int = 0
    var v2:Int = 0

    //보조 생성자
    constructor(){
        println("매개 변수가 없는 생성자")
    }

    constructor(a1:Int, a2:Int) {
        println("매개 변수가 있는 생성자")
        this.v1 = a1
        this.v2 = a2
    }
}

/**
 * 기본 생성자
 * 클래스를 정의할 때 클래스 이름 우측에 정의하는 생성자
 * 기본 생성자의 매개 변수는 멤버 변수로 자동 등록
 */
class TestClass6 (var a1:Int, val a2:Int)   //주생성자
class TestClass7 constructor(var a1:Int, var a2:Int)

class TestClass8(var a1:Int, val a2:Int) {

    init {
        println("init 코드 수행")
        println("a1 = $a1")
        println("a2 = $a2")
    }

    constructor(a1:Int) : this(a1, 100){
        println("보조 생성자 호출")
    }
}