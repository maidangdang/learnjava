package maidangdang.learnjava.bloomfilter;

import java.nio.charset.Charset;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * Created by mai on 2018/7/16.
 */
public class BloomFilterTest {
    public static void main(String[] args) {
        BloomFilter<String> b = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 30000000, 0.000001);

        long start = System.currentTimeMillis();

        for(int i = 0; i < 5000; i++) {
            //System.out.println(i);
            b.put(System.nanoTime() + "" + i);
        }

        for(int i = 0; i < 5000; i++) {
            b.mightContain(System.nanoTime() + "" + i);
        }

        long end = System.currentTimeMillis();

        System.out.println("cost: " + (end-start));
    }
}
