package ba.codecta.academy;
import ba.codecta.academy.disneylandFiles.DisneyLand;
import ba.codecta.academy.netflixFiles.Netflix;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class mainApp {
    private static final String LOG_FILE = "../log4j.properties";
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(String.valueOf(mainApp.class));
        Properties properties = new Properties();

        Options options = new Options();
        options.addOption(Option.builder("i")
                .longOpt("option")
                .hasArg(true)
                .desc("option ([REQUIRED] or use --option)")
                .required(false)
                .build());

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            properties.load(new FileInputStream(LOG_FILE));
            PropertyConfigurator.configure(properties);
            logger.info("Logger initialised successfully");
            cmd = parser.parse(options, args);

            if (cmd.hasOption("i")) {
                String option = cmd.getOptionValue("i");
                if(option.toLowerCase().equals("disneyland")) {
                    logger.info("DisneyLand class initialised");
                    DisneyLand.start();
                } else if(option.toLowerCase().equals("netflix")) {
                    logger.info("Netflix class initialised");
                    Netflix.start();
                }
            }
        } catch (ParseException pe) {
            System.out.println("Error parsing command-line arguments!");
            System.out.println("Please, follow the instructions below:");
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "Log messages to sequence diagrams converter", options );
            System.exit(1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

