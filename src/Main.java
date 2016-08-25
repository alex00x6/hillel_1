import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Hello. Please specify a path.");

        String inputPath = reader.readLine();


        if(inputPath != null) {
            System.out.println("1. Create file");
            System.out.println("2. Delete file");
            System.out.println("3. Rename file");
            System.out.println("4. Find word");
            System.out.println("5. Replace word");
        }
        else{
            System.out.println("Parameter input error.");
        }

        FileManager fileManager;
        fileManager = new FileManager();

        String inputCommand = reader.readLine();

        if (inputCommand.equals("1") | inputCommand.equals("2") | inputCommand.equals("3") | inputCommand.equals("4") | inputCommand.equals("5")){
            if (inputCommand.equals("1")){
                fileManager.createFile();
            }
            if (inputCommand.equals("2")){
                fileManager.deleteFile("d:/code/shit.txt");
           }
            if (inputCommand.equals("3")){
                fileManager.renameFile();
            }
            if (inputCommand.equals("4")){
                fileManager.findWord();
            }
           if (inputCommand.equals("5")){
                fileManager.replaceWord();
            }
        }
        else{
            System.out.println("Error. Wrong Input.");
        }


    }

}
