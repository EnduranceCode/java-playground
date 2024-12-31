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

    // Prints the message in an infinite loop
    @SuppressWarnings({"squid:S2189", "squid:S106"})
    public void printMessageInfiniteLoop() {
        System.out.println(message);
        while (true) {
            System.out.println(message);
        }
    }

    public void printMessageAndThrowException() {
        System.out.println(message);

        int zero = 0;
        int one = 1;
        int exceptionResult = one / zero;
    }

    // Add "Hi!" to the message
    public String salutationMessage() {
        message = "Hi! " + message;
        System.out.println(message);
        return message;
    }
}
