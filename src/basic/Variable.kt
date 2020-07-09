package basic

fun main() {

    //정수 리터럴
    println(100)
    println(10000000000000)    //정수 범위 넘어가는 경우 자동 자바 파일로 변경될 때 L을 붙여줌
    println(10000000000000L)   //L을 명시해도 관계 없음
    println(1000_000_000)      //_는 빠지고 실행 -> 긴 숫자 입력시 유용

    //실수 리터럴
    println(11.11)  // double type 으로 출력(8byte)
    println(22.22f) // float type 명시(4byte)

    //문자 리터럴
    println('A')     //char
    println('가')
    println("문자열") //String

    //논리 리터럴
    println(true)
    println(false)

    //Raw String -> 여러 줄 문자열에서 사용
    //Decomplie 내역 확인해보면 똑같이 변경되어 있음
    println("동해물과 백두산이\n마르고 닳도록\n하느님이 보우하사\n우리나라 만세!!")

    println("""동해물과 백두산이
        |마르고 닳도록
        |하느님이 보우하사
        |우리나라 만세
    """.trimMargin())   //공백제거

    println("-------------------------------------------")

    //Kotlin 의 자료형 -> 모든 기본 자료형을 객체로 만들어서 객체로 관리
    //자바에는 없는 부호가 없는 정수형 표현 ex) UInt 가 있음 0 ~ +

    //Kotlin 변수 선언시 val, var 두가지 키워드 사용
    //var 선언 이후 값을 다시 저장 가능
    //val 선언 이후 값을 다시 저장 불가능 -> readOnly
    //var/val 변수명:타입 = 값 -> 타입 생략 시 저장하는 값에 따라 자료형 자동 결정
    //Kotlin 에서는 자료형을 생략하는 것을 추천함 *****, 반드시 명시해야 하는 경우도 있음 *****

    val a1:Int = 100
    //println("a1 = ${a1}")   //중괄호 안에 변수만 들어 가 있는 경우 중괄호 생갹가능
    println("a1 = $a1")

    val a2 = 100
    println("a2 = $a2")

    println("-------------------------------------------")

    var a3:Int = 100
    val a4:Int = 100

    println("a3 = $a3")
    println("a4 = $a4")

    a3 = 200
    println("a3 = $a3")

    //val 변수는 값을 다시 저장하지 못함
    //a4 = 200

    println("-------------------------------------------")

    //Kotlin 은 변수를 선언할 때 null 허용 여부를 설정
    // var/val 변수명:자료형 -> null 허용하지 않는 변수
    // var/val 변수명:자료형? -> null 허용하는 변수

    //var a5:Int = null //오류
    var a5:Int = 100
    var a6:Int? = null

    println("a5 = $a5")
    println("a6 = $a6")

    var a7:Int? = a5    //null 허용하지 않는 변수의 값을, null 허용 변수에 저장하는 것 가능
    println("a7 = $a7")

    //var a8:Int = a6    //null 허용하지 않는 변수에 null 을 입력할 수 없음
    //var a8:Int = a6!!   //!! 이용시 입력은 가능하나 NullPointException 발생
    //println("a8 = $a8")

}

/**
 * Kotlin 은 모든 기본 타입 값을 객체로 만들어서 관리
 * Kotlin 은 null 허용하는 변수와 허용하지 않는 변수를 제공
 */