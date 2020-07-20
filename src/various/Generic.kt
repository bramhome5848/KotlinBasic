package various

/**
 * 클래스를 설계할 때 변수의 타입을 유동적으로 하고 싶을 때
 * 이 때 Generic 개념을 활용하면 클래스 작성시가 아닌 객체 생성시에 변수의 타입을 설정할 수 있음
 */
fun main() {

    //객체를 만들 때 T type 결정
    val t1 = GenericTestClass1<Int>()
    t1.testMethod1(100)

    val t2 = GenericTestClass1<String>()
    t2.testMethod1("문자열1")

    println("-----------------------------")

    val t3 = GenericTestClass2<Int>(100)
    t3.testMethod2(200)

    val t4 = GenericTestClass2<String>("문자열1")
    t4.testMethod2("문자열2")

    println("-----------------------------")

    val t5 = GenericTestClass3<Int, String>()
    t5.testMethod3(100, "문자열")

    val t6 = GenericTestClass4<Int, Double, String, Boolean>(100, 11.11)
    t6.testMethod4("문자열", true)

    println("-----------------------------")

    /**
     * 불변성
     * 제네릭이 설정된 객체의 주소 값을 같은 타입의 제네릭이 설정된 변수에만 담을 수 있음
     */
    //같은 타입 변수
    val t7:GenericTestClass5<GenericSubClass1> = GenericTestClass5<GenericSubClass1>()
    //자식 타입 변수
    //val t8:GenericTestClass5<GenericSubClass2> = GenericTestClass5<GenericSubClass1>()
    //부모 타입 변수
    //val t9:GenericTestClass5<GenericSuperClass1> = GenericTestClass5<GenericSubClass1>()

    /**
     * 공변성(out)
     * 제네릭이 설정된 객체의 주소 값을 부모 클래스 타입의 제네릭이 설정된 변수에도 담을 수 있음
     */
    //같은 타입
    val t10:GenericTestClass6<GenericSubClass1> = GenericTestClass6<GenericSubClass1>()
    //자식 타입 변수
    //val t11:GenericTestClass6<GenericSubClass2> = GenericTestClass6<GenericSubClass1>()
    //부모 타입 변수 -> 공변성
    val t12:GenericTestClass6<GenericSubClass1> = GenericTestClass6<GenericSubClass1>()

    /**
     * 반공변성(in)
     * 제네릭이 설정된 객체의 주소 값을 자식 클래스 타입의 제네릭이 설정된 변수에도 담을 수 있음
     */
    //같은 타입
    val t13:GenericTestClass7<GenericSubClass1> = GenericTestClass7<GenericSubClass1>()
    //자식 타입 변수 -> 반공변성
    val t14:GenericTestClass7<GenericSubClass2> = GenericTestClass7<GenericSubClass1>()
    //부모 타입 변수 -> 공변성
    //val t15:GenericTestClass7<GenericSuperClass1> = GenericTestClass7<GenericSubClass1>()

    /**
     * in, out은 하나만 설정 가능
     * in은 위험성 때문에 잘 사용하지 않음
     */
}

//클래스를 만들 때 자료형을 결정하지 않은 것
class GenericTestClass1<T> {

    fun testMethod1(a1:T) {
        println("a1 = $a1")
    }
}

class GenericTestClass2<T>(var a1:T) {

    fun testMethod2(a2:T) {
        println("a1 = $a1")
        println("a2 = $a2")
    }
}

class GenericTestClass3<A,B> {

    fun testMethod3(a1:A, a2:B) {
        println("a1 = $a1")
        println("a2 = $a2")
    }
}

class GenericTestClass4<A,B,C,D>(var a1:A, var a2:B) {

    fun testMethod4(a3:C, a4:D) {
        println("a1 = $a1")
        println("a2 = $a2")
        println("a3 = $a3")
        println("a4 = $a4")
    }

}

open class GenericSuperClass1

open class GenericSubClass1 : GenericSuperClass1()

class GenericSubClass2 : GenericSubClass1()

//불변성
class GenericTestClass5<A>()

//공변성
class GenericTestClass6<out A>()

//반공변성
//자식형 변수에 부모형을 담게 되면 접근에 대한 위험
class GenericTestClass7<in A>()