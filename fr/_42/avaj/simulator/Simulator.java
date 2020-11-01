package fr._42.avaj.simulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Simulator {

    public static void main(String[] arg) throws InterruptedException, InvalideArgumentException {
        System.out.println("avaj launched !");

        if(arg.length > 1) {
            throw new InvalideArgumentException("To many arguments, only the path " +
                    "of the scenario file is needed :)");
        }
        if(arg.length < 1) {
            throw new InvalideArgumentException("Oops, you forgot to provide " +
                    "the path of the scenario file in arguments ! :(");
        }

        File scenarioFile = new File(arg[0]);
        if (!scenarioFile.exists()) {
            throw new InvalideArgumentException("Sorry, the file " + arg[0] + " does not exist or you have misspelled it :(");
        }

        try {
            Logger logger = new Logger();

            //parse scenario file
            // create aircraft with aricraft factory
            // register them

            //run simulation with the number in the scenario file

       /* } catch (FileNotFoundException e) {
            //file pas trouvé
        } catch (IOException e) {
            //file reading error

        */
        } catch (ArrayIndexOutOfBoundsException e){
            // pas de simulation file
        } finally {
           Logger.close();
        }

    }
}
