package demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkOut(String status){
        System.out.println("Shopping Cart method called");
    }
    public int quantity(){
        return 2;
    }
}

//we need to create the bean of the shopping cart  make this class  @component
// and to get these configuration either we can go for the Xml based configuration or annotation based configuration
//here we go with annotation based config  with the beanConfig file

