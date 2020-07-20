package various

import com.sun.xml.internal.bind.v2.util.TypeCast
import oopClass.Inter1

/**
 * 형 변환
 * 변수에 담긴 값이나 객체를 다른 형태로 변환하는 것을 의미
 * Kotlin은 모든 값을 객체로 관리하기 때문에 Kotlin에서의 형변환은 다른 클래스 타입의 객체로 변환하는 것을 의미
 * 자식 클래스 타입으로의 변환
 * 부모 클래스 타입으로의 변환
 * 다른 자료형 타입으로의 변환
 * null 허용과 null 불허용 간의 변환
 */

/**
 * 스마트 캐스팅
 * 특정 조건을 만족하면 자동으로 형변환이 발생하는 개념
 * 스마트 캐스팅 기능 덕분에 형변환에 대해 개발자가 크게 신경을 쓰지 않아도 됨
 * 형 변환은 객체의 클래스 타입이 아닌 객체의 주소 값을 가지고 있는 참조 변수의 타입이 변경되는 것
 */
fun main() {

    val obj1:TypeCastingSubClass1 = TypeCastingSubClass1()
    val obj2:TypeCastingSubClass2 = TypeCastingSubClass2()


    /**
     * 객체 타입 변환
     * 객체의 타입 변환은 상속관계나 구현한 인터페이스 타입에 해당
     * 부모 클래스 타입으로의 형 변환
     * 자식 클래스 타입으로의 형 변환
     * 구현한 인터페이스 타입으로의 형 변환
     * 인터페이스를 구현한 클래스 타입으로의 형 변환
     */

    //부모 클래스 타입 참조 변수에 담는다
    //스마트캐스팅 발생
    val super1:TypeCastingSuperClass1 = obj1
    val inter1:TypeCastingInterface1 = obj2

    // 부모형 변수가 자식형 객체를 가지고 있다고 해도
    // 자식형 변수에 부모형 변수 정보를 담을 수 있도록 하는 스마트캐스팅이 발생하지 않음
    //val obj3:TypeCastingSubClass1 = super1
    //val obj4:TypeCastingSubClass2 = inter1

    println("--------------------------")

    /**
     * as 연산자
     * 객체를 지정된 클래스 타입으로 변환하는 연산자이다.
     * 참조변수 as 클래스타입
     * 만약 객체가 지정된 클래스타입과 관계가 없을 경우 오류가 발생
     * 형변환이 발생한 참조 변수는 변환된 타입을 유지
     */

    //as 지정된 클래스 타입으로 강제 변환하는 연산자
    super1 as TypeCastingSubClass1
    inter1 as TypeCastingSubClass2

    //관련 없는 경우는 casting 에러
    //inter1 as TypeCastingSubClass1

    //부모형 변수는 부모 영역에만 접근 가능
    //형 변환으로는 가능
    super1.subMethod1()
    inter1.subMethod2()

    println("--------------------------")

    /**
     * is 연산자
     * 형 변환이 가능하면 변환을 하고 true를 반환
     * if 문으로 구성하여 사용하며 if 문 내에서만 변환된 타입을 사용하고 if 문을 나가게 되면 변환되기 전의 타입으로 다시 변경
     */

    val obj3:TypeCastingSubClass1 = TypeCastingSubClass1()
    val chk1 = obj3 is TypeCastingSuperClass1
    println("chk1 = $chk1")

    val super3:TypeCastingSuperClass1 = obj3
    val chk3 = super3 is TypeCastingSubClass1
    println("chk3 = $chk3") //형변환이 가능하기 때문에 true

    if(super3 is TypeCastingSubClass1) { //super3이 SubClass1로 형변환이 가능하면
        //super3 as TypeCastingSubClass1
        //is 연산자 값이 true 라면 형변환이 가능한 상황이므로 스마트 캐스팅 발생
        super3.subMethod1()
    }
    //if문을 빠져나오면 변환되기 전 타입으로 다시 돌아감
    //super3.subMethod1()

    println("--------------------------")

    /**
     * any 타입
     * Kotlin은 모든 클래스가 직접 혹은 간접적으로 Any 클래스를 상속
     * 따라서 모든 객체의 주소 값은 Any 타입 참조 변수에 담을 수 있음
     * Any 타입과 is 연산자를 활용하여 다양한 타입의 객체에 대응할 수 있는 코드를 만들 수 있음
     */

    val obj10:TypeCastingSubClass1 = TypeCastingSubClass1()
    val obj11:TypeCastingSubClass2 = TypeCastingSubClass2()

    anyMethod(obj10)
    anyMethod(obj11)
    anyMethod(100)
    anyMethod("문자열")

    println("--------------------------")

    /**
     * 기본 타입의 형 변환
     * Kotlin 에서는 기본 타입을 관리하는 객체의 타입을 변경하는 메서드를 제공
     * 참조 변수의 타입이 변경되는 것이 아닌 새로운 객체가 생성되어 반환
     * toByte(), toShort(), toInt(), toLong(), toFloat(), toDouble(), toChar()
     */

    val number1:Int = 100
    val number2:Long = number1.toLong()
    println("number2 = $number2")

    val str1:String = "100"
    val number3:Int = str1.toInt()
    println("number3 = $number3")

    //NumberFormatException
    val str2:String = "안녕하세요"
    val number4:Int = str2.toInt()
    println("number4 = $number4")
}

open class TypeCastingSuperClass1

interface TypeCastingInterface1

class TypeCastingSubClass1 : TypeCastingSuperClass1() {
    fun subMethod1() {
        println("SubClass1의 subMethod1입니다")
    }
}
class TypeCastingSubClass2 : TypeCastingInterface1 {
    fun subMethod2() {
        println("SubClass2의 subMethod2입니다")
    }
}

//클래스 타입별로 분기해서 처리 가능
fun anyMethod(obj:Any) {
    if(obj is TypeCastingSubClass1) {
        obj.subMethod1()
    } else if(obj is TypeCastingSubClass2) {
        obj.subMethod2()
    } else if(obj is Int) {
        println("정수입니다")
    } else if(obj is String) {
        println("문자열입니다")
    }
}
