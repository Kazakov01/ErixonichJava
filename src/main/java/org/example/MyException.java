package org.example;

public class MyException extends RuntimeException{

    public MyException(String message) {
        super(message);
    }

    public MyException(Throwable cause){
        super(cause);
    }

    public MyException(String message, Throwable cause){
        super(message, cause);
    }
}
