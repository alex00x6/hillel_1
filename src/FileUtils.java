

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileUtils {


    public void createFile(String fullPathToFile) {

        File file = new File(fullPathToFile);
        if(file.exists())
            System.out.println("Error: file already exists");
        else {
            System.out.println("No such file, creating...");
            try {
                file.createNewFile();
                System.out.println(file.getName() + " created successfully");
            } catch (IOException e) {
                System.out.println(e);
            }

        }
    }


    public void deleteFile(String fullPathToFile) {

        File file = new File(fullPathToFile);
        if(file.exists())
            System.out.println("File exists - OK");
        else
            try {
                throw new MyException("The source file doesn't exist");
            }
            catch (MyException e) {
                System.out.println(e);
            }
        if(file.delete())
            System.out.println(file.getName() + " deleted successfully");
        else
            try {
                throw new MyException("You don't have permissions?");
            } catch (MyException e) {
                System.out.println(e);
            }
    }


    public void renameFile(String fullPathToFile, String newFileName) {

        File file = new File(fullPathToFile);
        File newFile = new File(newFileName);

        if(file.exists() && !newFile.exists()) {
            System.out.println("File exists & new name isn't busy - OK");

            if (file.renameTo(newFile))
                System.out.println("Rename was successful");
            else
                System.out.println("Something went wrong...");
        }
        else {
            System.out.println("File doesn't exist or new name is busy - ERROR");
        }
    }


    public void findWordOccurrenceInFile(String fullPathToFile, String word) {

        int counter = 0;
        List<String> result = textToStringList(fullPathToFile);
        CharSequence[] charS = result.toArray(new CharSequence[result.size()]);
        Pattern pattern = Pattern.compile(word, Pattern.UNICODE_CASE|Pattern.CASE_INSENSITIVE);
        for(int i = 0; i < result.size(); i++) {
            Matcher match = pattern.matcher(charS[i]);
            while (match.find()) {
                counter++;
                System.out.println("Found on line: " + (i+1));
            }
        }
        System.out.println("Word: '" + word + "' was found " + counter + " times in the file " + fullPathToFile);
    }


    public void replaceWordInFile(String fullPathToFile, String word, String replaceWord) {

        Charset charset = CharsetDetector.Detector(fullPathToFile);
        Path path = Paths.get(fullPathToFile);
        try {
            Files.write(path, new String(Files.readAllBytes(path), charset)
                    .replace(word, replaceWord).getBytes(charset));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private List<String> textToStringList(String fullPathToFile){

        Charset charset = CharsetDetector.Detector(fullPathToFile);
        List<String> result = null;
        try {
            result = Files.lines(Paths.get(fullPathToFile), charset).collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e);
        }
        return result;
    }

    void openTextFile(String fullPathToFile){
        List<String> text = textToStringList(fullPathToFile);
        text.forEach(System.out::println);
    }

    String holiday(){
        Calendar calendar = Calendar.getInstance();
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String today = "Today is "+days[day_of_week-1];
        if (day_of_week == 6 || day_of_week == 7)
            today = today.toUpperCase()+"! You should have some fun tonight :)";
        else
            today = today+". Nothing unusual.";
        return today;
    }

    void getFilesInDirectory(String fullPathToFile){
        try {
            Files.list(Paths.get(fullPathToFile)).forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    System.out.println(filePath);
                }
            });
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    void getFilesInSubDir(String fullPathToFile){
        try {
            Files.walk(Paths.get(fullPathToFile)).forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    System.out.println(filePath);
                }
            });
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
