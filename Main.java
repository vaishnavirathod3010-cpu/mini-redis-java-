import java.util.HashMap;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {

    HashMap<String, String> database = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Mini Redis Started!");
    System.out.println("Commands: SET, GET, DEL, EXIT");

    while (true) {
        System.out.print("redis> ");

        String input = scanner.nextLine();
        String[] parts = input.split("\\s+", 3);

        String command = parts[0].toUpperCase();

        if (command.equals("EXIT")) {
            System.out.println("Goodbye!");
            break;
        }

        if (command.equals("SET")) {
            if (parts.length < 3) {
                System.out.println("Usage: SET key value");
            } else {
                database.put(parts[1], parts[2]);
                System.out.println("OK");
            }
        }

        else if (command.equals("GET")) {
            if (parts.length < 2) {
                System.out.println("Usage: GET key");
            } else {
                String value = database.get(parts[1]);

                if (value == null) {
                    System.out.println("(nil)");
                } else {
                    System.out.println(value);
                }
            }
        }

        else if (command.equals("DEL")) {
            if (parts.length < 2) {
                System.out.println("Usage: DEL key");
            } else {
                String removed = database.remove(parts[1]);

                System.out.println(removed == null ? "0" : "1");
            }
        }

        else {
            System.out.println("Unknown command");
        }
    }

    scanner.close();
}

} 

     