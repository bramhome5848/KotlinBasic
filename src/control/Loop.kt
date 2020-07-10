package control

fun main() {

    val a1:IntRange = 1..10
    for (item in a1) {
        println("item = $item")
    }

    println("-------------------------------------------")

    val a2:IntProgression  = 1..10 step 2
    for (item in a2) {
        println("item = $item")
    }

    println("-------------------------------------------")

    val a3:IntProgression = 10 downTo 1
    for (item in a3) {
        println("item = $item")
    }

    println("-------------------------------------------")

    val a4:IntProgression = 10 downTo 1 step 2
    for (item in a4) {
        println("item = $item")
    }

    // kotlin 공식 사이트
    for (x in 0..10) println(x) // Prints 0 through 10 (inclusive)
    for (x in 0 until 10) println(x) // Prints 0 through 9
    for (x in 0 until 10) println(x) // Prints 0 through 9
    for (x in 10 downTo 0 step 2) println(x) // Prints 10, 8, 6, 4, 2, 0

    println("-------------------------------------------")

    var a5:Int = 0

    while(a5 < 10) {
        println("a5 = $a5")
        a5++
    }

    println("-------------------------------------------")

    var a6:Int = 100
    do {
        println("a6 = $a6")
        a6++
    } while (a6<10)
}