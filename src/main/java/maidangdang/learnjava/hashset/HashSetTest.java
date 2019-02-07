package maidangdang.learnjava.hashset;

import java.util.HashSet;

/**
 * Created by mai on 2018/7/16.
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < 5000; i++) {
            //System.out.println(i);
            set.add(System.nanoTime() + "");
        }

        long start = System.currentTimeMillis();
        for(int i = 0; i < 5000; i++) {
            set.contains(System.currentTimeMillis());
        }
        long end = System.currentTimeMillis();

        System.out.println("cost: " + (end-start));
    }
}
