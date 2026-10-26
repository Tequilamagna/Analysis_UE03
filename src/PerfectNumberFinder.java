import java.util.HashSet;
import java.util.Set;

public class PerfectNumberFinder {
  public static void find() {
    long n = 1L;

    while(true) {
      boolean isPerfect = check(n);

      if(isPerfect) {
        System.out.printf("Number %d is perfect!%n", n);
      }

      if(isPerfect && n % 2 != 0) {
        System.out.printf("oddly perfect in fact...%n");
        return;
      }

      n++;
    }
  }

  private static boolean check(long n) {
    //divisors always occur in pairs. So only need to iter to sqrt(n)
    Set<Long> divisors = new HashSet<>(); //order does not matter here
    long div = 1;

    while(Math.powExact(div, 2) <= n) {
      if(n % div == 0) { // -> div | n
        divisors.add(div);
        divisors.add(n / div);
      }
      div++;
    }
    return (divisors.stream().mapToLong(x -> x).sum() / 2) == n;
  }
}
