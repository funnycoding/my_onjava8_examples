package typeinfo.toys;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/28 6:52 下午
 */
// typeinfo/toys/ToyTest.java
// 测试 Class 类
interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
    Toy() {
    }

    Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    public FancyToy() {
        super(1);
    }
}


public class ToyTest {
    static void printInfo(Class clazz) {
        System.out.println("ClassName: " + clazz.getName() + "," + " is interface?[" + clazz.isInterface() + "]");

        System.out.println("Simple Nmae : " + clazz.getSimpleName());

        System.out.println("Canonical name: " + clazz.getCanonicalName());
    }

    public static void main(String[] args) {
        Class clazz = null;
        try {
            clazz = Class.forName("typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }

        printInfo(clazz);
        System.out.println("---- Befoe Print CC ----");
        for (Class face : clazz.getInterfaces()) { // 获取到一个类的所有接口信息
            printInfo(face);
        }
        System.out.println("---- After Print CC ----");

        Class superclass = clazz.getSuperclass();
        Object obj = null;

        try {
            obj = superclass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("Can't Access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
