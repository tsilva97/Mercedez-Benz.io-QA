package actions;

import Exceptions.DataElementNotFound;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fetcher {

    private final String fileName;

    public Fetcher(String fileName) {
        this.fileName = fileName;
    }

    public String fetch(String searchFor) throws FileNotFoundException, DataElementNotFound {
        File file = new File(
                getClass().getClassLoader().getResource(this.fileName).getFile()
        );
        Scanner in = new Scanner(file);
        while (in.hasNext()) {
           String wordFromFile = in.nextLine();
            if (wordFromFile.equals(searchFor)) {
                return in.nextLine();
            }
        }
        throw new DataElementNotFound("Coudn't find " + searchFor + " in file " + this.fileName);
    }

}
