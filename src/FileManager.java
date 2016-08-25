import java.io.File;
import java.io.IOException;

public class FileManager {


    public void createFile(String PathToFile) throws IOException {
        File file = new File(PathToFile);
        if(file.exists())
            System.out.println("error: file already exists");
        else {
            System.out.println("no such file, creating");
            if (file.createNewFile())
                System.out.println("Done");
            else
                System.out.println("i'm not going to do that. ha ha. just kidding. ERROR");
        }
    }

    public void deleteFile(String PathToFile){
        File file = new File(PathToFile);
        if(file.exists())
            System.out.println("file exists - OK");
        else
            System.out.println("no such file");
        if(file.delete())
            System.out.println(file.getName() + " deleted");
        else
            System.out.println("ERROR ERROR PANIC");
    }

    public void renameFile() {

    }
    public void findWord(){

    }
    public void replaceWord() {

    }


}
