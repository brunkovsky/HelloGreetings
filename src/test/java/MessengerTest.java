import java.util.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class MessengerTest {

    @Test
    public void testShowGreeting() {
        Messenger rusMessenger = new Messenger("src/test/test-resources/russian.properties");
        Messenger engMessenger = new Messenger("src/test/test-resources/english.properties");

        Date night0 = new Date(2016, 3, 2, 23, 0);
        Date night1 = new Date(2016, 3, 3, 0, 0);
        Date night2 = new Date(2016, 3, 3, 5, 59);
        Date morning0 = new Date(2016, 3, 3, 6, 0);
        Date morning1 = new Date(2016, 3, 3, 8, 59);
        Date day0 = new Date(2016, 3, 3, 9, 0);
        Date day1 = new Date(2016, 3, 3, 18, 59);
        Date evening0 = new Date(2016, 3, 3, 19, 0);
        Date evening1 = new Date(2016, 3, 3, 22, 59);

        assertEquals("Спокойной ночи, Мир!", rusMessenger.getGreeting(night0));
        assertEquals("Спокойной ночи, Мир!", rusMessenger.getGreeting(night1));
        assertEquals("Спокойной ночи, Мир!", rusMessenger.getGreeting(night2));
        assertEquals("С добрым утром, Мир!", rusMessenger.getGreeting(morning0));
        assertEquals("С добрым утром, Мир!", rusMessenger.getGreeting(morning1));
        assertEquals("Добрый день, Мир!", rusMessenger.getGreeting(day0));
        assertEquals("Добрый день, Мир!", rusMessenger.getGreeting(day1));
        assertEquals("Добрый вечер, Мир!", rusMessenger.getGreeting(evening0));
        assertEquals("Добрый вечер, Мир!", rusMessenger.getGreeting(evening1));

        assertEquals("Good night, World!", engMessenger.getGreeting(night0));
        assertEquals("Good night, World!", engMessenger.getGreeting(night1));
        assertEquals("Good night, World!", engMessenger.getGreeting(night2));
        assertEquals("Good morning, World!", engMessenger.getGreeting(morning0));
        assertEquals("Good morning, World!", engMessenger.getGreeting(morning1));
        assertEquals("Good day, World!", engMessenger.getGreeting(day0));
        assertEquals("Good day, World!", engMessenger.getGreeting(day1));
        assertEquals("Good evening, World!", engMessenger.getGreeting(evening0));
        assertEquals("Good evening, World!", engMessenger.getGreeting(evening1));
    }
}
