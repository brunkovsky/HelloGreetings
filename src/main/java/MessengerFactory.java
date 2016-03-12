import java.util.Locale;

public interface MessengerFactory {
    Messenger getMessenger(Locale locale);
}
