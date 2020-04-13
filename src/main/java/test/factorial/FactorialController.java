package test.factorial;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class FactorialController {

    private final FactorialService toto;
    
    @GetMapping("/factorial")
    public long factorial(@RequestParam(name = "n", defaultValue = "0") Integer rank) {
        return toto.computeFactorial(rank);
    }
}
