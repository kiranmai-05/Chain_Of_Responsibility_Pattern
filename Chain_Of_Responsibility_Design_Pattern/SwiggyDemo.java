import java.util.*;
abstract class OrderHandler{
    protected OrderHandler nextHandler;
    public OrderHandler(OrderHandler nextHandler){
        this.nextHandler=nextHandler;
    }
    public abstract void processOrder(String order);
}
class OrderValidationHandler extends OrderHandler{
    private OrderHandler nextHandler;
    public OrderValidationHandler(OrderHandler nextHandler){
        super(nextHandler);
    }
    @Override
    public void processOrder(String order){
        System.out.println("Processing your "+order);
        if(nextHandler!=null){
            nextHandler.processOrder(order);  
        }
    }
}
class PaymentProcessingHandler extends OrderHandler{
    public PaymentProcessingHandler(OrderHandler nextHandler){
        super(nextHandler);
    }
    @Override
    public void processOrder(String order){
        System.out.println("Payment is processed for "+order);
        if(nextHandler!=null){
            nextHandler.processOrder(order);
        }
    }
}
class OrderPreparationHandler extends OrderHandler{
    public OrderPreparationHandler(OrderHandler nextHandler){
        super(nextHandler);
    }
    @Override
    public void processOrder(String order){
        System.out.println("Your "+order +" is being prepared by the chef");
        if(nextHandler!=null){
            nextHandler.processOrder(order);
        }
    }
}
class DeliveryAssignemtHandler extends OrderHandler{
    public DeliveryAssignemtHandler(OrderHandler nextHandler){
        super(nextHandler);
    }
    @Override
    public void processOrder(String order){
        System.out.println("Your "+order+" is assigned to the delivery Partner");
        if(nextHandler!=null){
            nextHandler.processOrder(order);
        }
    }
}
class OrderTrackingHandler extends OrderHandler{
    public OrderTrackingHandler(OrderHandler nextHandler){
        super(nextHandler);
    }
    @Override
    public void processOrder(String order){
        System.out.println("Track your order: "+order);
    }
}
public class SwiggyDemo{
    public static void main(String args[]){
        OrderHandler  orderProcessingChain=new OrderValidationHandler(
            new PaymentProcessingHandler(
                new OrderPreparationHandler(
                    new DeliveryAssignemtHandler(
                        new OrderTrackingHandler(null)
                    )
                )
            )
        );
        String order="Pizza";
        orderProcessingChain.processOrder(order);
    }
}