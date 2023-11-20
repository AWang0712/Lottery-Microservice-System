package com.allanwang.lottery.test;

import org.junit.Test;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ApiTest {

    /**
     * lottery strategy test
     * <p>
     * https://www.jugong.wang/random-portal/my/qa
     * https://csrc.nist.gov/Projects/Random-Bit-Generation/Documentation-and-Software
     * Java random number generator: Random & SecureRandom mechanism analysis https://blog.csdn.net/hustspy1990/article/details/93364805
     * Use SecureRandom  https://blog.csdn.net/weixin_41385912/article/details/103267277
     */
    @Test
    public void test_strategy() {
        SecureRandom random = new SecureRandom();
        int rate = random.nextInt(100);

        System.out.println("probability：" + rate);

        List<Map<String, String>> strategyList = new ArrayList<>();

        strategyList.add(new HashMap<String, String>() {{
            put("awardDesc", "first prize：TV");
            put("awardId", "10001");
            put("awardCount", "3");
            put("awardRate", "0.2");
        }});

        strategyList.add(new HashMap<String, String>() {{
            put("awardDesc", "second prize：refrigerator");
            put("awardId", "10002");
            put("awardCount", "5");
            put("awardRate", "0.3");
        }});

        strategyList.add(new HashMap<String, String>() {{
            put("awardDesc", "third prize：washing machine");
            put("awardId", "10003");
            put("awardCount", "10");
            put("awardRate", "0.5");
        }});


    }

    @Test
    public void test_idx() {

        Map<Integer, Integer> map = new HashMap<>();

        int HASH_INCREMENT = 0x61c88647;
        int hashCode = 0;
        for (int i = 1; i <= 100; i++) {
            hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
            int idx = hashCode & (128 - 1);

            map.merge(idx, 1, Integer::sum);

            System.out.println("Fibonacci hashing：" + idx + " normal hashing：" + (String.valueOf(i).hashCode() & (128 - 1)));
        }

        System.out.println(map);
    }


    @Test
    public void test_DrawStrategy() {

        List<Map<String, String>> strategyList = new ArrayList<>();

        strategyList.add(new HashMap<String, String>() {{
            put("awardDesc", "first prize：TV");
            put("awardId", "10001");
            put("awardCount", "3");
            put("awardRate", "20");
        }});

        strategyList.add(new HashMap<String, String>() {{
            put("awardDesc", "second prize：refrigerator");
            put("awardId", "10002");
            put("awardCount", "5");
            put("awardRate", "30");
        }});

        strategyList.add(new HashMap<String, String>() {{
            put("awardDesc", "third prize：washing machine");
            put("awardId", "10003");
            put("awardCount", "10");
            put("awardRate", "50");
        }});

        DrawStrategy drawStrategy = new DrawStrategy();
        drawStrategy.initRateTuple(strategyList);

        for (int i = 0; i < 20; i++) {
            System.out.println("result：" + drawStrategy.randomDraw());
        }

    }


    @Test
    public void test_random() {
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < 20; i++) {
            System.out.println(random.nextInt(1));
        }
    }

}

class DrawStrategy {

    // (√5 - 1) / 2 = 0.6180339887     1.618:1 == 1:0.618，Math.pow(2, 32) * 0.6180339887 = 0x61c88647
    private final int HASH_INCREMENT = 0x61c88647;

    // Used to store 0-100, Fibonacci hash index results
    private String[] rateTuple = new String[128];

    /**
     *
     * Initialize the probability index array
     * Probabilities of different prizes 0.20, 0.30, 0.50, adjusted to range values for the three prizes;
     * First prize: 0-20
     * Second prize: 21-30
     * Third prize: 51-100
     *
     * Then populate the array with each interval range, the index position and the corresponding prize value
     * @param drawConfig
     */
    public void initRateTuple(List<Map<String, String>> drawConfig) {
        int cursorVal = 0;
        for (Map<String, String> drawMap : drawConfig) {
            int rateVal = Integer.parseInt(drawMap.get("awardRate"));

            for (int i = cursorVal + 1; i <= (rateVal + cursorVal); i++) {
                // calculate the index, and populate the array
                int hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
                int idx = hashCode & (rateTuple.length - 1);
                rateTuple[idx] = drawMap.get("awardDesc");
            }

            cursorVal += rateVal;

        }
    }

    /**
     * random draw
     * @return result
     */
    public String randomDraw() {
        // random probability
        int rate = new SecureRandom().nextInt(100) + 1;
        // calculate the index
        int hashCode = rate * HASH_INCREMENT + HASH_INCREMENT;
        int idx = hashCode & (rateTuple.length - 1);
        return rateTuple[idx];
    }

}

