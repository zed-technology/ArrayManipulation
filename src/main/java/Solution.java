import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

        long maxValue = 0;
        long[] result = new long[n + 1];

        for (int i = 0; i < queries.length; i++) {


            //очевидое решение, но слишком долго :(
//            for (int j = queries[i][0]; j <= queries[i][1] ; j++) {
//                result[j-1] += queries[i][2];
//                if (result[j-1] > maxValue) {
//                    maxValue = result[j-1];
//                }
//            }

            //второй вариант (алгоритм подсмотрен в комментах)
            result[queries[i][0] - 1] += queries[i][2];
            result[queries[i][1]] += -queries[i][2];

        }

        long temp = 0;
        for (int i = 0; i < n+1; i++) {
            temp += result[i];
            if (temp > maxValue) maxValue = temp;
        }

        return maxValue;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
