package org.example.SpringBootMVC;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    @Before("execution(public * org.example.SpringBootMVC.AlienRestController.*(*))")
    public void log(){
        logger.info("getAlien() method called");
    }
}
