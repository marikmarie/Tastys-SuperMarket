package Test;
import Payment.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PaymentContextTest {

   @Test
    public void testCashPaymentStrategy() {
        PaymentContext paymentContext = new PaymentContext(new CashPayment());
        String paidWith = paymentContext.pay();
        assertEquals("cash", paidWith);
    }
    
    @Test
    public void testCreditCardPaymentStrategy() {
        CreditCardPayment cardpay = new CreditCardPayment("212314", "1546");
        PaymentContext paymentContext = new PaymentContext(cardpay);
        String paidWith = paymentContext.pay();
        assertEquals("credit card", paidWith);
    }
}

