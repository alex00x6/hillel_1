import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Use: type a specific path to file, for example d:/folder/file.txt");
        System.out.println("Select option by number, for example 1");
        System.out.println("Enjoy");

        while(true) {
            System.out.println("===================================================================");
            System.out.println("Please specify a path:");

            String inputPath = reader.readLine();


            if (inputPath != null) {
                System.out.println("1. Create file");
                System.out.println("2. Delete file");
                System.out.println("3. Rename file");
                System.out.println("4. Find word     - currently unavailable");
                System.out.println("5. Replace word  - currently unavailable");
                System.out.println("0. Exit");
            } else {
                System.out.println("Path input error.");
            }

            FileManager fileManager;
            fileManager = new FileManager();

            int inpCom = Integer.parseInt(reader.readLine());

            if (inpCom == 1 || inpCom == 2 || inpCom == 3 || inpCom == 4 || inpCom == 5 || inpCom == 0) {
                if (inpCom == 1) {
                    fileManager.createFile(inputPath);
                }
                if (inpCom == 2) {
                    fileManager.deleteFile(inputPath);
                }
                if (inpCom == 3) {
                    fileManager.renameFile(inputPath);
                }
                if (inpCom == 4) {
                    fileManager.findWord();
                }
                if (inpCom == 5) {
                    fileManager.replaceWord();
                }
                if (inpCom == 0) {
                    System.out.println("CYA!");
                    break;
                }
            } else {
                System.out.println("Error - wrong input");
            }
            System.out.println("===================================================================");
            System.out.println("Anything else?");
            System.out.println("1. Yes, please");
            System.out.println("0. No. Exit please.");

            int inpRestart = Integer.parseInt(reader.readLine());
            if (inpRestart == 1)
                System.out.println("Ok then.");
            if (inpRestart == 0) {
                System.out.println("Bye :(");
                break;
            }
            if (inpRestart != 1 && inpRestart != 0)
                System.out.println("Error - wrong input");
        }

    }

}
