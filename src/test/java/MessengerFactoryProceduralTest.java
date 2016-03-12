import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

public class MessengerFactoryProceduralTest {

    @Test
    public void testGetMessenger() {
        MessengerFactory proceduralFactory = new MessengerFactoryProcedural();
        MessengerFactory oppFactory = new MessengerFactoryOop();

        Locale ruLocal = new Locale("ru");
        Locale engLocal0 = new Locale("en");
        Locale engLocal1 = new Locale("some string");

        Messenger proceduralRuMessenger = proceduralFactory.getMessenger(ruLocal);
        Messenger proceduralEngMessenger1 = proceduralFactory.getMessenger(engLocal0);
        Messenger proceduralEngMessenger2 = proceduralFactory.getMessenger(engLocal1);

        Messenger oopRuMessenger = oppFactory.getMessenger(ruLocal);
        Messenger oopEngMessenger1 = oppFactory.getMessenger(engLocal0);
        Messenger oopEngMessenger2 = oppFactory.getMessenger(engLocal1);

        assertEquals("Messenger{morning='С добрым утром, Мир!', day='Добрый день, Мир!', evening='Добрый вечер, Мир!', night='Спокойной ночи, Мир!', MORNING_START=6, DAY_START=9, EVENING_START=19, NIGHT_START=23}", proceduralRuMessenger.toString());
        assertEquals("Messenger{morning='Good morning, World!', day='Good day, World!', evening='Good evening, World!', night='Good night, World!', MORNING_START=6, DAY_START=9, EVENING_START=19, NIGHT_START=23}", proceduralEngMessenger1.toString());
        assertEquals("Messenger{morning='Good morning, World!', day='Good day, World!', evening='Good evening, World!', night='Good night, World!', MORNING_START=6, DAY_START=9, EVENING_START=19, NIGHT_START=23}", proceduralEngMessenger2.toString());

        assertEquals("Messenger{morning='С добрым утром, Мир!', day='Добрый день, Мир!', evening='Добрый вечер, Мир!', night='Спокойной ночи, Мир!', MORNING_START=6, DAY_START=9, EVENING_START=19, NIGHT_START=23}", oopRuMessenger.toString());
        assertEquals("Messenger{morning='Good morning, World!', day='Good day, World!', evening='Good evening, World!', night='Good night, World!', MORNING_START=6, DAY_START=9, EVENING_START=19, NIGHT_START=23}", oopEngMessenger1.toString());
        assertEquals("Messenger{morning='Good morning, World!', day='Good day, World!', evening='Good evening, World!', night='Good night, World!', MORNING_START=6, DAY_START=9, EVENING_START=19, NIGHT_START=23}", oopEngMessenger2.toString());
    }
}
