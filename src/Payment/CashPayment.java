package Payment;
public class CashPayment implements PaymentStrategy {
    public String pay() {
        return "Cash";
    }
}
