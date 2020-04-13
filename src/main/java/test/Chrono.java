package test;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @see ChronoAspect
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface Chrono {

}
