
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author jesse.hu
 * @date 2022/2/8 16:44
 */
public class Input2Methods  {
    // Method 1
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        input.close();
        System.out.println(s);
    }
    // Method 2
    private static class InputMethod1 {
        public static void main(String[] args) throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String s = input.readLine();
            System.out.println(s);
        }
    }
}
