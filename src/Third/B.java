package Third;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B {
    public static void main(String[] args) throws IOException {
        File file = new File("src/Third/input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;

        long sum = 0;

        String regex = "mul\\((\\d+),(\\d+)\\)|don't|do";

        Pattern pattern = Pattern.compile(regex);

        boolean act = true;

        while ((st = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(st);

            while (matcher.find()) {
                if (matcher.group().equals("do")) {
                    act = true;
                } else if (matcher.group().equals("don't")) {
                    act = false;
                } else if (act) {
                    sum += Long.parseLong(matcher.group(1)) * Long.parseLong(matcher.group(2));
                }
            }
        }

        System.out.println(sum);
    }
}
