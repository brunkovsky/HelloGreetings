import java.io.IOException;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        Messenger messenger = new Messenger(Locale.getDefault());
        System.out.println(messenger.getGreeting(new Date()));
    }
}
