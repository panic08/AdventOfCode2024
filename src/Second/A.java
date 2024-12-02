package Second;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class A {
    public static void main(String[] args) throws IOException {
        File file = new File("src/Second/input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;

        int count = 0;

        while ((st = br.readLine()) != null) {
            String[] inputs = st.split(" ");

            boolean isOk = true;

            List<Integer> nums = new ArrayList<>();

            for (int i = 0; i < inputs.length; i++) {
                nums.add(Integer.parseInt(inputs[i]));
            }

            for (int i = 1; i < nums.size(); i++) {
                if (nums.get(i) < nums.get(i - 1)) {
                    isOk = false;
                    break;
                }
                int dif = nums.get(i) - nums.get(i - 1);

                if (dif > 3 || dif < 1) {
                    isOk = false;
                    break;
                }
            }

            if (!isOk) {
                isOk = true;
                for (int i = 1; i < nums.size(); i++) {
                    if (nums.get(i - 1) < nums.get(i)) {
                        isOk = false;
                        break;
                    }

                    int dif = nums.get(i - 1) - nums.get(i);

                    if (dif > 3 || dif < 1) {
                        isOk = false;
                        break;
                    }
                }
            }

            if (isOk) {
                count++;
            }
        }
        System.out.println(count);
    }
}
