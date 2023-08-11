package Tastys.Product;
public interface Subject {
   void registerObserver(Observer o);
    void removeObserver();
    String notifyObserver();
}
