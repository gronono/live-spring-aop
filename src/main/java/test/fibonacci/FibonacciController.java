package test.fibonacci;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FibonacciController {

    private final FibonacciService fibonacciService;
    
    @GetMapping("/fibonacci")
    public long factorial(@RequestParam(name = "n", defaultValue = "0") Integer rank) {
        return fibonacciService.computeFibonacci(rank);
    }
}
