import java.io.*;
import java.util.ArrayList;

/**
 * Finds the two numbers that sum up to 2020 in the report file
 */
class ReportRepair {
   private static final int EXPECTED_MAX_SIZE = 250;
   private static final int GOAL_SUM = 2020;


   private static File report;
   private static ArrayList<Integer> numbersInReport;
   private static int number1;
   private static int number2;
   private static int product;

   private static void initialise() {
      String projDirPath = System.getProperty("user.dir");
      report = new File(projDirPath + "/report.txt");
      numbersInReport = new ArrayList<>(EXPECTED_MAX_SIZE);
   }

   private static void readFile() throws IOException {
      BufferedReader br = new BufferedReader(new FileReader(report));
      String nextLine;

      while ((nextLine = br.readLine()) != null) {
         Integer num = Integer.parseInt(nextLine);
         numbersInReport.add(num);
      }
   }

   private static void locateTwoNumbers() {
      for (int num1 : numbersInReport) {
         for (int num2 : numbersInReport) {
            int sum = num1 + num2;

            if (sum == GOAL_SUM) {
               number1 = num1;
               number2 = num2;
               break;
            }
         }
      }
   }

   private static void calculateProduct() {
      product = number1 * number2;
   }
   
   public static void main(String[] args) throws IOException {
      initialise();
      readFile();
      locateTwoNumbers();
      calculateProduct();
      System.out.println("Product of " + number1 + " and " + number2 + " = " + product);
   }
}