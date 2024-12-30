/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author user
 */
import java.util.Scanner;

/**
 *
 * @author yuanb
 */
public class SijitsuIceCreamStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean main = true;

        while (main) {

            System.out.println("Welcome to Sijitsu's Ice Cream Store!");
            Scanner enter = new Scanner(System.in);
            System.out.println("Do you want to shop?");
            String trap = enter.next();
            String code;
            boolean check = false;
            double totalcost = 0.00;
            String rer = "";

            while (trap.equalsIgnoreCase("yes")) {

                System.out.println("Please select a product:");
                System.out.println("Input the number for the Product Code.");
                System.out.println("Item                       \t\tCost   \t\tCode");
                System.out.println("-------------------------------------------------");
                System.out.println("1. Chocolate              \t\t$1.50  \t\t1");
                System.out.println("2. Vanilla                \t\t$1.90  \t\t2");
                System.out.println("3. Bubblegum              \t\t$2.10  \t\t3");
                System.out.println("4. Strawberry             \t\t$2.00  \t\t4");
                System.out.println("5. Mango                  \t\t$2.50  \t\t5");

                int select = enter.nextInt();
                double price = 0;
                String productName = "";

                switch (select) {
                    case 1:
                        price = 1.50;
                        productName = "Chocolate";
                        check = true;
                        break;
                    case 2:
                        price = 1.90;
                        productName = "Vanilla";
                        check = true;
                        break;
                    case 3:
                        price = 2.10;
                        productName = "Bubblegum";
                        check = true;
                        break;
                    case 4:
                        price = 2.00;
                        productName = "Strawberry";
                        check = true;
                        break;
                    case 5:
                        price = 2.50;
                        productName = "Mango";
                        check = true;
                        break;
                    case 6:
                        price = 2.70;
                        productName = "Cookies and Cream";
                        check = true;
                        break;
                }
                if (check) {
                    System.out.println("You selected " + productName + " for $ " + price + "\nEnter quantity:");
                    double quantity = enter.nextDouble();
                    double subtotal = price * quantity;
                    totalcost += subtotal;
                    rer += productName + "\t" + quantity + "\t$ " + price + "\n";
                    System.out.println("Subtotal: " + quantity + " * $ " + price + " = $ " + subtotal);

                    // Ask if user wants to order another item
                    System.out.println("Do you want to order another item? (yes/no)");
                    trap = enter.next(); // update trap for the loop condition
                }
                if (trap.equalsIgnoreCase("no")) {
                    System.out.println("You selected \n" + rer);
                    System.out.println("Total: $ " + totalcost);
                    System.out.println("Do you have a voucher? Please input in the system. Otherwise, input 'no'.");
                    code = enter.next();
                    if (code.equalsIgnoreCase("SirJamieUnoLang")) {
                        double discount = totalcost * 0.15;
                        totalcost -= discount;
                        System.out.println("You selected \n" + rer);
                        System.out.println("Discount: $ " + discount + "\nTotal: $ " + totalcost);
                    }
                    // Ask user to enter the payment amount
                    double payment;
                    do {
                        System.out.println("Please enter the amount of money to pay: ");
                        payment = enter.nextDouble();
                        // Check if payment is sufficient
                        if (payment < totalcost) {
                            System.out.println("Insufficient funds. You need at least $ " + (totalcost - payment) + " more.");
                        } else {
                            double change = payment - totalcost;
                            System.out.println("Payment accepted. Your change is $ " + change + "\nThank you for shopping with us!");
                        }
                    } while (payment < totalcost);
                    System.out.println("-------------------------------------------------");
                }
            }
        }
    }
}