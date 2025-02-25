import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {  // Changed class name to "Main" to match file name
    public static String checkStrength(String password) {
        int score = 0;

        if (password.length() >= 8) score++;
        if (password.length() >= 12) score++;
        if (Pattern.compile("[A-Z]").matcher(password).find()) score++;
        if (Pattern.compile("[a-z]").matcher(password).find()) score++;
        if (Pattern.compile("[0-9]").matcher(password).find()) score++;
        if (Pattern.compile("[!@#$%^&*()\\-_=+{};:,<.>]").matcher(password).find()) score++;

        switch (score) {
            case 6: return "🔒 Very Strong Password";
            case 4: case 5: return "✅ Strong Password";
            case 2: case 3: return "⚠️ Weak Password - Try adding numbers, symbols, or uppercase letters.";
            default: return "❌ Very Weak Password - Increase length and mix character types!";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password to check its strength:");
        String password = scanner.nextLine();

        String strength = checkStrength(password);
        System.out.println("Password Strength: " + strength);
        scanner.close();
    }
}
