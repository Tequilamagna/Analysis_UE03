public class Main {
  static void main() {
    System.out.println("Approximating pi ...");

    int n = 1;
    int step = 0;
    double precision;

    do{
      precision = Math.abs(Math.PI - PiApproximation.approximate(n));

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
  }
}
