package maidangdang.learnjava.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Lambda 表达式是一种匿名函数(对 Java 而言这并不完全正确，但现在姑且这么认为)，简单地说，它是没有声明的方法，也即没有访问修饰符、返回值声明和名字。
 *
 * 你可以将其想做一种速记，在你需要使用某个方法的地方写上它。当某个方法只使用一次，而且定义很简短，使用这种速记替代之尤其有效，这样，你就不必在类中费力写声明与方法了。
 */

// 定义一个函数式接口
@FunctionalInterface
interface WorkerInterface {
    public void doSomeWork();
}

public class WorkerInterfaceTest {

    public static void execute(WorkerInterface worker) {
        worker.doSomeWork();
    }

    public static void main(String [] args) {
        // invoke doSomeWork using Annonymous class
        execute(new WorkerInterface() {
            @Override
            public void doSomeWork() {
                System.out.println("Worker invoked using Anonymous class");
            }
        });

        //invoke doSomeWork using Lambda expression
        execute( () -> System.out.println("Worker invoked using Lambda expression") );

        // 线程可以通过以下方法初始化
        // 旧方法:
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from thread");
            }
        }).start();
        // 新方法:
        new Thread(
            () -> System.out.println("Hello from thread")
        ).start();

        // 打印出给定数组中的所有元素
        // Old way:
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        for(Integer n: list) {
            System.out.println(n);
        }
        // New way:
        list.forEach(n -> System.out.println(n));
        // or we can use :: double colon operator in Java 8
        list.forEach(System.out::println);

        // 使用 Lambda 表达式打印数值中每个元素的平方
        // Old way:
        for(Integer n : list) {
            int x = n * n;
            System.out.println(x);
        }
        // New way:
        list.stream().map((x) -> x*x).forEach(System.out::println);

        // 计算给定数值中每个元素平方后的总和
        // Old way:
        int sum = 0;
        for(Integer n : list) {
            int x = n * n;
            sum = sum + x;
        }
        System.out.println(sum);
        // New way:
        int sum1 = list.stream().map(x -> x*x).reduce((x,y) -> x + y).get();
        System.out.println(sum1);
    }
}


