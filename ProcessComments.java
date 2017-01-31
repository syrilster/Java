import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ssadasivan on 31-01-2017.
 */
public class ProcessComments {
    private static boolean continueFlag = false;
    private static String tempLine = "";
    public static void main(String ar[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        while(input != null) {
            process(input);
            input = br.readLine();
        }
    }

    private static void process(String line) {

        if (!continueFlag) {
            if (line.contains("//")) {
                int index = line.indexOf("//");
                if (index != -1) {
                    String output = line.substring(index, line.length());
                    output = output.trim();
                    if (output.length() != 0) {
                        System.out.println(output);
                    }

                }
            } else if (line.contains("/*") && line.contains("*/")) {
                int index = line.indexOf("/*");
                String output = line.substring(index, line.length());
                output = output.trim();
                if (output.length() != 0) {
                    System.out.println(output);
                }
            } else if (line.contains("/*")) {
                continueFlag = true;
                tempLine += line;
                tempLine += "\n";
            }
        } else {
            if (line.contains("*/")) {
                tempLine += line;
                continueFlag = false;
                System.out.println(tempLine);
                tempLine = "";
            } else {
                tempLine += line;
                tempLine += "\n";
            }
        }
    }
}
