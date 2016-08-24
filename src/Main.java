import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        if(args.length > 0) {
            System.out.println("1. Create file");
            System.out.println("2. Delete file");
            System.out.println("3. Rename file");
            System.out.println("4. Find word");
            System.out.println("5. Replace word");
        }
        else{
            System.out.println("Error. No arguments.");
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputCommand = reader.readLine();

        if (inputCommand.equals("1") | inputCommand.equals("2") | inputCommand.equals("3") | inputCommand.equals("4") | inputCommand.equals("5")){
            if (inputCommand.equals("1")){
                FileManager.createFile();
            }
            if (inputCommand.equals("2")){
                FileManager.deleteFile();
            }
            if (inputCommand.equals("3")){
                FileManager.renameFile();
            }
            if (inputCommand.equals("4")){
                FileManager.findWord();
            }
            if (inputCommand.equals("5")){
                FileManager.replaceWord();
            }
        }
        else{
            System.out.println("Error. Wrong Input.");
        }


    }

}
