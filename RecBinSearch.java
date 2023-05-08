// Importing
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
* The program uses binary search to find a num.
*
* @author  Adrijan Vranjkovic
* @version 1.0
* @since   2023-05-03
*/

public final class RecBinSearch {
    /**
    * For style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private RecBinSearch() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Print messages.
    *
    * @param args Unused
    */
    public static void main(String[] args) {

        // Create list
        final ArrayList<String> inputList = new ArrayList<String>();
        String indexStr = "";

        // Try Statement.
        try {

            // Create the input file.
            final File input = new File("input.txt");
            final Scanner scanInput = new Scanner(input);

            // Create the output file.
            final FileWriter output = new FileWriter("output.txt");

            // Loop through each line of the file
            while (scanInput.hasNextLine()) {
                inputList.add(scanInput.nextLine());
            }

            // Create array
            final String[] inputArr = new String[inputList.size()];

            // Add the list elements to the array.
            for (int location = 0; location < inputArr.length; location++) {
                inputArr[location] = inputList.get(location);
            }

            // Send the input piece by piece to the function
            for (int counter = 0; counter < inputArr.length; counter += 2) {

                // Split the string.
                final int[] arrOfInt =
                    new int[inputArr[counter].split(" ").length];
                for (int place = 0;
                    place < inputArr[counter].split(" ").length; place++) {
                    arrOfInt[place] = Integer.parseInt(
                        inputArr[counter].split(" ")[place]);
                }

                // Sort the array
                Arrays.sort(arrOfInt);

                // Parse to int
                final int intSearch = Integer.parseInt(inputArr[counter + 1]);

                // Call function to find the search num in the array.
                final int index = recBinSearch(arrOfInt, intSearch,
                    0, arrOfInt.length - 1);
                indexStr = indexStr + index + "\n";
            }

            // Write to output file.
            output.write(indexStr);

            // Close output
            output.close();

        } catch (IOException err) {
            // Display error
            System.err.println("Error: " + err.getMessage());
        }
    }

    /**
    * This function uses binary search recursively.
    *
    * @param listOfNum *
    * @param searchNum *
    * @param left *
    * @param right *
    * @return result
    */
    public static int recBinSearch(int[] listOfNum, int searchNum,
        int left, int right) {

        // If left > right, the element is not in the array
        if (left > right) {
            return -1;
        }

        // Set the mid value
        final int mid = left + (right - left) / 2;

        // If the search num is equal to the mid num return mid.
        if (listOfNum[mid] == searchNum) {
            return mid;

            // If searchNum is less than cut the array halfway.
        } else if (listOfNum[mid] > searchNum) {
            return recBinSearch(listOfNum, searchNum, left, mid - 1);

            // If searchNum is more than cut the array halfway.
        } else {
            return recBinSearch(listOfNum, searchNum, mid + 1, right);
        }
    }

}
