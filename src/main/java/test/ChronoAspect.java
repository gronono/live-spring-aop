package test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import test.ChronoUtils.ChronoResponse;

@Aspect
@Slf4j
@Component
public class ChronoAspect {

    @Pointcut("@annotation(test.Chrono)")
    public void myPointcut() {}
    
    @Around("myPointcut()")
    public Object chrono(ProceedingJoinPoint pjp) throws Throwable {
        log.info("Starting {}", pjp.getSignature().toLongString());
        ChronoResponse<?> r = ChronoUtils.chronometrer(() -> {
            try {
                return pjp.proceed();
            } catch (Throwable e) {
                throw new RuntimeException("Erreur durant le chrono", e);
            }
        });
        log.info("End {}", r.getDuration());
        return r.getResult();
    }
}
