import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {

    public String validationInput(String regexParttern) {
        String number ="0";
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!Pattern.matches(regexParttern,input)){
            if (!Pattern.matches(regexParttern, input)) {
                System.out.print("Invalid input! Please try again :");
                input = scanner.nextLine();

            }
            else {

                number=input;
                return number;
            }

        }
        number=input;
        return number;



    }

}
