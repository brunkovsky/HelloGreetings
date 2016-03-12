import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale currentLocale = Locale.getDefault();
        Date currentTime = new Date();

        MessengerFactory oopFactory = new MessengerFactoryOop();
        MessengerFactory proceduralFactory = new MessengerFactoryProcedural();

        Messenger oopMessenger = oopFactory.getMessenger(currentLocale);
        String oopGreeting = oopMessenger.getGreeting(currentTime);
        System.out.println(oopGreeting);

        Messenger proceduralMessenger = proceduralFactory.getMessenger(currentLocale);
        String proceduralGreeting = proceduralMessenger.getGreeting(currentTime);
        System.out.println(proceduralGreeting);
    }
}
