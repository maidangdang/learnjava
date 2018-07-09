package maidangdang.learnjava.producerconsumer1;

public class Test {

    public static void main(String[] args) {
        final Storage storage = new Storage();

        for(int i = 1; i < 6; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                public void run() {
                    storage.produce(String.format("生成者%d:", finalI));
                }
            }).start();
        }

        for(int i = 1; i < 10; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                public void run() {
                    storage.consume(String.format("消费者%d:", finalI));
                }
            }).start();
        }
    }

}
