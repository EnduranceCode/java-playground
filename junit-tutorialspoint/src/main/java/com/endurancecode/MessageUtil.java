package com.endurancecode;

/**
 * Tutorialspoint: Learn Junit
 * https://www.tutorialspoint.com/junit/
 */
public class MessageUtil {
    private String message;

    // Constructor
    // @param message to be printed
    public MessageUtil(String message){
        this.message = message;
    }

    // Prints the message
    public String printMessage(){
        System.out.println(message);
        return message;
    }

    // Add "Hi!" to the message
    public String salutationMessage() {
        message = "Hi! " + message;
        System.out.println(message);
        return message;
    }
}
