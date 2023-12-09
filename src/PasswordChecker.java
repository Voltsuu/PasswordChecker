import java.util.Scanner;

public class PasswordChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        do {

            boolean testLength = false;
            boolean testUppercase = false;
            boolean testLowercase = false;
            boolean testNumber = false;
            boolean testSpecial = false;

            int points = 0;

            String password = InputHelper.getNonZeroLengthString(scan, "Please enter your password:");
            String checker;

            if (password.length() >= 12) {
                testLength = true;
                points++;
            }

            for (int i = 0; i < password.length(); i++) {
                checker = password.substring(i, i + 1);
                if (checker.matches("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]")) {
                    testUppercase = true;
                    points++;
                    break;
                }
            }

            for (int i = 0; i < password.length(); i++) {
                checker = password.substring(i, i + 1);
                if (checker.matches("[abcdefghijklmnopqrstuvwxyz]")) {
                    testLowercase = true;
                    points++;
                    break;
                }
            }

            for (int i = 0; i < password.length(); i++) {
                checker = password.substring(i, i + 1);
                if (checker.matches("[1234567890]")) {
                    testNumber = true;
                    points++;
                    break;
                }
            }

            for (int i = 0; i < password.length(); i++) {
                checker = password.substring(i, i + 1);
                if (checker.matches("[!@#$%^&*`~'.,/?;:=+<>]")) {
                    testSpecial = true;
                    points++;
                    break;
                }
            }
            System.out.println(" ");
            System.out.println("You earned " + points + "/5 points");

            if (points <= 2) {
                System.out.println("Your password is absolutely PUTRID. I'm going to steal your identity.");
            } else if (points == 3) {
                System.out.println("Your password is barely passable, do better haha.");
            } else {
                System.out.println("Your password is great! There are no immediate flaws.");
            }
            System.out.println(" ");

            if (!testLength) {
                System.out.println("Your password is not long enough.");
            }

            if (!testUppercase) {
                System.out.println("Your password does not contain an uppercase letter.");
            }

            if (!testLowercase) {
                System.out.println("Your password does not contain a lowercase letter.");
            }

            if (!testNumber) {
                System.out.println("Your password does not contain a number.");
            }

            if (!testSpecial) {
                System.out.println("Your password does not contain a special character.");
            }

            System.out.println(" ");

            boolean again = InputHelper.getYNConfirm(scan, "Would you like to check another password? [Y/N]");

            if (!again) {
                break;
            }

            System.out.println(" ");
        } while(true);
    }
}