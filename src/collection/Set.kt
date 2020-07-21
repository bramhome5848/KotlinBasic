package collection

/**
 * Set
 * 객체를 이름이나 순서 등으로 관리하는 주체가 없는 컬렉션
 * 중복된 객체를 담을 수 없음
 * 순서에 관계 없고 중복된 객체를 담지 않을 경우 사용
 */
fun main() {

    /**
     * Set 생성
     * setOf : 불변형 set을 생성
     * mutableSetOf : 가변형 set을 생성
     */
    val set1 = setOf<Int>(1,5, 10, 1, 5, 10)
    println("set1 = $set1")

    val set2 = mutableSetOf<Int>()
    println("set2 = $set2")

    println("---------------------------------")

    /**
     * 객체 가져오기
     * set은 관리 주체가 없으므로 객체를 직접 가져오는 메서드는 제공되지 않음
     * for 문을 통해 객체를 순회
     */

    //println("set1.get(0) = ${set1.get(0)}")
    //println("set1[1] = ${set1[1]}")

    for (item in set1) {
        println("item = $item")
    }

    println("set1.size = ${set1.size}")

    println("---------------------------------")

    /**
     * 가변형 set의 메서드
     * add : 관리하는 객체를 추가, 같은 객체일 경우 추가되지 않음
     * remove : 관리하는 객체를 제거
     */

    println("set2 = $set2")

    set2.add(10)
    set2.add(20)
    set2.add(30)
    set2.addAll(listOf(30,40,50))
    println("set2 = $set2")

    set2.add(20)    //중복 데이터 추가 되지 않음
    println("set2 = $set2")

    set2.addAll(listOf(40,50,60,70))
    println("set2 = $set2")

    set2.remove(30)
    println("set2 = $set2")

    println("---------------------------------")

    /**
     * Set 변경
     * toSet : 불변형 set으로 변환
     * toMutableSet : 가변형 set으로 변환
     * toList : 불변형 list로 변환
     * toMutableList : 가변형 list로 변환
     */

    /**
     * List를 Set으로 변경
     * toSet : 불변형 set으로 변경, 이 때 중복된 객체는 제거
     * toMutableSet : 가변형 set으로 변경, 이 때 중복된 객체는 제거
     * list -> set -> list 순서가 보장되지 않음
     */

    //기존 데이터 형 변경X, 데이터를 추출하여 변경된 데이터 구조를 만들어 리턴
    val set3 = set1.toMutableSet()
    set3.add(1000)
    println("set3 = $set3")

    val set4 = set3.toSet()
    //set4.add(2000)

    val list100 = listOf<Int>(10, 20, 30, 10, 20, 30)
    println("list100 = $list100")

    val set5 = list100.toSet()
    val set6 = list100.toMutableSet()

    println("set5 = $set5")
    println("set6 = $set6")

    val set7 = set5.toList()
    val set8 = set5.toMutableList()

    println("set7[0] = ${set7[0]}")
    println("set8[0] = ${set8[0]}")

}