// Importing
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This program uses binary search.
 *
 * @author  Adrijan Vranjkovic
 * @version 1.0
 * @since   2023-05-03
 */
public class RecBinSearch {

    /**
     * For the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private RecBinSearch() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main function.
     *
     * @param args Unused
     */
    public static void main(String[] args) {

        // Try statement.
        try {

            // Create input and output file.
            File inputFile = new File("input.txt");
            File outputFile = new File("output.txt");

            // Create scanner and writer
            Scanner scanner = new Scanner(inputFile);
            PrintWriter writer = new PrintWriter(outputFile);

            // Read each line of the input file.
            for (int count = 0; count < 10; count++) {
                
                // Split into strings.
                String[] numString = scanner.nextLine().split(" ");
                String[] searchNumString = scanner.nextLine().split(" ");

                // Fill the list and sort it.
                int[] listOfNum = new int[numString.length];
                int searchNum = Integer.parseInt(searchNumString[0]);

                // Convert the list array
                for (int index = 0; index < numString.length; index++) {
                    listOfNum[index] = Integer.parseInt(numString[index]);
                }

                // Sort the array
                Arrays.sort(listOfNum);

                int left = 0;
                int right = listOfNum.length - 1;

                // Call binary search function.
                try {
                    int result = RecBinSearch(listOfNum, searchNum, left, right);
                    writer.println(result);
                } catch (Exception e) {
                    // Handle any errors here
                    e.printStackTrace();
                }
            }

            // Close scanner and writer.
            scanner.close();
            writer.close();

        } catch (FileNotFoundException e) {
            // Display error.
            System.out.println("File not found!");
        }
    }


    /**
     * This function uses binary search recursively.
     *
     * @param listOfNum
     * @param searchNum
     * @param left
     * @param right
     * @return result
     */
    public static int RecBinSearch(int[] listOfNum, int searchNum, int left, int right) {

        // Set the mid value
        int mid = left + (right - left) / 2;

        // If the search num is = to the mid num return mid.
        if (listOfNum[mid] == searchNum) {
            return mid;

        // If searchNum is less than cut the array halfway.
        } else if (listOfNum[mid] > searchNum) {
            return RecBinSearch(listOfNum, searchNum, mid-1, left);
        
        // If searchNum is more than cut the array halfway.
        } else {
            return RecBinSearch(listOfNum, searchNum, mid+1, right);
        }
    }

}
