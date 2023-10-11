package utils;


import org.apache.log4j.PropertyConfigurator;

public class Log {

   protected static final org.apache.log4j.Logger logger= org.apache.log4j.Logger.getLogger(Log.class.getName());

    static{
        PropertyConfigurator.configure(PropertiesFile.getProperties("Log4jPath"));
        }

        public static void startTestCases(String sTestCasesName){
            logger.info("****************************************************************************************");

            logger.info("****************************************************************************************");

            logger.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCasesName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");

            logger.info("****************************************************************************************");

            logger.info("****************************************************************************************");

        }

    public static void endTestCases(String eTestCasesName){
        logger.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");

        logger.info("X");

        logger.info("X");

        logger.info("X");

        logger.info("X");

    }
    public static void info(String message) {

        logger.info(message);

    }

    public static void warn(String message) {

        logger.warn(message);

    }

    public static void error(String message) {

        logger.error(message);

    }

    public static void fatal(String message) {

        logger.fatal(message);

    }

    public static void debug(String message) {

        logger.debug(message);

    }

}






