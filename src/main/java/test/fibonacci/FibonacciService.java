package test.fibonacci;

import org.springframework.stereotype.Service;

import test.Chrono;

@Service
public class FibonacciService {

    @Chrono
    public int computeFibonacci(int rank) {
        if (rank < 0) {
            throw new IllegalArgumentException("rank must be positive");
        }
        if (rank > 46) {
            throw new IllegalArgumentException("rank cannot be greater than 46");
        }
        
        if (rank == 0) { 
            return 0;
        }
        if (rank == 1 || rank == 2) {
            return 1;
        }
        
        int result = 0;
        int n1 = 1;
        int n2 = 1;
        for(int i=2; i < rank; i++) {
            int current = (n1 + n2);
            result = current;
            n1 = n2;
            n2 = current;
        }
        return result;
    }
}
