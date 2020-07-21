package collection

/**
 * Collection
 * 자료구조에 나오는 다양한 데이터 관리 기법을 사용할 수 있도록 제공하고 있는 라이브러리
 * List : 순서를 통해 관리
 * Map : 이름을 통해 관리(Key, Value)
 * Set : 집합 관리
 */

/**
 * List
 * 배열과 동일하게 인덱스 번호를 통해 객체를 관리
 * 배열을 크기가 정해지면 변경할 수 없지만 List는 추가, 삭제 등이 가능
 * listOf : 불변형 리스트 생성
 * mutableListOf : 가변형 리스트 생성
 * emptyList : 비어있는 불변형 리스트를 생성
 * listOfNotNull : null을 제외한 나머지만으로 리스트를 생성
 */
fun main() {

    //데이터를 통해 <T>를 추론할 수 있다고 해도 명확히 기술하는 것이 좋음
    //데이터가 초기에 있으면 추론이 가능하지만 초기 빈 리트스의 경우 추론이 불가능

    val list1 = listOf<Int>(10, 20, 30, 40, 50)
    val list2 = listOf<String>("문자열1", "문자열2", "문자열3" )

    println("list1 = $list1")
    println("list2 = $list2")

    val list3 = mutableListOf<Int>()    //추론 불가능
    val list4 = mutableListOf<String>("문자열1", "문자열2", "문자열3" )  //추론 가능

    println("list3 = $list3")
    println("list4 = $list4")

    val list5 = emptyList<Int>()    //텅비어 있는 불변형 리스트
    println("list5 = $list5")

    //null을 제외한 값에 대한 리스트 생성(불변형)
    val list6 = listOfNotNull(10, 20, null, 30, null, 40, 50)
    println("list6 = $list6")

    for (item in list1) {
        println("item = $item")
    }

    println("list1.size = ${list1.size}")

    println("---------------------------------")

    /**
     * 객체 가져오기
     * get : 0부터 시작하는 인덱스 번호를 통해 객체를 추출
     * Kotlin의 리스는 배열과 동일하게 [ ]를 사용 -> kotlin 에서만 가능
     */

    println("list1.get(0) = ${list1.get(0)}")
    println("list1.get(1) = ${list1.get(1)}")
    println("list1[2] = ${list1[2]}")
    println("list1[3] = ${list1[3]}")


    println("---------------------------------")

    /**
     * 기타 메서드
     * indexOf : 지정된 값의 인덱스 번호를 반환 값이 없을 경우 -1을 반환
     * lastIndexOf : 지정된 값의 마지막에 해당하는 값의 인덱스 번호를 반환 값이 없을 경우 -1을 반환한다.
     * subList : 지정된 범위의 값을 추출하여 새로운 리스트를 생성해 반환
     */

    val list7 = listOf<Int>(10, 20, 30, 10, 20, 30)

    val index1 = list7.indexOf(20)  //처음부터 찾음
    println("index1 = $index1")

    val index2 = list7.lastIndexOf(20)  //뒤에서부터 찾음
    println("index2 = $index2")

    val list8 = list7.subList(1, 3)
    println("list8 = $list8")

    println("---------------------------------")

    /**
     * 가변형 리스트의 메서드
     * add(객체) : 객체를 추가
     * add(인덱스, 객체) : 주어진 인덱스 위치에 객체를 삽입
     * remove(객체) : 주어진 객체를 제거
     * removeAt(인덱스) : 주어진 인덱스의 객체를 제거
     * set(인덱스, 객체) : 주어진 인덱스에 객체를 덮어씌움
     */

    println("---------------------------------")

    println("list3 = $list3")
    list3.add(10)
    list3.add(20)
    list3.add(30)

    println("list3 = $list3")

    list3.addAll(listOf(40,50,60))
    println("list3 = $list3")

    list3.add(1, 100)
    println("list3 = $list3")

    list3.addAll(2, listOf(200, 300, 300,400))
    println("list3 = $list3")

    list3.remove(300)   //중복되는 경우 앞에서부터 제거
    println("list3 = $list3")

    list3.removeAll(listOf(200, 300))   //같은 값에 대해 중복 되는 경우도 모두 제거
    println("list3 = $list3")

    list3.removeAt(1)
    println("list3 = $list3")

    list3.set(1, 200)
    println("list3 = $list3")

    list3[2] = 300
    println("list3 = $list3")

    println("---------------------------------")

    /**
     * 리스트 상호 변경
     * toList : 불변형 리스트를 생성해 반환
     * toMutableList : 가변형 리스트를 생성해 반환
     */

    //list1 자체는 변경되는 것이 아님
    val list100 = list1.toMutableList()
    list100.add(1000)
    println("list100 = $list100")

    //list100이 변경되는 것이 아님
    val list200 = list100.toList()
    //list200.add()
}

