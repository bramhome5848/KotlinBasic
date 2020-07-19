package various;

public class JavaMain {

    public int javaA1 = 100;

    public static int javaA2 = 200;

    public void javaMethod1() {
        System.out.println("javaMethod1");
    }

    public static void javaMethod2() {
        System.out.println("javaMethod2");
    }

    public static void main(String[] args) {

        //자바에서 코틀린 코드 접근
        CompanionTestClass1 t1 = new CompanionTestClass1();
        System.out.println("t1.getA1() = " + t1.getA1());   //코틀린은 getter로 만들어 줌
        t1.testFun1();

        System.out.println("-----------------------------");

        System.out.println("CompanionTestClass1.a2 = " + CompanionTestClass1.Companion.getA2());
        CompanionTestClass1.Companion.testFun2();

        //@JvmStatic 이용시 .Companion 없이 사용 가능
        System.out.println("CompanionTestClass1.getA3() = " + CompanionTestClass1.getA3());
        CompanionTestClass1.testFun3();
    }
}
