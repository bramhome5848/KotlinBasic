package control

fun main() {

    //return : 현재 수행 중인 함수를 종료
    val r1:Int = testFun1(100)
    println("r1 = $r1")

    val r2:Int = testFun2(2)
    println("r2 = $r2")

    val r3:Int = testFun2(0)
    println("r3 = $r3")

    testFun3(100)
    testFun3(0)

    println("-------------------------------------------")

    //break : 가장 가까운 반복문 종료
    for (item in 1..10) {
        if (item > 5) {
            break;
        }
        println("item = $item")
    }

    println("-------------------------------------------")

    //continue : 반복문에서 continue 이후에 코드가 더 있더라도 다시 위로 올라가는 구문
    for (item in 1..10) {
        if(item % 2 ==0){
            continue
        }
        println("item = $item")
    }
}

fun testFun1(a1:Int) : Int {
    println("testFun1")
    return a1+100
}

fun testFun2(a1:Int) : Int {
    println("testFun2")

    if(a1==0){
        return -1
    }
    println("이 부분이 수행될까요??")

    return 100/a1
}

fun  testFun3(a1:Int) {

    if(a1==0){
        return
    }

    println("a1은 0이 아닙니다")
}