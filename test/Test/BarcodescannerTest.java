package Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import barcodescanner.*;


public class BarcodescannerTest {
    
    @Test
    public void testRegisterObserver() {
        ObserverScanner cart = new ObserverScanner();
        Barcodescanner scanner = new Barcodescanner();
        scanner.registerObserver(cart);
        //assertEquals(cart, scanner.observer);
    }
    
    @Test
    public void testNotifyObserver() {
        ObserverScanner cart = new ObserverScanner();
        Barcodescanner scanner = new Barcodescanner();
        scanner.registerObserver(cart);
        scanner.notifyObserver(345);
        assertEquals(345, cart.getCode());
    }
    
    @Test
    public void testUpdate() {
        ObserverScanner cart = new ObserverScanner();
        cart.update(567);
        assertEquals(567, cart.getCode());
    }
    
    @Test
    public void testGetproductCode() {
        ObserverScanner cart = new ObserverScanner();
        cart.update(200);
        assertEquals(200, cart.getCode());
    }
}