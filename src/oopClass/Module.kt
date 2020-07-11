package oopClass

import pkg1.TestClass1
import pkg1.TestClass2
import pkg2.TestClass3
import pkg2.TestClass4

/**
 * kt 파일들을 모아 관리하는 개념이 패키지라면
 * 모듈을 패키지를 모아 관리하는 개념
 * 패키지가 많아지면 관리하기가 어려워질 수 있는데 이 때 모듈로 묶어서 사용
 * 다른 모듈 사용시 모듈 등록
 * project structure project dependencies add
 */
fun main() {

    val obj1 = TestClass1()
    val obj2 = TestClass2()
    val obj3 = TestClass3()
    val obj4 = TestClass4()

    obj1.testMethod1()
    obj2.testMethod2()
    obj3.testMethod3()
    obj4.testMethod4()
}