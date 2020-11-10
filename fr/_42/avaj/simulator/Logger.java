package fr._42.avaj.simulator;

import fr._42.avaj.simulator.vehicles.Aircraft;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    File simulationFile;
    static BufferedWriter bufferedWriter;
    Logger () {
        try {
            simulationFile = new File("simulation.txt");
            if (!simulationFile.createNewFile()) {
                System.out.println("The simulation file already exist, it will be overwritten");
                //simulationFile.delete(); ?
            }

            bufferedWriter = new BufferedWriter(new FileWriter(simulationFile, false));
        } catch (IOException e) {
            System.out.println("An error occur during the creation of the simulation file");
        }
    }

    public static void writeLine(String identity, String message) {
        try {
            bufferedWriter.write(identity + ": " + message);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("An error occur while writing in simulation.txt, the simulator will exit prematurely :(");
            close();
            System.exit(1);
        }
    }

    public static void close() {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("An error occur while closing simulation.txt");
        }
    }
}
