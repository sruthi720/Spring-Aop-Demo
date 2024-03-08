package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* demo.ShoppingCart.checkOut(..))")
    public void beforeLogger(JoinPoint joinPoint){

        System.out.println(joinPoint.getSignature());
        String args = joinPoint.getArgs()[0].toString();
        System.out.println(args);
        System.out.println("Logger called before checkout()");
    }

    @Pointcut("execution(* demo.ShoppingCart.quantity(..))")
    public void afterReturningPointcut(){
    }

    @AfterReturning(pointcut ="afterReturningPointcut()",returning = "retVal")
    public void  afterReturning(String retVal){
        System.out.println("After Returning: "+ retVal);
    }

    @After("execution(* demo.ShoppingCart.checkOut(..))")//*-> for any return type, *-> for any package , *-> for any class
    public void afterLogger(){
        System.out.println("Logger called after checkout(..)");//.. signifies any number of parameters.
    }


}


//when ever shopping cart's checkout() execute,  first logging function has to execute so define the @before annotation with it
//before calling checkout() method i wanna cal;l Logger()
//inside execution u can define which particular methods has to be invoked
//*--> means for any return types
//to use it  @EnableAspectjAutoPoxy  Annotation put on BeanConfig