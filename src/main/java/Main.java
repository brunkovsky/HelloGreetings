import java.io.IOException;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        Locale currentLocale = Locale.getDefault();
        Date currentTime = new Date();

        Messenger messenger = new Messenger(currentLocale);
        System.out.println(messenger.getGreeting(currentTime));
    }
}
