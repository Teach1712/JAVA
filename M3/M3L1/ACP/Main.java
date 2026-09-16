public class Main {
    public static void main(String[] args) {

        Digits d1 = new Digits(1729);
        System.out.println("Digits of 1729: " + d1); // [1, 7, 2, 9]

        Digits d2 = new Digits(0);
        System.out.println("Digits of 0: " + d2); // [0]

        Digits d3 = new Digits(421);
        System.out.println("Digits of 421: " + d3); // [4, 2, 1]
    }
}