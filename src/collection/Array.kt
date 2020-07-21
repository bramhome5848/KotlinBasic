package collection

/**
 * 배
 * 연속된 기억공간을 확보하여 값 들을 저장하고 관리하는 자료 구조
 * Kotlin에서는 다양한 타입의 값을 배열에 담을 수 있으며 한 가지 타입으로 제한하여 값을 담을 수도 있음
 * arrayOf 는 다양한 값을 담을 수 있음
 * 담을 값의 자료형을 제한하고 싶다면 자료형 + arrayOf 형태의 함수를 사용
 * arrayOf<제네릭타입>도 가능
 */
fun main() {

    val array1 = arrayOf(10,20,30,40,50)
    println("array1 = $array1")
    println("array1.contentToString() = ${array1.contentToString()}")

    //다양한 타입도 가능하나 권장하지 않음
    val array2 = arrayOf(100,11.11,"문자열", true)
    println("array2.contentToString() = ${array2.contentToString()}")

    //기본 자료형만 자료형+arrayOf 제공
    val array3 = intArrayOf(10,20,30,40,50)
    val array4 = doubleArrayOf(11.11, 22.22, 33.33, 44.44, 55.55)
    val array5 = arrayOf<String>("문자열1", "문자열2", "문자열3")

    println("array3.contentToString() = ${array3.contentToString()}")
    println("array4.contentToString() = ${array4.contentToString()}")
    println("array5.contentToString() = ${array5.contentToString()}")

    /**
     * 배열 생성하기 -> Array 클래스를 통한 직접 생성
     */
    //두번째 파라미터 람다식 -> index 번호가 default
    val array6 = Array(5) {0}
    println("array6.contentToString() = ${array6.contentToString()}")

    val array7 = Array(5) {it*2}  //마지막 함수 인자를 받는 값이면 밖으로 뺄 수 있음
    println("array7.contentToString() = ${array7.contentToString()}")

    for (item in array1) {
        println("array1 = $item")
    }

    println("---------------------------------")

    /**
     * 다차원 배열 - 배열 안에 배열
     */
    val array8 = arrayOf(arrayOf(10,20,30), arrayOf(40,50,60), arrayOf(70,80,90))
    println("array8 = $array8")
    println("array8.contentToString() = ${array8.contentToString()}")
    println("array8.contentDeepToString() = ${array8.contentDeepToString()}")   //다차원 정보

    for (item1 in array8) {
        for (item2 in item1) {
            println("item2 = $item2")
        }
    }

    println("---------------------------------")

    /**
     * 배열 요소 접근
     */

    println("array1[0] = ${array1[0]}")
    println("array1[1] = ${array1[1]}")
    println("array1.get(2) = ${array1.get(2)}")
    println("array1.get(3) = ${array1.get(3)}")

    println("---------------------------------")

    /**
     * 배열 요소 다른값 저장
     */
    println("array1.contentToString() = ${array1.contentToString()}")
    array1[0] = 100
    array1.set(1, 200)
    println("array1.contentToString() = ${array1.contentToString()}")

    println("---------------------------------")

    /**
     * 배열 요소 개수
     */
    println("array1.size = ${array1.size}")

    println("---------------------------------")

    /**
     * 제공 되는 메서드들
     * - plus : 요소를 추가한 새로운 배열을 만들어 반환
     * - sliceArray : 지정된 범위의 요소를 관리하는 배열을 만들어 반환
     * - first : 제일 앞의 값을 반환
     * - last : 제일 마지막 값을 반환
     * - indexOf : 지정된 값의 index 를 반환
     * - average : 평균 값을 반환
     * - count : 요소의 개수를 반환한다.
     * - contains : 지정된 값이 포함되어 있는지 반환
     * - sortedArray : 오름 차순 정렬된 배열을 반환
     * - sortedArrayDescending : 내림 차순 정렬된 배열을 반환
     */

    println("array1.contentToString() = ${array1.contentToString()}")

    //기존 객체에 새로운 배열을 만들어 새로운 객체로 반환 -> 기존 객체 변수에 담아주지는 않음
    //배열은 기존에 선언한 사이즈를 늘리지는 않고 원본은 유지하고 작업을 적용한 새로운 배열을 반환
    val array10 = array1.plus(60)
    println("array10.contentToString() = ${array10.contentToString()}")

    //원본 유치하고 작업을 적용한 새로운 배열 반환
    val array11 = array1.sliceArray(1..3)
    println("array11.contentToString() = ${array11.contentToString()}")

    //배열의 첫번째 값
    println("array1.first() = ${array1.first()}")

    //배열의 마지막 값
    println("array1.last() = ${array1.last()}")

    //30의 위치 -> 특정 값의 index
    println("array1.indexOf(30) = ${array1.indexOf(30)}")

    //평균
    println("array1.average() = ${array1.average()}")

    //합
    println("array1.sum() = ${array1.sum()}")

    //개수 -> 둘의 차이가 있는데 뒤의 강의에서 확인
    println("array1.count() = ${array1.count()}")
    println("array1.size = ${array1.size}")

    //30을 포함하는가
    println("array1.contains(30) = ${array1.contains(30)}")
    println("30 in array1 = ${30 in array1}")

    //1000을 포함하는가
    println("array1.contains(1000) = ${array1.contains(1000)}")
    println("1000 in array1 = ${1000 in array1}")

    //최대
    println("array1.max() = ${array1.max()}")

    //최소
    println("array1.min() = ${array1.min()}")

    println("---------------------------------")

    /**
     * Array 정렬
     */

    val array12 = arrayOf(5, 1, 3, 7, 10, 8)

    //원본 유치하고 작업을 적용한 새로운 배열 반환
    val array13 = array12.sortedArray() //오름차순
    val array14 = array13.sortedArrayDescending()   //내림차순

    println("array13.contentToString() = ${array13.contentToString()}")
    println("array14.contentToString() = ${array14.contentToString()}")
}