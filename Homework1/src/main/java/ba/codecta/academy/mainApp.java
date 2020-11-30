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

public class mainApp {
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption(Option.builder("i")
                .longOpt("option")
                .hasArg(true)
                .desc("option ([REQUIRED] or use --option)")
                .required(false)
                .build());
        options.addOption(Option.builder("s")
                .longOpt("genre")
                .hasArg(true)
                .desc("genre ([REQUIRED] or use --genre)")
                .required(false)
                .build());

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);

            if (cmd.hasOption("i")) {
                String option = cmd.getOptionValue("i");
                System.out.println("Chosen option = " + option);
                if(option.toLowerCase().equals("disneyland")) {
                    DisneyLand.start();
                } else if(option.toLowerCase().equals("netflix")) {
                    if(cmd.hasOption("s")) {
                        String genre = cmd.getOptionValue("s");

                    }
                    Netflix.start();
                }
            }
        } catch (ParseException pe) {
            System.out.println("Error parsing command-line arguments!");
            System.out.println("Please, follow the instructions below:");
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "Log messages to sequence diagrams converter", options );
            System.exit(1);
        }
    }
}

