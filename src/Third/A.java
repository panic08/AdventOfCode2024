package Third;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A {
    public static void main(String[] args) throws IOException {
        File file = new File("src/Third/input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;

        String regex = "mul\\((\\d+),(\\d+)\\)";

        Pattern pattern = Pattern.compile(regex);

        long sum = 0;
        while ((st = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(st);

            while (matcher.find()) {
                sum += Long.parseLong(matcher.group(1)) * Long.parseLong(matcher.group(2));
            }

        }
        System.out.println(sum);
    }
}
