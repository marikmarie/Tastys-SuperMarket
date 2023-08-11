package barcodescanner;

public class ObserverScanner {

    int code;

    public void update(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
