package CLI;

public class Messages {

    public static void welcome() {
        System.out.println("Welcome to the test automation tool");
    }

    public static void commandOptions() {
        System.out.println("Please choose the workflow to be tested:");
        System.out.println("0 -> Close the program");
        System.out.println("1 -> Chrome: Adds only one item to the shopping basket");
        System.out.println("2 -> Description: Adds two items to the shopping basket");
    }

    public static void browserOptions() {
        System.out.println("Please choose the browser to be tested");
        System.out.println("0 -> Close the program");
        System.out.println("1 -> Chrome");
        System.out.println("2 -> Firefox");
    }

    public static void tryAgain() {
        System.out.println("Invalid option");
    }

}
