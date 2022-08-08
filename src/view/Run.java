package view;

import controller.ProductManager;
import model.Product;
import storage.ReadWriteFileBinary;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Run {
     static ReadWriteFileBinary readAndWrite = new ReadWriteFileBinary();
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        ProductManager productManager = new ProductManager();
        while (true) {
            System.out.println("---- PRODUCT MANAGING SYSTEM ----");
            System.out.println("CHOOSE A NUMBER TO CONTINUE");
            System.out.println("1: DISPLAY PRODUCT LIST");
            System.out.println("2: ADD NEW PRODUCT");
            System.out.println("3: EDIT PRODUCT");
            System.out.println("4: DELETE PRODUCT");
            System.out.println("5: SORT PRODUCT BY COST FROM LOW TO HIGH");
            System.out.println("6: FIND MOST EXPENSIVE PRODUCT");
            System.out.println("7: READ FILE");
            System.out.println("8: WRITE FILE");
            System.out.println("9: EXIT");
            System.out.println("CHOOSE AN OPTION: ");
            try {
                Scanner scanner = new Scanner(System.in);
                Scanner scanner1 = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        productManager.display();
                        break;
                    case 2:
                        try {
                            System.out.println("Enter ID of product: ");
                            String ID = scanner1.nextLine();
                            System.out.println("Enter name of the product: ");
                            String name = scanner1.nextLine();
                            System.out.println("Enter cost of the product: ");
                            Double cost = scanner.nextDouble();
                            System.out.println("Enter quantity of the product: ");
                            int quantity = scanner.nextInt();
                            System.out.println("Enter description of the product: ");
                            String description = scanner1.nextLine();
                            Product product = new Product(ID, name, description, cost, quantity);
                            productManager.add(product);
                        } catch (InputMismatchException e) {
                            System.out.println("Wrong input!");
                        }
                        break;
                    case 3:
                        try {
                            System.out.println("Enter ID of item: ");
                            String id = scanner.nextLine();
                            int test = productManager.checkID(id);
                            if (test == -1) {
                                System.out.println("Item doesn not exist!");
                            } else {
                                System.out.println("Enter ID of the product: ");
                                String ID = scanner1.nextLine();
                                System.out.println("Enter name of the product: ");
                                String name = scanner.nextLine();
                                System.out.println("Enter cost of the product: ");
                                Double cost = scanner1.nextDouble();
                                System.out.println("Enter quantity of the product: ");
                                int quantity = scanner.nextInt();
                                System.out.println("Enter description of the product: ");
                                String description = scanner1.nextLine();
                                Product product = new Product(ID, name, description, cost, quantity);
                                productManager.edit(test, product);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Wrong input!!");
                        }
                    case 4:
                        try {
                            System.out.println("Enter ID of item: ");
                            String id = scanner.nextLine();
                            int test = productManager.checkID(id);
                            if (test == -1) {
                                System.out.println("Item doesn not exist!");
                            } else {
                                productManager.delete(test);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Wrong input!");
                        }
                    case 5:
                        System.out.println("Enter 1 or 2: sort items and display: ");
                        System.out.println("Enter 3: Go back to main menu: ");
                        int option = scanner.nextInt();
                        switch (option) {
                            case 1, 2 -> {
                                productManager.sortByCostLowToHigh();
                                productManager.display();
                            }
                            case 3 -> menu();
                        }
                    case 6:
                        productManager.sortByCostLowToHigh();
                        List<Product> productsList = productManager.productList;
                        for (int i = 0; i < productsList.size(); i++) {
                            System.out.println(productsList.get(productsList.size()-1));
                        }
                        break;
                    case 7:
                        readAndWrite.writeData(productManager.productList,"data/Hiep.data");
                        break;
                    case 8:
                        readAndWrite.readData("data/Hiep.data");
                        break;
                    case 9:
                        System.err.println("Exit successfully!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error!");
                menu();
            }
        }
    }
}
