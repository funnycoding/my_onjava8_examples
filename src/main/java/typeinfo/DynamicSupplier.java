package typeinfo;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/28 8:12 下午
 */
// DynamicSupplier.java
class CountedInteger {
    private static long counter;
    private final long id = counter++;

    public CountedInteger() {
        System.out.println("Counted Integer无参构造函数被调用了 , Id: " + id);
    }

    @Override
    public String toString() {
        return Long.toString(id);
    }
}

public class DynamicSupplier<T> implements Supplier<T> {

    private Class<T> type;

    public DynamicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Stream.generate(new DynamicSupplier<>(CountedInteger.class))
                .skip(10) // 这里skip 是包含的，跳过10个，包含第10个
                .limit(5)
                .forEach(System.out::println);
    }
}
