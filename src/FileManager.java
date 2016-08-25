import java.io.File;

public class FileManager {


    public void createFile() {

    }

    public void deleteFile(String PathToFile){
        File file = new File(PathToFile);
        file.delete();
        System.out.println("deleted. or not?)");
    }

    public void renameFile() {

    }
    public void findWord(){

    }
    public void replaceWord() {

    }


}
