package utils;

import org.apache.log4j.PropertyConfigurator;

import java.util.Locale;

public class LoggerSetUp {
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String LOG4J_PROPERTIES_FILE_PATH = "\\src\\main\\resources\\log4j.properties";
    private static final String LOG4J_LINUX_PROPERTIES_FILE_PATH = "/src/main/resources/log4j.properties";

    static {
        setUpLog4j();
    }

    protected static void setUpLog4j() {
        String os = System.getProperty("os.name").toLowerCase(Locale.ROOT).substring(0, 3);

        switch (os) {
            case "win":
                PropertyConfigurator.configure(USER_DIR.concat(LOG4J_PROPERTIES_FILE_PATH));
                break;

            case "lin":
                PropertyConfigurator.configure(USER_DIR.concat(LOG4J_LINUX_PROPERTIES_FILE_PATH));
                break;
        }
    }

}
