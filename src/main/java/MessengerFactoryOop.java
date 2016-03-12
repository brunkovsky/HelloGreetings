import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class MessengerFactoryOop implements MessengerFactory {
    private static final Logger log = Logger.getLogger(MessengerFactoryOop.class);
    private final Map<String, Messenger> languagesMap = new HashMap<>();

    // в конструкторе происходит заполнение мапы languagesMap,
    // где ключ = стринга, описывающая локаль,
    // а значение = конкретный объект, говорящий на соответствующем языке
    // пришлось дублировать значения с разными ключами,
    // т.к. разные ОС по-разному выводят в строку свою локаль.
    public MessengerFactoryOop() {
        languagesMap.put("en", new Messenger("src/main/resources/english.properties"));
        languagesMap.put("en_EN", new Messenger("src/main/resources/english.properties"));
        languagesMap.put("ru", new Messenger("src/main/resources/russian.properties"));
        languagesMap.put("ru_RU", new Messenger("src/main/resources/russian.properties"));
    }

    // метод выбирает из мапы languagesMap объект
    // по ключу locale, переданному в параметрах метода
    @Override
    public Messenger getMessenger(Locale locale) {
        log.info("received local = " + locale);
        Messenger messenger = languagesMap.get(locale.toString());
        messenger = messenger != null ? messenger : languagesMap.get(Locale.ENGLISH.toString());
        log.info("messenger return object = " + messenger);
        return messenger;
    }
}
