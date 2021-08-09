package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputParameters {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String getParameters() {
        String enteredString = "";
        try {
            enteredString = bufferedReader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return enteredString;
    }

}
