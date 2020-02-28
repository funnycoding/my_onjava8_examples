package typeinfo.toys;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/28 8:19 下午
 */
// typeinfo/toys/GenericToyTest.java
// 测试 Class 类
// {java typeinfo.toys.GenericToyTest}
public class GenericToyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<FancyToy> ftClass = FancyToy.class;

        // Produces exat type：
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> superclass = ftClass.getSuperclass();
        // This won't compile: 下面的语句不能编译 具体还是跟泛型的擦除有关
        // Class<Toy> up2 = ftClass.getSuperclass();

        // Only produces Object: 只能构造 Object对象 而不是 Toy 对象
        Toy object = (Toy) superclass.newInstance();
    }
}
