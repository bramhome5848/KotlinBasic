package oopClass

import oopClass.pkg1.TestClass2
import oopClass.pkg1.testFunction2
import oopClass.pkg2.*
import oopClass.pkg2.TestClass3
import oopClass.pkg2.TestClass4

fun main() {

    //패키지 내에 있는 클래스 등을 사용할 때는 반드시 패키명을 명시
    val obj1:oopClass.pkg1.TestClass1 = oopClass.pkg1.TestClass1()
    obj1.testMethod1()

    oopClass.pkg1.testFunction1()   //함수만 따로 실행

    //import 사용해 패키지를 명시하면 코드 내에서 패키지 명 생략 가능
    val obj2:TestClass2 = TestClass2()
    obj2.testMethod2()

    testFunction2()

    val obj3:TestClass3 = TestClass3()
    val obj4:TestClass4 = TestClass4()

    obj3.testMethod3()
    obj4.testMethod4()
}