package log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;

// org.apache.log4j.ConsoleAppender
// org.apache.log4j.FileAppender
// org.apache.log4j.DailyRollingFileAppender
// org.apache.log4j.RollingFileAppender
// org.apache.log4j.WriteAppender
// org.apache.log4j.jdbc.JDBCAppender

public class Log4jMain {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Log4jMain.class);

        BasicConfigurator.configure();

        SimpleLayout layout = new SimpleLayout();
        PatternLayout playout = new PatternLayout("[%-5p] %d{yyyy-MM-dd HH:mm:ss,SSS} method:%l%n%m%n");

        FileAppender appender = null;
        ConsoleAppender appenderC = null;

        try {
            appender = new FileAppender(layout, "out.txt", false);
            appenderC = new ConsoleAppender(playout, ConsoleAppender.SYSTEM_OUT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.addAppender(appender);
        logger.addAppender(appenderC);
        logger.setLevel(Level.INFO);

        logger.info("This is a Level info");
        logger.warn("This is a Level Warn");
        logger.error("This is a Level error");
        logger.fatal("This is a level fatal");
    }
}
