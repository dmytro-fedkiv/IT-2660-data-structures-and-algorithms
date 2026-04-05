/*
 * IT-2660 - Lab 1
 * Student Name: Dmytro Fedkiv
 */

public class Main {
  public static void main(String[] args) {
    Lab1 lab = new Lab1();

    int[] nums = { 5, 9, 3, 12, 7, 3, 11, 5 };

    int i = 0;
    while (i < nums.length) {
      System.out.print(nums[i] + " ");
      i++;
    }

    System.out.println();

    for (int j = nums.length - 1; j >= 0; j--) {
      System.out.print(nums[j] + " ");
    }

    System.out.println();

    System.out.println("first " + nums[0]);
    System.out.println("last " + nums[nums.length - 1]);

    System.out.println("max(4, 9) " + lab.max(4, 9));
    System.out.println("min(4, 9) " + lab.min(4, 9));
    System.out.println("sum(nums) " + lab.sum(nums));
    System.out.println("average(nums) " + lab.average(nums));
    System.out.println("max(nums) " + lab.max(nums));
    System.out.println("min(nums) " + lab.min(nums));
  }
}

class Lab1 {
  public int max(int a, int b) {
    if (a > b) {
      return a;
    } else {
      return b;
    }
  }

  public int min(int a, int b) {
    if (a < b) {
      return a;
    } else {
      return b;
    }
  }

  public int sum(int[] nums) {
    int total = 0;

    for (int num : nums) {
      total += num;
    }

    return total;
  }

  public double average(int[] nums) {
    int total = this.sum(nums);

    return (double) total / nums.length;
  }

  public int max(int[] nums) {
    int currentMax = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > currentMax) {
        currentMax = nums[i];
      }
    }

    return currentMax;
  }

  public int min(int[] nums) {
    int currentMin = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < currentMin) {
        currentMin = nums[i];
      }
    }

    return currentMin;
  }
}
