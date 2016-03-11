import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

public class MessengerFactoryTest {

    @Test
    public void testGetMessenger() {
        MessengerFactory messengerFactory = new MessengerFactory();

        Locale ruLocal = new Locale("ru");
        Locale engLocal0 = new Locale("en");
        Locale engLocal1 = new Locale("some string");

        Messenger ruMessenger = messengerFactory.getMessenger(ruLocal);
        Messenger engMessenger1 = messengerFactory.getMessenger(engLocal0);
        Messenger engMessenger2 = messengerFactory.getMessenger(engLocal1);

        assertEquals("Messenger{morning='С добрым утром, Мир!', day='Добрый день, Мир!', evening='Добрый вечер, Мир!', night='Спокойной ночи, Мир!', MORNING_START=6, DAY_START=9, EVENING_START=19, NIGHT_START=23}", ruMessenger.toString());
        assertEquals("Messenger{morning='Good morning, World!', day='Good day, World!', evening='Good evening, World!', night='Good night, World!', MORNING_START=6, DAY_START=9, EVENING_START=19, NIGHT_START=23}", engMessenger1.toString());
        assertEquals("Messenger{morning='Good morning, World!', day='Good day, World!', evening='Good evening, World!', night='Good night, World!', MORNING_START=6, DAY_START=9, EVENING_START=19, NIGHT_START=23}", engMessenger2.toString());
    }
}
