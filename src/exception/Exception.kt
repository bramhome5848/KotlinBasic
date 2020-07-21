package exception

import java.lang.ArithmeticException
import java.lang.Exception
import java.lang.IndexOutOfBoundsException

/**
 * 예외
 * 프로그램 실행 중 예측이 가능한 오류들을 예외라고 함
 * 예외가 발생하면 코드의 수행이 중단
 * 예외 처리는 예외가 발생했을 때 프로그램이 수행되는 것을 막고
 * 예외 발생 시 동작해야 하는 코드를 수행시켜 프로그램이 문제없이 동작하게 하기 위한 목적
 */
fun main() {

    try {
        //Java 와 마찬가지로 예외가 발생 -> 예외 종류에 따른 클래스를 가지고 객체를 만들어 반환
        //val a1 = 10/0   //ArithmeticException

        //val str:String? = null    //KotlinNullPointerException
        //println(str!!.length)

        val str2 = "안녕하세요"
        val a2:Int = str2.toInt()   //NumberFormatException
        println("a2 = $a2")
    } catch (e:ArithmeticException) {   //예외 처리가 많은 경우 모두 처리하기 힘듬
        println("수학적 오류가 발생하였습니다")
    } catch (e:KotlinNullPointerException) {
        println("null 오류가 발생하였습니다")
    } catch (e:Exception) {     //모든 exception은 Exception을 상속
        println("예외 발생")
        e.printStackTrace()
    }

    //예외처리 시행후 정상 처리로 판단하여 코드 계속 수행
    println("이 부분이 수행 될까요??")
}

/**
 * 예외처리란 예외가 발생했을 때 프로그램 수행이 중단되는 것을 막고
 * 예외 발생 시 동작해야 할 코드를 동작 시켜 프로그램이 정상적으로 수행될 수 있도록 하는 것
 */