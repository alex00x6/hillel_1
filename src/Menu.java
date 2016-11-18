



public class Menu {

    public void runMenu() {
        FileUtils fileUtils = new FileUtils();

        System.out.println("You currently running "+System.getProperty("os.name")+" x"
                +System.getProperty("sun.arch.data.model"));
        System.out.println(fileUtils.holiday());

        while(true) {
            printMenu();
            String answer = Readers.readAnswer();
            boolean again = true;
            while(again) {
                switch (answer) {
                    case "1":
                    case "create":
                    case "create file":
                        System.out.println("==================Create file==================");
                        fileUtils.createFile(Readers.readPath());
                        break;

                    case "2":
                    case "delete":
                    case "delete file":
                        System.out.println("==================Delete file==================");
                        fileUtils.deleteFile(Readers.readPath());
                        break;

                    case "3":
                    case "rename":
                    case "rename file":
                        System.out.println("==================Rename file==================");
                        fileUtils.renameFile(Readers.readPath(), Readers.readNewName());
                        break;

                    case "4":
                    case "find":
                    case "find word in file":
                        System.out.println("===============Find word in file===============");
                        fileUtils.findWordOccurrenceInFile(Readers.readPath(), Readers.readWord());
                        break;

                    case "5":
                    case "replace":
                    case "replace word in file":
                        System.out.println("==============Replace word in file==============");
                        fileUtils.replaceWordInFile(Readers.readPath(), Readers.readWord(), Readers.readReplaceWord());
                        break;


                    case "6":
                    case "open":
                    case "open text":
                        System.out.println("================Open text file=================");
                        fileUtils.openTextFile(Readers.readPath());
                        break;


                    case "7":
                    case "detect":
                    case "charset":
                        System.out.println("==========Detect charset of the file===========");
                        CharsetDetector.Detector(Readers.readPath());
                        break;

                    case "8":
                        fileUtils.getFilesInDirectory(Readers.readPath());
                        break;

                    case "9":
                        fileUtils.getFilesInSubDir(Readers.readPath());
                        break;

                    case "0":
                    case "exit":
                        System.out.println("Goodbye :(");
                        again = false;
                        System.exit(0);
                        break;

                }

                doItAgain();
                switch (Readers.readAnswer()) {
                    case "1":
                    case "y":
                    case "yes":
                        break;
                    case "0":
                    case "n":
                    case "no":
                        again = false;
                        break;
                    }

            }
        }
    }

    /**
     * метод, коtорый выводит список меню в консоль
     */

    private void printMenu() {
        System.out.println("===============================================");
        System.out.println("1. Create file");
        System.out.println("2. Delete file");
        System.out.println("3. Rename file");
        System.out.println("4. Find word in file");
        System.out.println("5. Replace word in file");
        System.out.println("6. Open text file");
        System.out.println("7. Detect charset of the file");
        System.out.println("8. Get all files in directory");
        System.out.println("9. Get all files in dir and sub dirs.");
        System.out.println("0. Exit");
    }

    private void doItAgain(){
        System.out.println("===============================================");
        System.out.println("Do it again?");
        System.out.println("1. Yes");
        System.out.println("0. No");
    }


}
