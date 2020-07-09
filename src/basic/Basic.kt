package basic

fun main() {
    //Decomplie 된 자바 코드와 비교해볼 것
    // 한 줄 주석

    /*
      여러줄 주석
     */

    //print -> System.out.print
    //println -> System.out.println
    print("문자열 입니다")
    println("문자열 입니다")

    //값을 출력할 때
    println("값 : " + (1+2+3))
    println("값 : ${1+2+3}") //값을 같이 출력할 때는 ${값}을 사용
}

/**
 * Kotlin 의 주석은 자바의 주석과 동일
 * print, println 출력을 제공
 * 세미콜론은 선택사항이다, 한 줄에 여러 명령어을 입력할 경우는 필요
 */
