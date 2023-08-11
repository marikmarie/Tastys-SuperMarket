package Tastys.Product;

public class ShoppingCart implements Subject {
    private Observer observer;
    String message;

    @Override
    public void registerObserver(Observer observerName) {
        observer = observerName;
    }

    @Override
    public void removeObserver() {
        observer = null;
    }
        
    @Override
    public String notifyObserver(){
            message = observer.update();
            return message;
    }
    
}
