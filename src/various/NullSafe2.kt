package various

import oopClass.TestClassProperty1

/**
 * Null 타입의 형 변환
 * null 값이 담긴 객체에 대해 보다 안전한 형 변환 방법을 제공
 * null 을 허용하는 변수가 null 값이 들어있지 않다는 것을 보장해 주면 null 을 허용하지 않는 타입으로 스마트 캐스팅이 발생
 */

/**
 * if 문 사용
 * if 문을 통해 null 허용 변수에 null 값이 아닌 객체의 주소 값이 들어 있음을 검사해 주면
 * if 문 내부에서는 null을 허용하지 않는 변수로 변환되어 사용할 수 있음
 * if 문이 종료되면 다시 null 허용 변수가 된다.
 * 이 때 비교 연산자 보다는 is 연산자를 추천
 * 비교 연산자로 검사할 경우 타입이 Any 인 경우 컴파일 오류가 발생
 */
fun main() {
    testMethod1("안녕하세요")
    testMethod1(null)

    println("--------------------------")

    testMethod2("안녕하세요")
    testMethod2(null)

    //추가 내용
    //상속 관계 있을 때
    //is -> 아래의 경우 둘다 true
    //상속 관계일시 접근에 대해 정의하기 때문에 조심해서 사용할 것
    val obj1:ATestClass1 = ATestClass2()

    if(obj1 is ATestClass1){
        obj1.testMethod1()
    }

    if(obj1 is ATestClass2){
        obj1.testMethod2()
    }
}

//null 허용
fun testMethod1(str:String?) {

    println("str.length = ${str?.length}")  //str 을 일시적으로 변환해서 사용함

    if(str is String) {
        //스마트 캐스팅 발생
        println("str.length = ${str.length}")
    }
    //println("str.length = ${str.length}")   //if 문 밖에서는 원래데로 casting

    if(str != null) {
        //이 경우에도 스마트 캐스팅 발생
        println("str.length = ${str.length}")
    }
}

//비교 연산자 보다 is로 검사하는 것을 추천 -> Type Check, Null Check 동시에
fun testMethod2(str:Any?) {

    if(str is String) {
        println("str.length = ${str.length}")
    }

//    if(str != null) {
//        //오류 발생 -> String Type 인지 검사하는 부분이 없기 때문에
//        println("str.length = ${str.length}")
//    }
}

open class ATestClass1 {

    fun testMethod1() {
        println("Test1")
    }
}

open class ATestClass2:ATestClass1() {

    fun testMethod2() {
        println("Test2")
    }
}

