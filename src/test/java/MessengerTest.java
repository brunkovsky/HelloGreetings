import org.junit.Test;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class MessengerTest {
    private static final int gmt = 1000 * 60 * 60 * 2;              // gmt нужна, чтобы учитывать часовые пояса
    private static final int oneHour = 1000 * 60 * 60;
    private static final int minutes59 = 1000 * 60 * 59;

    @Test
    public void testGetGreeting() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+2"));         // устанавливам часовой пояс
        Messenger engMessenger = new Messenger(new Locale("en"));
        Messenger rusMessenger = new Messenger(new Locale("ru"));

        Date time_00_00 = new Date(0 - gmt);
        Date time_05_59 = new Date(oneHour * 5 + minutes59 - gmt);
        Date time_06_00 = new Date(oneHour * 6 - gmt);
        Date time_08_59 = new Date(oneHour * 8 + minutes59 - gmt);
        Date time_09_00 = new Date(oneHour * 9 - gmt);
        Date time_18_59 = new Date(oneHour * 18 + minutes59 - gmt);
        Date time_19_00 = new Date(oneHour * 19 - gmt);
        Date time_22_59 = new Date(oneHour * 22 + minutes59 - gmt);

        assertEquals("_Good night, World!", engMessenger.getGreeting(time_00_00));
        assertEquals("_Good night, World!", engMessenger.getGreeting(time_05_59));
        assertEquals("Good morning, World!", engMessenger.getGreeting(time_06_00));
        assertEquals("Good morning, World!", engMessenger.getGreeting(time_08_59));
        assertEquals("Good day, World!", engMessenger.getGreeting(time_09_00));
        assertEquals("Good day, World!", engMessenger.getGreeting(time_18_59));
        assertEquals("Good evening, World!", engMessenger.getGreeting(time_19_00));
        assertEquals("Good evening, World!", engMessenger.getGreeting(time_22_59));

        assertEquals("Спокойной ночи, Мир!", rusMessenger.getGreeting(time_00_00));
        assertEquals("Спокойной ночи, Мир!", rusMessenger.getGreeting(time_05_59));
        assertEquals("С добрым утром, Мир!", rusMessenger.getGreeting(time_06_00));
        assertEquals("С добрым утром, Мир!", rusMessenger.getGreeting(time_08_59));
        assertEquals("Добрый день, Мир!", rusMessenger.getGreeting(time_09_00));
        assertEquals("Добрый день, Мир!", rusMessenger.getGreeting(time_18_59));
        assertEquals("Добрый вечер, Мир!", rusMessenger.getGreeting(time_19_00));
        assertEquals("Добрый вечер, Мир!", rusMessenger.getGreeting(time_22_59));
    }
}
