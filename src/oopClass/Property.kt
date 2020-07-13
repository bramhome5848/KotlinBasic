package oopClass

/**
 * 캡슐화
 * - 변수의 직접적인 접근을 차단하여 외부에서 값을 변경하지 못하도록 막는 것
 * Property
 * - 캡슐화가 적용된 변수에 대해 메서드를 통해 값을 설정하거나 가져다 사용할 수 있도록 구성한 것
 * - 주 생성자의 매개 변수를 정의할 때 var, val 를 지정하면 Property 로 작성됨
 * . 을 통해 코드에 직접 접근하는 것처럼 보이지만 실제로는 setter, getter 를 호출해서 실행됨
 */
fun main() {

    val obj1 = TestClassProperty1(100,200)
    println("obj1.a1 = ${obj1.a1}") //getter, setter 둘 다는 _ 로 표현
    println("obj1.a2 = ${obj1.a2}")

    obj1.a1 = 1000
    println("obj1.a1 = ${obj1.a1}")

    println("---------------------------------")

    val obj2 = TestClassProperty2()
    obj2.v1 = 100
    //obj2.v2 = 200 //val이기 때문에 setter 없음
    println("obj2.v1 = ${obj2.v1}")
    println("obj2.v2 = ${obj2.v2}")

    obj2.v3 = 5000
    println("obj2.v3 = ${obj2.v3}")
}

class TestClassProperty1(var a1:Int, val a2:Int) {

    //보조 생성자 -> var val 키워드는 주 생성자에만 가능, 보조 생성자는 불가능
    //주 생성자에 var, val 키워드 입력시 멤버 변수로 생성됨
    //constructor(var a1:Int, val a2:Int, var a3:Int) : this(a1, a2){}
}

//자동 생성되는 set(), get() 을 직접 작성하는 방법
class TestClassProperty2 {
    var v1:Int = 0
        get() {
            println("v1의 get 호출")
            return field    //v1
        }
    val v2:Int = 0  //val은 setter 불가능
        get() {
            println("v12 get 호출")
            return field    //v2
        }

    var v3:Int = 100

        get() {
            println("v2의 get 호출")
            return field    //v3
        }
        set(value) {
            println("v2의 set 호출")
            field = value
        }
}
