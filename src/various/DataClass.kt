package various

/**
 * Data Class
 * DataClass 는 매개체의 데이터를 관리하는 용도로 사용하는 클래스
 * abstract, open, sealed, inner 클래스로 정의할 수 없음
 * 반드시 주 생성자를 가지고 있어야 함
 * Data Class 는 개발자의 개발 편리성을 위해 몇 가지 메서드가 자동으로 구현
 * - equals : 객체가 가지고 있는 변수를 모두 비교하는 메서드
 * - hashCode : 객체를 구분하기 위한 고유한 정수값
 * - copy : 객체를 복제하는 메서드
 * - toString : 객체가 가지고 있는 변수의 값을 출력
 * - componentN : 객체 분해
 */
fun main() {
    val obj1 = DataClassTestClass1(100,200)
    val obj2 = DataClassTestClass2(100, 200)

    println("obj1.a1 = ${obj1.a1}")
    println("obj1.a2 = ${obj1.a2}")

    println("obj2.a1 = ${obj2.a1}")
    println("obj2.a2 = ${obj2.a2}")

    println("------------------------------------")

    val obj3 = DataClassTestClass1(100,200,300)
    val obj4 = DataClassTestClass2(100,200,300)

    println("obj3.a1 = ${obj3.a1}")
    println("obj3.a2 = ${obj3.a2}")
    println("obj3.a3 = ${obj3.a3}")

    println("obj4.a1 = ${obj4.a1}")
    println("obj4.a2 = ${obj4.a2}")
    println("obj4.a3 = ${obj4.a3}")

    obj3.testMethod1()
    obj4.testMethod2()

    println("------------------------------------")

    val obj5 = DataClassTestClass1(100,200,300)
    val obj6 = DataClassTestClass1(100,200,300)

    //다른 객체가 됨 -> 주소값을 비교하기 때문, == 이지만 kotlin은 관련된 메서드를 호출
    //TestClass1 에는 equals 메서드가 없기 때문에 any 의 equals 실행하지만
    //any의 equals 는 주소값을 비교하는 함수로 구성
    if(obj5 == obj6){
        println("obj5과 obj6은 같은 객체입니다")
    } else {
        println("obj5과 obj6은 다른 객체입니다")
    }

    val obj7 = DataClassTestClass2(100, 200, 300)
    val obj8 = DataClassTestClass2(100, 200, 300)

    //실제로는 다른 객체가 됨 -> 주소값을 비교하기 때문, ==이지만 kotlin은 관련된 메서드를 호출
    //TestClass2의 경우 equals 메서드를 오버라이드 하여 생성하기 때문에 두 객체가 가지고 있는 데이터 값을
    //비교하여 결과를 알려주게 됨 -> 주 생성자에서 정의한 데이터들끼리만 비교하게 됨
    if(obj7 == obj8){
       println("obj7과 obj8은 같은 객체입니다")
    } else {
        println("obj7과 obj8은 다른 객체입니다")
    }

    println("------------------------------------")
    //val obj9 = obj5.copy()  //일반 class는 copy override 되어 있지 않음
    val obj10 = obj7.copy()
    println("obj10.a1 = ${obj10.a1}")
    println("obj10.a2 = ${obj10.a2}")
    println("obj10.a3 = ${obj10.a3}")   //주 생성자에 포함되지 않은 경우 복제 대상에 포함되지 않음

    obj10.a1 = 1000
    println("obj7.a1 = ${obj7.a1}")
    println("obj10.a1 = ${obj10.a1}")

    println("------------------------------------")

    val str1 = obj5.toString()  //일반 클래스는 any 의 toString 사용
    val str2 = obj7.toString()  //any 의 toString 을 override 해서 사용
    println("str1 = $str1")
    println("str2 = $str2")     //주 생성자에 정의한 값에 대해서만 출력됨

    println("------------------------------------")

    val num1 = obj7.component1()    //component -> 이것 또한 주 생성자에 정의한 것들에 대해 접근 가능, 1번째 매개변수
    val num2 = obj7.component2()
    println("num1 = $num1")
    println("num2 = $num2")

    val obj11 = DataClassTestClass3(100,200,300)
    val num3 = obj11.component1()
    val num4 = obj11.component2()
    val num5 = obj11.component3()

    println("num3 = $num3")
    println("num4 = $num4")
    println("num5 = $num5")

    println("------------------------------------")
    val (num10, num11) =  obj7  //객체분해 -> 각자의 component를 호출하여 변수에 값을 담음
    println("num10 = $num10")
    println("num11 = $num11")

    val(num12, num13, num14) = obj11
    println("num12 = $num12")
    println("num13 = $num13")
    println("num14 = $num14")
}

//일반 클래스
class DataClassTestClass1(var a1:Int, var a2:Int) {

    var a3:Int = 0

    init {
        println("TestClass1의 init")
    }

    //보조 생성자
    constructor(a1:Int, a2:Int, a3:Int) : this(a1, a2) {
        this.a3 = a3
    }

    fun testMethod1() {
        println("TestClass1의 testMethod1입니다")
    }
}

//멤버 변수 하나 이상은 반드시 포함해야 함
data class DataClassTestClass2(var a1:Int, var a2:Int) {

    var a3:Int = 0

    init {
        println("TestClass2의 init")
    }

    //보조 생성자
    constructor(a1:Int, a2:Int, a3:Int) : this(a1, a2) {
        this.a3 = a3
    }

    fun testMethod2() {
        println("TestClass2의 testMethod2입니다")
    }
}

data class DataClassTestClass3(var a1:Int, var a2:Int, var a3:Int)

/**
 * Data를 담을 변수만 가지고 있는 클래스를 Data Class라고 부름
 */