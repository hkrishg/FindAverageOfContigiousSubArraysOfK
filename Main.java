import java.util.Arrays;

class Main {

  // Naive solution:

  // public static double[] findAverageOfSubArraysOfK(int k, int[] arr) {
  // for (int i = 0; i <= arr.length - k; i++) {
  // double sum = 0;
  // for (int j = i; j < i + k; j++) {
  // sum += arr[j];
  // result[i] = sum / k;
  // }
  // }
  // return result;
  // }

  // Sliding window

  public static double[] findAverageOfSubArraysOfK(int k, int[] arr) {
    double[] result = new double[arr.length - k + 1];
    int windowStart = 0;
    double windowSum = 0;
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      windowSum += arr[windowEnd];
      if (windowEnd >= k - 1) { // start sliding when index k-1
        result[windowStart] = windowSum / k;
        windowSum -= arr[windowStart]; // subtract element going out
        windowStart++; // slide window ahead
      }
    }
    return result;
  }

  public static void main(String[] args) {
    // Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
    double[] result = Main.findAverageOfSubArraysOfK(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
    System.out.println("----" + Arrays.toString(result));
  }
}