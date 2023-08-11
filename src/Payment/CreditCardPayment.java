package Payment;

public class CreditCardPayment implements PaymentStrategy {

    private String cardNumber;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    public String pay() {
        return "Credit Card";
    }
}
