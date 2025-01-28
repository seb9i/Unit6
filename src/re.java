import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class re {

    public static String[] textToArray(String fileLocation){
        File f = new File(fileLocation);

        String fileData = "";
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String currentLine = s.nextLine();
                fileData += currentLine + "\n";
            }

            // a String array where every item in the array is a line from the file
            String[] fileArray = fileData.split("\n");
            return fileArray;
        }
        catch (FileNotFoundException fe) {
            System.out.println("File was not found");
            System.exit(1);
        }


        return new String[0];
    }
}
