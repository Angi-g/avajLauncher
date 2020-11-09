package fr._42.avaj.simulator;

import fr._42.avaj.simulator.vehicles.AircraftFactory;
import fr._42.avaj.simulator.vehicles.Flyable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulator {

    public static void main(String[] arg) throws InvalideArgumentException {
        System.out.println("avaj launched !");
        int nbOfSimulation;
        List<Flyable> aircraftList = new ArrayList<>();
        WeatherTower weatherTower = new WeatherTower();

        if(arg.length > 1) {
            throw new InvalideArgumentException("To many arguments, only the path " +
                    "of the scenario file is needed :)");
        }
        if(arg.length < 1) {
            throw new InvalideArgumentException("Oops, you forgot to provide " +
                    "the path of the scenario file in arguments ! :(");
        }

        File scenarioFile = new File(arg[0]);

        try {
            Logger logger = new Logger();

            //parse scenario file
            nbOfSimulation = parseScenarioFile(aircraftList, scenarioFile);
            // register aircrafts
            aircraftList.forEach(a -> a.registerTower(weatherTower));

            //run simulation with the number in the scenario file
            for (int i = 0; i < nbOfSimulation; i++ ) {
                weatherTower.changeWeather();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Sorry, the file " + arg[0] + " does not exist or you have misspelled it :(");
        } catch (NumberFormatException e) {
            throw new InvalideArgumentException("Oops, the number of simulation asked is invalid " +
                    "-> It must be a positive integer number");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Ouch, I can't log anything, an error occurred with the simulation file");
        } finally {
           Logger.close();
        }

    }

    /**
     * Parse the scenarioFile, fill the aircraft list and return the number of simulation asked in the file
     * @param aircraftList the aircraftList to fill
     * @param scenarioFile the scenarioFile to parse
     * @return the number of simulation asked
     */
    private static int parseScenarioFile(List<Flyable> aircraftList, File scenarioFile) throws FileNotFoundException, InvalideArgumentException {
        int nbOfSimulation;
        Scanner scenarioReader = new Scanner(scenarioFile);
        AircraftFactory aircraftFactory = new AircraftFactory();

        if (scenarioFile.length() == 0) {
            throw new InvalideArgumentException("Oops, the scenario file " + scenarioFile.getName() + " is empty, " +
                    "please try with an valid file ! :(");
        }
        String firstLine = scenarioReader.nextLine();
        nbOfSimulation =  Integer.parseInt(firstLine);
        if (nbOfSimulation <= 0) {
            throw new InvalideArgumentException("Oops, the number of simulation asked is invalid : " + firstLine
                    + "\n -> It must be a positive integer number");
        }
        while (scenarioReader.hasNextLine()) {
            String nextLine = scenarioReader.nextLine();
            String[] newAircraft = nextLine.split(" ");
            if (newAircraft.length != 5) {
                throw new InvalideArgumentException("Oops, an aircraft is not properly describe in the scenario file.\n" +
                        "The aircraft causing the error is : " + nextLine +
                        "\nIt must be in this form : \n" +
                        "[TYPE] [NAME] [LONGITUDE] [LATITUDE] [HEIGHT]\n" +
                        "For exemple :\n" +
                        "Helicopter H1 5 20 15");
            }
            // create aircraft with aircraft factory
            try {
                aircraftList.add(aircraftFactory.newAircraft(newAircraft[0], newAircraft[1], Integer.parseInt(newAircraft[2]),
                        Integer.parseInt(newAircraft[3]), Integer.parseInt(newAircraft[4])));
            } catch (NumberFormatException e) {
                throw new InvalideArgumentException("Oops, your coordinates are wrong, it must be an Integer !");
            }
        }
        if (aircraftList.isEmpty()) {
            throw new InvalideArgumentException("Oops, it seems there was no aircraft in your scenario file, " +
                    "please try again with a valid file");
        }
        return nbOfSimulation;
    }
}
