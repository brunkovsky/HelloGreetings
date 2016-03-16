import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class Messenger {
    private static final Logger log = Logger.getLogger(Messenger.class.getName());
    private String morning;
    private String day;
    private String evening;
    private String night;
    private final static int MORNING_START = 6;
    private final static int DAY_START = 9;
    private final static int EVENING_START = 19;
    private final static int NIGHT_START = 23;

    public Messenger(Locale locale) {
        String nameOfPropertiesFile = recognizeLocale(locale);
        propertiesRead(nameOfPropertiesFile);
    }

    public String getGreeting(Date currentTime) {
        int hour = getHourFromDate(currentTime);
        return getGreeting(hour);
    }

    private String recognizeLocale(Locale locale) {
        log.info("received local: " + locale);
        String result;
        switch (locale.toString()) {
            case "ru":      // русская локаль для MAC OS X
                result = "russian.properties";
                break;
            case "ru_RU":   // русская локаль для Windows
                result = "russian.properties";
                break;
            default:        // если неизвестная локаль, то берем английскую
                result = "english.properties";
        }
        log.info("result of recognizeLocale: " + result);
        return result;
    }

    private void propertiesRead(String nameOfPropertiesFile) {
        log.info("received nameOfPropertiesFile: " + nameOfPropertiesFile);
        // здесь мы загружаем тот properties файл, который указали в аргументах конструктора
        Properties properties = new Properties();
        InputStream inputStream = getClass().getResourceAsStream(nameOfPropertiesFile);
        try {
            // эта строчка нужна, чтобы правильно читалась кириллица
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            properties.load(inputStreamReader);
        } catch (IOException e) {
            log.error("IOException while loading properties file: " + e);
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                log.error("IOException while close properties file: " + e);
                e.printStackTrace();
            }
        }
        morning = properties.getProperty("MORNING");
        day = properties.getProperty("DAY");
        evening = properties.getProperty("EVENING");
        night = properties.getProperty("NIGHT");
        log.info("result of propertiesRead:\n\tmorning: " + morning + "\n\tday: " + day + "\n\tevening: " + evening + "\n\tnight: " + night);
    }

    private int getHourFromDate(Date currentTime) {
        log.info("received currentTime: " + currentTime);
        int result;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
        String hourString = dateFormat.format(currentTime);
        result = Integer.parseInt(hourString);
        log.info("result of getHourFromDate method: " + result);
        return result;
    }

    private String getGreeting(int hour) {
        log.info("received hour: " + hour);
        String result;
        if (hour >= MORNING_START && hour < DAY_START) {
            result = morning;
        } else if (hour >= DAY_START && hour < EVENING_START) {
            result = day;
        } else if (hour >= EVENING_START && hour < NIGHT_START) {
            result = evening;
        } else {
            result = night;
        }
        log.info("result of getGreeting: " + result + "\n");
        return result;
    }
}
