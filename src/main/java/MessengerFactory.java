import org.apache.log4j.Logger;

import java.util.Locale;

public class MessengerFactory {
    private static final Logger log = Logger.getLogger(MessengerFactory.class);

    // метод выбирает properties файл в зависимости от локали пользователя
    public Messenger getMessenger(Locale locale) {
        log.info("MessengerFactory received local = " + locale);
        Messenger messenger;

        switch (locale.toString()) {
            case "ru":      // русская локаль для MAC OS X
                messenger = new Messenger("src/main/resources/russian.properties");
                break;
            case "ru_RU":   // русская локаль для Windows
                messenger = new Messenger("src/main/resources/russian.properties");
                break;
            default:
                messenger = new Messenger("src/main/resources/english.properties");
        }
        log.info("messenger return object = " + messenger);
        return messenger;
    }
}
