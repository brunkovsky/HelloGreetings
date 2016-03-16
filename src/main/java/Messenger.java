import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

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
        ResourceBundle resourceBundle = ResourceBundle.getBundle("bundle", locale);
        log.info("received locale in constructor: " + locale);
        try {
            morning = new String(resourceBundle.getString("MORNING").getBytes("ISO-8859-1"), "UTF-8");
            day = new String(resourceBundle.getString("DAY").getBytes("ISO-8859-1"), "UTF-8");
            evening = new String(resourceBundle.getString("EVENING").getBytes("ISO-8859-1"), "UTF-8");
            night = new String(resourceBundle.getString("NIGHT").getBytes("ISO-8859-1"), "UTF-8");
            log.info("result of bundle read:\n\tmorning: " + morning + "\n\tday: " + day + "\n\tevening: " + evening + "\n\tnight: " + night);
        } catch (UnsupportedEncodingException e) {
            log.error("UnsupportedEncodingException was happened: " + e);
            e.printStackTrace();
        }
    }

    public String getGreeting(Date currentTime) {
        int hour = getHourFromDate(currentTime);
        return getGreeting(hour);
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
