package oopClass

/**
 * 지연 초기화
 * Kotlin은 변수를 선언할 때 값을 무조건 설정해야 하는데 이를 지연 시키는 것을 지연 초기화
 */
fun main() {
    val obj1 = TestUntitledClass1()
    println("obj1.a1 = ${obj1.a1}")
    println("obj1.a2 = ${obj1.a2}")

    obj1.testMethod1()
    println("obj1.a3 = ${obj1.a3}") //초기화 되지 않아 UninitializedPropertyAccessException 발생

    println("obj1.a4 = ${obj1.a4}")

}

class  TestUntitledClass1 {
    var a1:Int = 100
    var a2:Int  //초기화를 하지 않고 선언시에는 데이터에 의한 타입 추론을 할 수 없기 때문에 타입을 반드시 명시

    /**
     * lateinit
     * var 로 선언된 변수의 초기화를 뒤로 미룰 수 있음 -> 초기화를 하지 않고 사용할 수 있다는 의미가 아님
     * 변수의 값을 사용하기 전에 반드시 초기화가 이루어져야 함
     * val 로 선언된 변수는 오류가 발생 -> setter method 가 없기 때문에 변수 값을 세팅할 수 없음
     * 기본 자료형의 경우 lateinit 을 지원하지 않음
     */

    //lateinit var a3:Int //modifier is not allowed on properties of primitive types
    lateinit var a3:String

    /**
     * lazy
     * val로 선언된 변수는 lateinit으로 지연 초기화 하는 것이 불가능
     * val로 선언된 변수는 lazy 코드 블록을 이용하면 되는데
     * 이는 나중에 프로퍼티의 값을 셋팅해준다는 의미가 아닌 사용할 때 값을 초기화 한다는 의미
     * 변수를 선언할 때 데이터가 들어가는 것이 아니라 사용할 때 들어가서 초기화 됨
     * 만약 변수를 한 번도 사용하지 않으면 a4 안에 들어갈 객체가 생성되지 않기 때문에 메모리를 절약 가능
     */
    val a4:String by lazy {
        println("a4 init")
        "문자열2"
    }

    init {  //객체를 만들 때 무조건 실행되기 때문에 가능
        a2 = 200
    }

    fun testMethod1() {
        // :: -> reflection -> 객체를 사용할 때 객체와 관련된 클래스의 정보를 파악하기 위해 사용
        if(::a3.isInitialized == false) {   //초기화가 되지 않았으면 false
            a3 = "문자열"
            println("a3 = $a3")
        }
    }

    /**
     * 정리
     * 프로퍼티의 값을 나중에 셋팅할 때 지연 초기화 사용 가능
     * var 변수는 lateinit 사용
     * val 변수는 lazy 코드 블록 사용
     */
}