public class PiApproximation {
  public static double approximate(int n) {
    double result = 0;

    for(int i = 0; i <= n; i++) {
      result = result + calc(i);
    }

    return 4 * result;
  }

  private static double calc(int i) {
    return (Math.pow(-1, i)) / (2 * i + 1);
  }
}
