package Threads;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Syril on 28-06-2016.
 */
public class AtomicReference {
    public static void main(String[] args) {
        /*ConcurrentHashMap<String, BigDecimal> sumByAccount = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, BigDecimal> sumByAccount = new ConcurrentHashMap<>();
        sumByAccount.put("ICICI Direct", new BigDecimal(100));
        sumByAccount.put("Reliance", new BigDecimal(200));
        addToSum("ICICI Direct", new BigDecimal(200), sumByAccount);
        for (Map.Entry<String, BigDecimal> entry : sumByAccount.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
         */
        ConcurrentHashMap<String, AtomicReference<BigDecimal>> sumByAccount = new ConcurrentHashMap<>();
        sumByAccount.put("ICICI Direct", new AtomicReference<>(new BigDecimal(100)));
        sumByAccount.put("Reliance", new AtomicReference<>(new BigDecimal(200)));
        addToSum("ICICI Direct", new BigDecimal(200), sumByAccount);
        for (Map.Entry<String, AtomicReference<BigDecimal>> entry : sumByAccount.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    /*static void addToSum(String account, BigDecimal amount, ConcurrentHashMap<String, BigDecimal> sumByAccount) {
        BigDecimal newSum = sumByAccount.get(account).add(amount);
        sumByAccount.put(account, newSum);
    }*/

    static void addToSum(String account, BigDecimal amount, ConcurrentHashMap<String, AtomicReference<BigDecimal>> sumByAccount) {
        AtomicReference<BigDecimal> newSum = sumByAccount.get(account);
        for (; ; ) {
            BigDecimal oldVal = newSum.get();
            if (newSum.compareAndSet(oldVal, oldVal.add(amount)))
                return;
        }
    }
}
