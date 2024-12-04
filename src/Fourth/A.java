package Fourth;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) throws IOException {
        File file = new File("src/Fourth/input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;

        List<List<Character>> matrix = new ArrayList<>();

        List<Character> cur;
        while ((st = br.readLine()) != null) {
            cur = new ArrayList<>();

            for (char c : st.toCharArray()) {
                cur.add(c);
            }

            matrix.add(cur);
        }

        int[][] directions = {{-1,0}, {-1, 1},{0, 1}, {1, 1 }, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

        int count = 0;
        for (int r = 0; r < matrix.size(); r++) {
            for (int c = 0; c < matrix.getFirst().size(); c++) {
                if (matrix.get(r).get(c) != 'X') continue;
                for (int[] direction : directions) {
                    int newRow = r + direction[0];
                    int newCol = c + direction[1];

                    int i = 1;

                    char[] xmas = { 'X', 'M', 'A', 'S' };

                    while (gridCheck(newRow, newCol, matrix) && i < xmas.length && matrix.get(newRow).get(newCol) == xmas[i]) {
                        newRow += direction[0];
                        newCol += direction[1];
                        i++;
                    }
                    count += i == 4 ? 1 : 0;
                }
            }
        }

        System.out.println(count);
    }

    private static boolean gridCheck(int row, int col, List<List<Character>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.getFirst().size();
    }
}
