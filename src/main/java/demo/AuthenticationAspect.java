package demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AuthenticationAspect {
    @Pointcut("within(demo..*)")//for all package classes
    public void authenticatingPointcut(){

    }

    @Pointcut("within(demo.ShoppingCart)")//only for shopping cart
    public void authorizationPointcut(){

    }


    @Before("authenticatingPointcut() && authorizationPointcut() ")
    public void authenticate(){
        System.out.println("Authenticating the request");
    }



}
