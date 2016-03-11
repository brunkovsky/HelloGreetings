import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale currentLocale = Locale.getDefault();
        Date currentTime = new Date();

        MessengerFactory messageFactory = new MessengerFactory();
        Messenger messenger = messageFactory.getMessenger(currentLocale);
        String greeting = messenger.getGreeting(currentTime);
        System.out.println(greeting);
    }
}
