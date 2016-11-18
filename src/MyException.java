
class MyException extends Exception {
    //Parameterless Constructor
    public MyException() {
    }

    //Constructor that accepts a message
    public MyException(String message) {
        super(message);
    }
}
