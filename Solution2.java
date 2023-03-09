import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution2 {

    public static void main(String[] args) {

        Solution2 instance = new Solution2();
        try {
            instance.filterCSV("employees.csv");
        } catch (FileNotFoundException e) {
            System.out.println("File not Found!");
            e.printStackTrace();
        }
    }

    /**
     * Generates two csv files, "manager.csv" & "single_name_exmployees.csv"
     * @param csvFile Complete file name with extension
     * @throws FileNotFoundException
     */
    public void filterCSV(String csvFile) throws FileNotFoundException {

        String line = "";
        String splitSymbol = ",";

        List<String[]> manager = new ArrayList<>();
        List<String[]> singleNameEmployees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            int rowIndex = 0;

            while ((line = br.readLine()) != null) {

                String[] row = line.split(splitSymbol); 

                if (rowIndex == 0) {
                    manager.add(row);
                    singleNameEmployees.add(row);
                    ++rowIndex;
                    continue;
                }

                if (row[2].equals("R&D") && row[1].equals("Manager")) {
                    manager.add(row);
                }

                if (row[0].split(" ").length <= 1) {
                    singleNameEmployees.add(row);
                    System.out.println(convertToCSVRow(row));
                }

                ++rowIndex;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        File csvOutputFile1 = new File("manager.csv");
        File csvOutputFile2 = new File("single_name_exmployees.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile1)) {
            manager.stream()
            .map(this::convertToCSVRow)
            .forEach(pw::println);
        }
        try (PrintWriter pw = new PrintWriter(csvOutputFile2)) {
            singleNameEmployees.stream()
            .map(this::convertToCSVRow)
            .forEach(pw::println);
        }
    }

    public String convertToCSVRow(String[] data) {
        return Stream.of(data).collect(Collectors.joining(","));
    }

}