package various

/**
 * Companion
 * 클래스를 정의할 때 변수나 메서드를 정적 멤버로 정의하면 객체를 생성하지 않고 사용
 * Java 에서는 static 을 사용하는데 Kotlin 은 companion 객체를 사용
 */
fun main() {

    val obj1 = CompanionTestClass1()
    println("obj1.a1 = ${obj1.a1}")
    obj1.testFun1()

    val obj2 = CompanionTestClass1()
    println("obj1.a1 = ${obj1.a1}")
    obj2.testFun1()

    obj2.a1 = 200
    println("obj1.a1 = ${obj1.a1}")
    println("obj2.a1 = ${obj2.a1}")

    //Companion 객체로 생성된 경우 객체를 만들어 참초하는 것이 금지됨
    //자바의 경우에는 생성된 객체로 static member 에 접근하는 것도 가능함
    //Kotlin 에서는 엄격히 구분됨
    //println("obj1.a2 = ${obj1.a2}")
    //obj1.testFun2()

    println("CompanionTestClass1.a2 = ${CompanionTestClass1.a2}")
    CompanionTestClass1.testFun2()

    println("------------------------------")

    /**
     * Kotlin 과 Java 사이에서 사용하기
     * Kotlin 에서 Java 의 static 멤버 사용은 다른 점이 없음
     * 만약 Kotlin 에서 정의한 Companion 멤버 중 Java 에서 사용할 수 있도록
     * 하기 위해서는 .Companion 이용하여 접근, 그렇지 않다면 @JavaStatic 으로 정의
     */

    val obj3 = JavaMain()
    println("obj3.javaA1 = ${obj3.javaA1}")
    obj3.javaMethod1()

    //java의 static 멤버들에 대한 접근 가능
    println("JavaMain.javaA2 = ${JavaMain.javaA2}")
    JavaMain.javaMethod2()
}

class CompanionTestClass1 {

    var a1 = 100

    companion object {  //정적 멤버

        var a2 = 1000
        @JvmStatic var a3 = 2000

        fun testFun2() {
            println("testFun2")

            //오류 발생
            //companion object에서 외부로 접근이 불가능
            //객체를 생성하여 접근할 수 있는 영역과 없는 영역 구분
            //companion 이외의 멤버에 접근할 수 있는 객체가
            // 생성된 시점을 알 수가 없는 점도 이유가 될 수 있음
            //println("a1: $a1")

            println("a2: $a2")
        }

        @JvmStatic fun testFun3() {
            println("testFun3")
        }
    }

    fun testFun1() {
        println("testFun1")
        println("a1 = $a1")

        //객체를 생성해야 접근할 수 있는 영역에서
        //그렇지 않은 영역에 대한 접근은 가능
        //메모리 상에 먼저 생성되어 있기 때문에 -> static
        println("a2 = $a2")
        testFun2()
    }
}
