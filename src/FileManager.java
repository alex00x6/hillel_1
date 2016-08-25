import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileManager {


    public void createFile(String PathToFile) throws IOException {
        File file = new File(PathToFile);
        if(file.exists())
            System.out.println("error: file already exists");
        else {
            System.out.println("no such file, creating...");
            if (file.createNewFile())
                System.out.println("Done");
            else{
                System.out.println("You know what? I'm not going to do that.");
                System.out.println("Ha ha. Just kidding. ERROR");
            }
        }
    }

    public void deleteFile(String PathToFile){
        File file = new File(PathToFile);
        if(file.exists())
            System.out.println("file exists - OK");
        else
            System.out.println("file doesn't exist - ERROR");
        if(file.delete())
            System.out.println(file.getName() + " deleted successfully");
        else
            System.out.println("ERROR ERROR PANIC");
    }

    public void renameFile(String PathToFile) throws IOException {
        File file = new File(PathToFile);
        if(file.exists()) {
            System.out.println("file exists - OK");
            System.out.println("Please enter new name for this file (with a full path, of course)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String newName = br.readLine();
            File newfile = new File(newName);
            if (file.renameTo(newfile))
                System.out.println("rename successful");
            else
                System.out.println("something went wrong...");
        }
        else
            System.out.println("file doesn't exist - ERROR");

    }
    public void findWord(){

    }
    public void replaceWord() {

    }


}
