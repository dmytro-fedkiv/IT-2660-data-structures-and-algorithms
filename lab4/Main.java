import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    System.out.println("Unsorted Array ---------------------------------------------------");
    ArrayList<Integer> integerList = Lab4.getList();
    Lab4.outputList(integerList);

    System.out.println("\n\nBubble sort results ----------------------------------------------");

    long bubbleSortStart = System.nanoTime();
    ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);
    long bubbleSortEnd = System.nanoTime();

    System.out.println("\nBubble sort time: " + (bubbleSortEnd - bubbleSortStart) + "ns");
    Lab4.outputList(bubbleSortedList);

    System.out.println("\n\nInsertion sort results -------------------------------------------");

    long insertionSortStart = System.nanoTime();
    ArrayList<Integer> insertionSortedList = Lab4.insertionSort(integerList);
    long insertionSortEnd = System.nanoTime();

    System.out.println("\nInsertion sort time: " + (insertionSortEnd - insertionSortStart) + "ns");
    Lab4.outputList(insertionSortedList);
  }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    // Step 1 - Implement insertion sort algorithm here

    for (int i = 1; i < integerList.size(); i++) {
      int number = integerList.get(i);

      int j = i - 1;

      for (; j >= 0 && integerList.get(j) > number; j--) {
        integerList.set(j + 1, integerList.get(j));
      }

      integerList.set(j + 1, number);
    }

    return integerList;
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
    // Step 2 - Implement the bubble sort algorithm here

    for (int i = 0; i < integerList.size() - 1; i++) {
      for (int j = 0; j < integerList.size() - 1 - i; j++) {
        if (integerList.get(j) > integerList.get(j + 1)) {
          int temporary = integerList.get(j);
          integerList.set(j, integerList.get(j + 1));
          integerList.set(j + 1, temporary);
        }
      }
    }

    return integerList;
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
      while ((line = br.readLine()) != null) {
        integerList.add(Integer.parseInt(line));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (int i = 0; i < integerList.size(); i++) {
      System.out.print(integerList.get(i) + " ");
    }
  }
}