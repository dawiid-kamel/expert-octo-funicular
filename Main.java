import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input password");
        String password = scan.next();
        System.out.println(passwordStrength(password));
    }

    public static int passwordStrength(String password) {
        int score = 0;
        int chars = 0;
        int length = password.length();
        boolean upper = false;
        boolean lower = false;
        boolean number = false;
        boolean symbol = false;

        // Gives score for length
        if (length >= 8 && length <= 10) {
            score += 1;
            chars += 1;
        } else if (length >= 11 && length <= 15) {
            score += 2;
            chars += 2;
        } else if (length >= 16) {
            score += 3;
            chars += 3;
        }
        // Checks if password has certain parts using regex
        if (password.matches("(?=.*[a-z]).*")) {
            score++;
            lower = true;
        }
        if (password.matches("(?=.*[A-Z]).*")) {
            score++;
            upper = true;

        }
        if (password.matches("(?=.*[0-9]).*")) {
            score++;
            number = true;
        }
        if (password.matches("(?=.*[!@#$%^&*()]).*")) {
            score++;
            symbol = true;
        }
        if (chars == 1) {
            System.out.println("Consider making your password longer.");
        } else if (chars == 2) {
            System.out.println("Your password is strong but adding more characters would make it stronger.");
        } else {
            System.out.println("Please think of a new longer password");
        }
        if (!upper) {
            System.out.println("Please add uppercase to your password.");
        }
        if (!lower) {
            System.out.println("Please add lower case to your password.");
        }
        if (!number) {
            System.out.println("Please add numbers to your password.");
        }
        if (!symbol) {
            System.out.println("Please add symbols to your password.");
        }
        return score;
    }
}
