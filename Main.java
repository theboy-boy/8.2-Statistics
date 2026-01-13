import static org.junit.Assume.assumeTrue;

import java.io.File; // Import the File class
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner; // Import this class to handle errors


class Main {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<>();
    File numFile = new File("numbers.txt");
    try (Scanner scan = new Scanner(numFile)){
        while (scan.hasNextLine()){
          numbers.add(scan.nextInt());
        }
    }catch (FileNotFoundException e){
      System.out.println("number file reading failed");
    }
    // call the average, standardDeviation, and mode methods and print their results
    System.out.println(average(numbers));
    System.out.println(mode(numbers));
    System.out.println(standardDeviation(numbers));
  }
  // implement the average method to calculate the average of the integers in the ArrayList
  public static double average(ArrayList<Integer> arr) {
    double totalNum = 0.0;
    for (int i = 0; i < arr.size(); i++){
      totalNum += arr.get(i);
    }
    return (totalNum/arr.size());
  }

  // implement the standardDeviation method to calculate the standard deviation of the integers in the ArrayList
  public static double standardDeviation(ArrayList<Integer> arr) {
    double averageOfNum=average(arr);
    double sum = 0;
    for (int i = 0; i < arr.size(); i++){
      sum +=Math.pow(arr.get(i) - averageOfNum, 2);
    }
    return Math.sqrt(sum/(arr.size()-1));
  }

  // implement the mode method to calculate the mode of the integers in the ArrayList
  public static int mode(ArrayList<Integer> arr) {
    int curentMode = 0;
    int curentcount = 0;
    int biggestMode = 0;
    int biggestcount = 0;
    for (int i = 0; i < 100; i++){
      for (int a = 0; a < arr.size(); a++){
        curentMode = i;
        if (arr.get(a) == curentMode){
          curentcount++;
        }
      }
      if (curentcount>biggestcount){
        biggestMode=curentMode;
        biggestcount=curentcount;
      }
      curentcount=0;
    }
    return biggestMode;
  }

}
