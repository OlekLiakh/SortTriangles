package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputParameters {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public InputParameters(){}

    public String readLine() {
        String enteredString = "";
        try {
            enteredString = bufferedReader.readLine();
        } catch (IOException ex) {
            System.out.println("Connection was interrupted");
            ex.printStackTrace();
        }
        return enteredString;
    }
}
