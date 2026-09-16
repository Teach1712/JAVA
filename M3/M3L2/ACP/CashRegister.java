public class CashRegister {
    private double purchase;
    private double payment;
    private int itemCount; // added for (a)

    public CashRegister() {
        purchase = 0;
        payment = 0;
        itemCount = 0;
    }

    public void recordPurchase(double amount) {
        purchase += amount;
        itemCount++; // count each purchase
    }

    public void receivePayment(double amount) {
        payment += amount;
    }

    public double giveChange() {
        double change = payment - purchase;
        purchase = 0;
        payment = 0;
        itemCount = 0;
        return change;
    }

    // (a) instance method
    public int getItemCount() {
        return itemCount;
    }

    // (b) static method
    public static int countTotal(CashRegister[] registers) {
        int total = 0;
        for (CashRegister reg : registers) {
            if (reg != null) {
                total += reg.getItemCount();
            }
        }
        return total;
    }
}