package collection

/**
 * Map
 * 객체를 이름을 통해 관리하는 컬렉션
 * mapOf : 불변형 Map을 생성
 * mutableMapOf : 가변형 Map을 생성
 */
fun main() {

    //List와 마찬가지로 데이터를 통해 <T>를 추론할 수 있다고 해도 명확히 기술하는 것이 좋음
    //데이터가 초기에 있으면 추론이 가능하지만 초기 빈 리트스의 경우 추론이 불가능
    //(key to value)

    val map1 = mapOf<String, Int>("key1" to 10, "key2" to 20, "key3" to 30)
    println("map1 = $map1")

    val map2 = mutableMapOf<String, Int>()
    println("map2 = $map2")

    //value 에 담을 값이 다양한 경우 any 타입
    val map3 = mapOf<String, Any>("key1" to 10, "key2" to 11.11, "key3" to true)
    println("map3 = $map3")

    println("---------------------------------")

    /**
     * 객체 가져오기
     * get : 이름을 통해 객체를 추출할 수 있음
     * Kotlin의 Map은 [ ]를 사용할 수 있음
     */

    println("map1 key1= ${map1.get("key1")}")
    println("map1 key1 = ${map1["key1"]}")

    println("---------------------------------")

    /**
     * 기타 메서드
     * size : 관리하는 요소의 개수
     * keys : key를 배열로 반환
     * values : 객체들을 배열로 반환
     * containsKey : 지정된 이름으로 저장된 객체가 있는지 확인
     * containsValue : 지정된 값으로 저장된 객체가 있는지 확인
     */

    println("map1.size = ${map1.size}")
    println("map1.keys = ${map1.keys}")
    println("map1.values = ${map1.values}")

    println("map1.containsKey key1 = ${map1.containsKey("key1")}")
    println("map1.containsKey key100 = ${map1.containsKey("key100")}")

    println("map1.containsValue 10 = ${map1.containsValue(10)}")
    println("map1.containsValue 100 = ${map1.containsValue(100)}")

    println("---------------------------------")

    /**
     * 가변형 Map의 메서드
     * put : 객체를 추가. 기존 이름과 동일할 경우 덮어씌움.
     * remove : 주어진 이름으로 저장된 객체를 제거
     */

    map2.put("key1", 100)
    println("map2 = $map2")

    map2["key2"] = 200  //없는 키에 대해 추가 -> map 에 데이터 추가
    println("map2 = $map2")

    map2.put("key1", 1000)
    map2["key2"] = 2000
    println("map2 = $map2") //있는 키에 대한 추카 -> map 에 데이터 덮어씀

    map2.remove("key1")
    println("map2 = $map2")

    println("---------------------------------")

    /**
     * Map 상호변경
     * toMap : 불변형 Map을 생성해 반환
     * toMutableMap : 가변형 Map을 생성해 반환
     */

    //기존 맵이 변경되는 것이 아님, 데이터를 빼어 변경한 새로운 맵을 만들어 반환
    val map100 = map1.toMutableMap()
    map100["key100"] = 1000
    println("map100 = $map100")

    val map200 = map100.toMap()
    //map200["key200"] = 2000
}