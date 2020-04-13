package test.factorial;

import org.springframework.stereotype.Service;

import test.Chrono;

@Service
public class FactorialService {

    @Chrono
    public long computeFactorial(int rank) {
        return factorial(rank);
    }

    private Long factorial(int rank) {
        if (rank < 0) {
            throw new IllegalArgumentException("rank must be positive");
        }
        if (rank > 23) {
            throw new IllegalArgumentException("rank cannot be greater than 23");
        }
        
        long result = 1;
        for (int i = 1; i <= rank; i++) {
            result = result * i;
        }
        return result;
    }
}
