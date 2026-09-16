public class Main {
    public static void main(String[] args) {
        // Test (a)
        CashRegister reg1 = new CashRegister();
        reg1.recordPurchase(10.50);
        reg1.recordPurchase(5.25);
        
        System.out.println("reg1 item count: " + reg1.getItemCount()); // should be 2

        // Test (b)
        CashRegister reg2 = new CashRegister();
        reg2.recordPurchase(20.00);
        reg2.recordPurchase(30.00);
        reg2.recordPurchase(15.00);

        CashRegister[] allRegisters = { reg1, reg2 };
        
        int total = CashRegister.countTotal(allRegisters);
        System.out.println("Total items across all registers: " + total); // should be 5
    }
}