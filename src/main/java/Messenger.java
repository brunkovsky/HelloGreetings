import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Messenger {
    private static final Logger log = Logger.getLogger(Messenger.class);
    private final String morning;
    private final String day;
    private final String evening;
    private final String night;
    private final int MORNING_START = 6;
    private final int DAY_START = 9;
    private final int EVENING_START = 19;
    private final int NIGHT_START = 23;

    // метод возвращает messenger с полями, указанными в property-файле
    public Messenger(String nameOfPropertiesFile) {
        log.info("received name of properties file = " + nameOfPropertiesFile);
        Properties properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream(nameOfPropertiesFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            properties.load(inputStreamReader);
        } catch (IOException e) {
            log.error("error reading properties file");
            System.err.println("error reading properties file");
        }

        morning = properties.getProperty("MORNING");
        day = properties.getProperty("DAY");
        evening = properties.getProperty("EVENING");
        night = properties.getProperty("NIGHT");

        if (morning == null || day == null || evening == null || night == null) {
            log.warn("some strings in property file are null!");
            System.err.println("some strings in property file are null!");
        }

        log.info("the result of reading configuration file:\nmorning = " + morning + "\nday = " + day + "\nevening = " + evening + "\nnight = " + night);
    }

    // возвращает приветствие в зависимости от времени суток
    public String getGreeting (Date date) {
        log.info("received date = " + date);
        String result;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
        String hourString = dateFormat.format(date);
        int hour = Integer.parseInt(hourString);
        log.info("Hour was obtained. hour = " + hour);

        if (hour >= MORNING_START && hour < DAY_START) {
            log.info("construction 'if else' choose MORNING");
            result = morning;
        } else if (hour >= DAY_START && hour < EVENING_START) {
            log.info("construction 'if else' choose DAY");
            result = day;
        } else if (hour >= EVENING_START && hour < NIGHT_START) {
            log.info("construction 'if else' choose EVENING");
            result = evening;
        } else {
            log.info("construction 'if else' choose MORNING");
            result = night;
        }
        log.info("Greeting was obtained. result = " + result + "\n\n");
        return result;
    }

    //нужен чтобы выводить в логи объект класса Messenger и для тестов
    @Override
    public String toString() {
        return "Messenger{" +
                "morning='" + morning + '\'' +
                ", day='" + day + '\'' +
                ", evening='" + evening + '\'' +
                ", night='" + night + '\'' +
                ", MORNING_START=" + MORNING_START +
                ", DAY_START=" + DAY_START +
                ", EVENING_START=" + EVENING_START +
                ", NIGHT_START=" + NIGHT_START +
                '}';
    }
}
