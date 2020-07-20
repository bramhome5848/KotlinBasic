package various

import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.primaryConstructor

/**
 * Reflection
 * 프로그램 실행 중에 프로그램의 구조(객체, 함수, 프로퍼티)를 분석하는 기법
 * 객체의 클래스 타입, 클래스 정보, 생성자 정보, 프로퍼티 정보 등을 실행 중에 파악할 수 있음
 */
fun main() {

    //Kotlin 클래스 타입 -> KClass type 사용
    val a1:KClass<String> = String::class

    //Java로 변환된 클래스 타입 -> Class Type 사용
    val a2:Class<String> = String::class.java

    println("String Kotlin 에서의 타입 : $a1")
    println("String Java 에서의 타입 : $a2")

    println("--------------------------")

    //변수에 담겨 있는 객체를 사용할 경우 -> out 선언
    //부모 클래스 타입으로 변경할 수 있는 out 사용
    val str1:String = "안녕하세요"
    val a3:KClass<out String> = str1::class
    val a4:Class<out String> = str1::class.java
    println("안녕하세요 Kotlin 에서의 타입 : $a3" )
    println("안녕하세요 Java 에서의 타입 : $a4" )

    println("--------------------------")

    //타입을 모르는 경우 -> 모든 타입을 다 담을 수 있음(이 방법을 더 많이 사용)
    val a5:KClass<*> = str1::class
    val a6:Class<*> = str1::class.java

    println("안녕하세요 Kotlin 에서의 타입 : $a5")
    println("안녕하세요 Java 에서의 타입 : $a6")

    println("--------------------------")

    val test1:ReflectionTestClass = ReflectionTestClass()
    val a7:KClass<*> = test1::class
    val a8:Class<*> = test1::class.java

    println("test1 Kotlin 에서의 타입 : $a7")
    println("test1 Java 에서의 타입 : $a8")

    println("--------------------------")

    //클래스 정보 분석
    println("추상 클래스 인가 : ${test1::class.isAbstract}")
    println("Companion 클래스 인가 : ${test1::class.isCompanion}")
    println("Data 클래스 인가 : ${test1::class.isData}")
    println("Final 클래스 인가 : ${test1::class.isFinal}")
    println("Open 클래스 인가 : ${test1::class.isOpen}")
    println("중첩 클래스 인가 : ${test1::class.isInner}")
    println("Sealed 클래스 인가 : ${test1::class.isSealed}")

    println("--------------------------")

    //생성자 정보 분석 -> 여러개인 경우 배열로 넘어오게 됨
    val constructors = test1::class.constructors

    for (con in constructors) {
        println("constructor = $con")

        //parameter 정보
        for(param in con.parameters) {
            println("parameter index = ${param.index}")
            println("parameter type = ${param.type}")
            println("parameter name = ${param.name}")
        }
    }

    println("--------------------------")

    //주 생성자 정보 분석
    val primaryCon = test1::class.primaryConstructor
    if(primaryCon != null){
        println(primaryCon)

        for(param in primaryCon.parameters){
            println("parameter index = ${param.index}")
            println("parameter type = ${param.type}")
            println("parameter name = ${param.name}")
        }
    }

    println("--------------------------")

    //프로퍼티
    val properties = test1::class.declaredMemberProperties
    for(prop in properties) {
        println(prop.name)
    }

    println("--------------------------")

    //메서드 정보
    val methods = test1::class.declaredMemberFunctions
    for(met in methods) {
        println(met.name)
    }

}

class ReflectionTestClass() {

    val number1:Int = 100
    var number2:Int = 200

    constructor(a1:Int) : this() {

    }

    constructor(a1:Int, a2:Int) : this() {

    }

    fun testMethod1() {

    }
}

