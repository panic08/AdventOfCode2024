package Second;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class B {
    public static void main(String[] args) throws IOException {
        File file = new File("src/Second/input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        int count = 0;

        String st;

        while ((st = br.readLine()) != null) {
            String[] inputs = st.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String input : inputs) {
                nums.add(Integer.parseInt(input));
            }

            if (checkDirection(nums, false) || checkDirection(nums, true)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean checkDirection(List<Integer> nums, boolean ascending) {
        for (int skip = -1; skip < nums.size(); skip++) {
            boolean isOk = true;

            int prev = -1;

            for (int i = 0; i < nums.size(); i++) {
                if (i == skip) continue;

                if (prev != -1) {
                    int diff = nums.get(i) - prev;

                    if (ascending && (diff < 1 || diff > 3)) {
                        isOk = false;
                        break;
                    } else if (!ascending && (diff > -1 || diff < -3)) {
                        isOk = false;
                        break;
                    }
                }

                prev = nums.get(i);
            }

            if (isOk) {
                return true;
            }
        }
        return false;
    }

}
