public class Main {
  static void main() {
    //------------------------------------------------------------------------------------------------------------------
    System.out.printf("==== Task 1 ====%n");
    System.out.printf("Approximating pi using Madhava-Leibniz%n");

    int n = 0;
    int step = 0;
    double precision;

    do{
      precision = Math.abs(Math.PI - PiApproximation.madhavaLeibnitz(n));

      if(step == 0 && precision < 1) {
        System.out.printf("f(%d) has precision < 10^0 (%.10f)%n", n, precision);
        step++;
      } if(step == 1 && precision < Math.pow(10, -3)) {
        System.out.printf("f(%d) has precision < 10^(-3) (%.10f)%n", n, precision);
        step++;
      } if(step == 2 && precision < Math.pow(10, -6)) {
        System.out.printf("f(%d) has precision < 10^(-6) (%.10f)%n", n, precision);
        step++;
      }

     n++;
    } while(step < 3);
    PiApproximation.reset();
    System.out.println("Approximating pi using Chudnovsky");

    n = 0;
    do{
      double pi = PiApproximation.chudnovsky(n);
      precision = Math.abs(Math.PI - pi);

      if(precision < Math.pow(10, -6)) {
        System.out.printf("f(%d) has precision < 10^(-6) (%.10f)%n", n, precision);
        step++;
      }

      n++;
    } while(step < 4);
    PiApproximation.reset();

    //------------------------------------------------------------------------------------------------------------------
    System.out.printf("==== Task 2 ====%n");

  }
}
