package test;

import java.util.concurrent.Callable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class ChronoUtils {

    @Getter
    @RequiredArgsConstructor
    public static class ChronoResponse<V> {
        private final long duration;
        private final V result;
    }
    
    public static <V> ChronoResponse<V> chronometrer(Callable<V> callable)  {
        long start = System.currentTimeMillis();
        V result;
        try {
            result = callable.call();
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        return new ChronoResponse<>((end - start), result);
    }
}
