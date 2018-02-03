package per.wph;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-03 9:37
 * =============================================
 */
@RunWith(JUnit4.class)
public class JAVA8Tests {

    private static class Car{
        public static Car create(Supplier<Car> supplier){
            return supplier.get();
        }

        public static void ca(Car car){
            System.out.println("JAVA8");
        }
        public Car(){
            super();
        }
        public void show(){
            System.out.println("show this car");
        }
    }

    private class Police{
        public void getCar(Car car){
            System.out.println("我是Police");
            car.show();
        }
    }
    @Test
    public void testLambada(){
        String separator = ",";
        List<Car> cars = Arrays.asList(new Car());
        cars.forEach((a)-> a.show());
        //类的静态方法引用
        cars.forEach(Car::ca);
        Car.create(Car::new).show();
        Police police = new Police();
        //实例的方法引用，参数为迭代对象
        cars.forEach(police::getCar);
        //实例的方法引用，无参数
        cars.forEach(Car::show);
        Optional<String> fullName = Optional.ofNullable(null);
        System.out.println(fullName.isPresent());
        System.out.println(fullName.orElseGet(()->"[none]"));
        System.out.println(fullName.map(s->"Hey" + s + "!").orElse("show"));
        Optional<String> name = Optional.of("Tom");
        System.out.println(name.isPresent());
        System.out.println(name.orElseGet(()->"is none"));
        System.out.println(name.map(s->"Hey " + s).orElse("Hello Strange"));
//        Arrays.asList("a","b","c").forEach((String e)-> System.out.print(e + separator));
//        Arrays.asList("a","b","c").sort((e1,e2)->{
//            e1.compareTo(e2); return -1;
//        });
    }
}
