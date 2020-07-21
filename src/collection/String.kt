package collection

/**
 * 문자열
 * " " 로 묶어서 관리하는 문자열을 의미
 * Kotlin은 문자열을 Java에 동일하게 String 클래스의 객체를 생성해서 관리
 * Java와 거의 동일하게 제공되며 몇가지 메서드를 추가
 */
fun main() {

    /**
     * 문자열의 인덱스
     * Kotlin은 문자열을 배열 형태로 관리
     * 문자열의 글자를 0부터 시작하는 인덱스 번호로 관리할 수 있어 Java 보다 편리하게 사용할 수 있음
     * 문자열은 불변형으로 가져다 사용하는 것만 가능
     */

    val str1 = "안녕하세요"
    println("str1[0] = ${str1[0]}")
    println("str1[1] = ${str1[1]}")

    //var이라도 불가능 -> 불변 객체이기 때문에
    //str1[0] = 'A'

    println("---------------------------------")

    /**
     * 제공 메서드
     * substring : 지정된 범위의 문자열을 반환한다.
     * compareTo : 문자열을 비교, 같으면 0이며 음수나 양수면 다른 문자열. 두 번째 값으로 true를 넣어주면 대소문자를 무시하고 비교
     * split : 문자열을 지정된 구분자를 이용해 잘라냄
     */

    val str2 = str1.substring(1..3) //index 1~3
    println("str2 = $str2")

    val str3 = "Hello World"
    val str4 = "hello world"

    println("str3.compareTo(str4) = ${str3.compareTo(str4)}")   //compareTo
    println("str3.compareTo(str4, true) = ${str3.compareTo(str4, true)}")   //compareToIgnoreCase
    println("str3.contentEquals(str4) = ${str3.contentEquals(str4)}")

    val str5 = "ab cd ef gh"
    val r1 = str5.split(" ")
    println("r1 = $r1")

    println("---------------------------------")

    /**
     * StringBuffer
     * 문자열은 불변형이므로 + 연산자를 통해 문자열을 합치면 문자열 객체가 계속 생성
     * StringBuffer를 사용하면 관리하는 문자열을 직접 조작
     * String은 지속적인 문자열 연산을 수행하면 메모리를 많이 사용하지만 원본이 유지
     * StringBuffer는 메모리를 절약할 수 있지만 원본을 유지할 수 없음
     */

    val str6 = "abc"
    val str7 = str6 + "def"

    println("str6 = $str6")
    println("str7 = $str7")

    //StringBuffer 가변 객체
    //Java 와 마찬가지로 synchronized

    val buffer1 = StringBuffer()
    buffer1.append("abc")
    buffer1.append(100)
    buffer1.append(11.11)
    println("buffer1 = $buffer1")

    buffer1.insert(3, "테스트")
    println("buffer1 = $buffer1")

    buffer1.delete(3, 6)
    println("buffer1 = $buffer1")
}