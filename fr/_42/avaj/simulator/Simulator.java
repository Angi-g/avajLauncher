package fr._42.avaj.simulator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

public class Simulator {

    public static void main(String[] arg) throws InterruptedException {
        System.out.println("avaj launched !");
        try {

        } catch (FileNotFoundException e) {
            //file pas trouvé
        } catch (IOException e) {
            //file reading error
        } catch (ArrayIndexOutOfBoundsException e){
            // pas de simulation file
        } finally {
           // Logger.getLogger().close();
        }

    }
}
