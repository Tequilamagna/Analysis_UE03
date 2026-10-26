import java.util.stream.LongStream;

public class PiApproximation {
  static double lastAppr;
  static int lastN;

  public static double madhavaLeibnitz(int n) {

    while(lastN <= n) {
      lastAppr = lastAppr + calcML(lastN);
      lastN++;
    }


   return 4 * lastAppr;
  }

  public static double chudnovsky(int n) {

    while(lastN <= n) {
      lastAppr = lastAppr + calcCh(lastN);
      lastN++;
    }

    return 1 / (
            (Math.sqrt(10005) / 4270934400.0)
                    * lastAppr);
  }

  public static void reset() {
    lastAppr = 0;
    lastN = 0;
  }

  private static double calcML(int i) {
    return (Math.pow(-1, i)) / (2 * i + 1);
  }

  private static double calcCh(int i) {
    return (Math.pow(-1, i) * factorial(6 * i) * (545140134.0 * i + 13591409)) /
            (factorial(3 * i) * Math.pow(factorial(i), 3) * Math.pow(640320, 3 * i));
  }

  private static double factorial(int i) {
    return (double)
            LongStream.rangeClosed(1, i)
                    .reduce(1, (long a, long b) -> a * b);
  }
}
