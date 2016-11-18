


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class FileUtilsTest {

    private String pathToFile = "d:/code/test.txt";
    private String pathToNewFile = "d:/code/test2.txt";
    private String pathNoPermissions = "c:/norights.txt";
    private String pathToTextFile = "d:/code/textTest.txt";

    @BeforeTest
    public void setUp() throws IOException {
        out.println("Подготовка к тесту findWord");
        File fileText = new File(pathToTextFile);
        if(!fileText.exists())
        fileText.createNewFile();
        String text = "Привет, как дела, как погода, зачем я здесь, что происходит?";
        PrintWriter out = new PrintWriter(fileText.getAbsoluteFile());
        out.print(text);
        out.close();

    }

    @Test(groups = {"fileManager"})
    public void createFile() {
        out.println("=========create file - positive=========");

        File file = new File(pathToFile);
        out.println("File exist: " + file.exists());

        FileUtils fileUtils = new FileUtils();
        fileUtils.createFile(pathToFile);

        assertTrue(file.exists());


    }

    @Test(groups = {"fileManager"})
    public void renameFile() throws IOException {
        out.println("=========rename file - positive=========");
        File file = new File(pathToFile);
        File file2 = new File(pathToNewFile);
        FileUtils fileUtils = new FileUtils();
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file2.exists()){
            file2.delete();
        }

        fileUtils.renameFile(pathToFile, pathToNewFile);

        assertFalse(file.exists());
        assertTrue(file2.exists());


    }

    @Test(groups = {"fileManager"})
    public void deleteFile() throws IOException {
        out.println("=========delete file - positive=========");
        File file = new File(pathToFile);
        out.println("File exist: " + file.exists());
        FileUtils fileUtils = new FileUtils();
        if (!file.exists()){
        file.createNewFile();
        }

        fileUtils.deleteFile(pathToFile);

        assertFalse(file.exists());
    }

    @Test(groups = {"fileManager"})//, expectedExceptions = {MyException.class})
    public void createFileNegative1() throws IOException {
        out.println("===create file - negative - file already exists===");
        File file = new File(pathToFile);
        out.println("File exist: " + file.exists());
        file.createNewFile();

        out.println("File exist: " + file.exists());

        FileUtils fileUtils = new FileUtils();
        fileUtils.createFile(pathToFile);

        //TODO - тест всегда будет пройден? если нет assert? как это реализовать то правильно?
        assertTrue(file.exists());
    }


    @Test(groups = {"fileManager"})
    public void createFileNegative2() throws IOException {
        out.println("===create file - negative - no rights in directory===");
        File file = new File(pathNoPermissions);
        out.println("File exist: " + file.exists());

        FileUtils fileUtils = new FileUtils();
        fileUtils.createFile(pathNoPermissions);


        //TODO как запустить проверку в этом случае?

        //assertTrue(file.exists());
    }

    @Test(groups = {"fileManager"})
    public void deleteFileNegative1() throws IOException, MyException {
        out.println("===delete file - negative - no file to delete===");
        File file = new File(pathToFile);
        out.println("File exist: " + file.exists());
        FileUtils fileUtils = new FileUtils();
        if(!file.exists())
        fileUtils.deleteFile(pathToFile);

    }

    @Test(groups = {"fileManager"})
    public void deleteFileNegative2() throws IOException {

        //NOT DONE YET

        out.println("===delete file - negative - no rights in directory===");
        File file = new File(pathNoPermissions);
        out.println("File exist: " + file.exists());
        FileUtils fileUtils = new FileUtils();
        //file.createNewFile();
        fileUtils.deleteFile(pathNoPermissions);

        //assertFalse(file.exists());
    }

    @Test(groups = {"fileManager"})
    public void renameFileNegative1(){
        out.println("===rename file - negative - no file to rename===");
        FileUtils fileUtils = new FileUtils();
        File file = new File(pathToFile);

        if(!file.exists())
            fileUtils.renameFile(pathToFile, pathToNewFile);
        else {
            file.delete();
            fileUtils.renameFile(pathToFile, pathToNewFile);
        }

    }

    @Test(groups = {"fileManager"})
    public void renameFileNegative2() throws IOException {
        out.println("===rename file - negative - new name is busy===");
        FileUtils fileUtils = new FileUtils();
        File file = new File(pathToFile);
        File newFile = new File(pathToNewFile);

        if (!file.exists()) {
            out.println("file doesn't exists");
            file.createNewFile();
        }
        if (!newFile.exists()){
            out.println("new file doesn't exists");
            newFile.createNewFile();
        }
        if (file.exists() && newFile.exists()){
            out.println("both files existing, trying to make some badass shit...");
            fileUtils.renameFile(pathToFile, pathToNewFile);
        }
        else{
            out.println("WTF IS GOING ON? TEST ERROR");
        }

    }

    @Test(groups = {"fileManager"})
    public void findWordPositive() throws IOException {
        out.println("===========find word - positive===========");
        File file = new File(pathToTextFile);
        FileUtils fileUtils = new FileUtils();
        String word = "как";

        file.createNewFile();
        fileUtils.findWordOccurrenceInFile(pathToTextFile, word);


    }

    @Test(groups = {"fileManager"})
    public void findWordNegative1() throws IOException {
        out.println("===find word - negative - no word in file===");
        File file = new File(pathToTextFile);
        FileUtils fileUtils = new FileUtils();
        String word = "pussy";

        file.createNewFile();
        fileUtils.findWordOccurrenceInFile(pathToTextFile, word);


    }

    @AfterTest
    public void tearDown() {

        out.println("==================AfterTest==================");

        File file = new File(pathToFile);
        File file2 = new File(pathToNewFile);
        File fileText = new File(pathToTextFile);

        if(file.exists()) {
            file.delete();
            out.println(file+" deleted");
        }
        if (file2.exists()) {
            file2.delete();
            out.println(file2+" deleted");
        }
        if (fileText.exists()) {
            fileText.delete();
            out.println(fileText+" deleted");
        }

    }
}