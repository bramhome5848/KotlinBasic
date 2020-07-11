package oopClass

/**
 * 상속을 하는 클래스를 부모 클래스(SuperClass)
 * 상속을 받는 클래스를 자식 클래스(SubClass)
 * 부모 클래스는 open 키워드를 사용
 * open 키워드를 사용하지 않으면 자바 코드로 변경될 때 final 키워드가 붙음
 */
fun main() {
    
    val s1:SubClass1 = SubClass1()
    println("s1.subMember1 = ${s1.subMember1}")
    s1.subMember1()

    println("s1.superMember1 = ${s1.superMember1}")
    s1.superMethod1()
}

open class SuperClass1 {    //별도의 생성자가 없는 경우 매개 변수가 없는 생성자 자동 추가
    var superMember1:Int = 100

    fun superMethod1(){
        println("SuperClass1의 메서드 입니다")
    }
}

class SubClass1 : SuperClass1() { //반드시 부모 클래스의 생성자를 호출해야함

    //constructor() : super()   //SuperClass() 에서 ()이 빠지면 선언해야함
    val subMember1:Int = 200
    
    fun subMember1() {
        println("SubClass1의 메서드 입니다")
    }
}

open class SuperClass2(val a2:Int)  //기본 생성자와 멤버 변수 추가

class SubClass2 : SuperClass2(100)

class SubClass3 : SuperClass2 {

    constructor() : super(100)
}