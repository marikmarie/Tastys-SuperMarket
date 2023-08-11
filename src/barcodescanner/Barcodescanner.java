package barcodescanner;
public class Barcodescanner {
    ObserverScanner observer;
    public void registerObserver(ObserverScanner observer){
        this.observer = observer;
    }
    
    public void notifyObserver(int code){
        observer.update(code);
    }
}
