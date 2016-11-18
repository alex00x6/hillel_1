
import java.io.*;

class Readers {



    private static String reader()  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = null;
        try {
            answer = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Input error");
        }
        answer = answer.toLowerCase();

        return answer;
    }

    static String readAnswer(){
        String readAnswer = reader();
        System.out.println("===============================================");
        System.out.println("Answer is : " + readAnswer);
        return readAnswer;
    }

    static String readPath(){
        System.out.println("Please enter full path:");
        String path = reader();
        return path;
    }

    static String readNewName(){
        System.out.println("Please enter new file name:");
        String name = reader();
        return name;
    }

    static String readWord(){
        System.out.println("What word we are looking for?");
        String word = reader();
        return word;
    }

    static String readReplaceWord(){

        System.out.println("Replace word with ... ?");
        String replaceWord = reader();
        return replaceWord;
    }
}
