package assesment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Stock {
    int itemNumber;      //instance variable,field
    String itemName;
    double price;
	
    
               //Stock: This is the name of the class that the constructor belongs to.
        public Stock(int itemNumber, String itemName, double price) {   //costructor,,,making stock object ,,,  the Stock constructor creates a new Stock object with the specified item number, name, and price
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.price = price;
	}

}



class StockManager  {
    ArrayList<Stock> stockList = new ArrayList<Stock>();  //list constist of object,Stock is a user-defined class that is being used to create a list of Stock objects.
    Scanner scanner = new Scanner(System.in);
//   Integer[] arr1 = new Integer[5];
    public void addItem() {
        System.out.print("Enter item number: ");
        int itemNumber = scanner.nextInt();

        System.out.print("Enter item name: ");
        String itemName = scanner.next();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
       

        stockList.add(new Stock(itemNumber, itemName, price));
        System.out.println("Item added successfully!");
    }

    public void searchItem() {
        System.out.print("Enter item number to search: ");
        int itemNumber1 = scanner.nextInt();

        for (Stock item : stockList) {  // means "iterate over the stockList collection which is instance of ArrayList<Stock>, assigning each element to the variable item, which will be of type Stock....item=refernce object of object Stock
            if (item.itemNumber==(itemNumber1)) {
                System.out.println("Item found:");
                System.out.println("Item number: " + item.itemNumber);
                System.out.println("Item name: " + item.itemName);
                System.out.println("Price: " + item.price);
                return;
            }
        }

        System.out.println("Item not found.");
    }

    public void modifyItem() {
        System.out.print("Enter item number to modify: ");
        int itemNumber1 = scanner.nextInt();

        for (Stock item : stockList) {
            if (item.itemNumber ==(itemNumber1)) {
                System.out.print("Enter new item name: ");
                String itemNewName = scanner.next();

                System.out.print("Enter new price: ");
                double priceNew = scanner.nextDouble();

                item.itemName = itemNewName;
                item.price = priceNew;
                System.out.println("Item modified successfully!");
                return;
            }
        }

        System.out.println("Item not found.");
    }

    public void deleteItem() {
        System.out.print("Enter item number to delete: ");
        int itemNumber1 = scanner.nextInt();

        for (Stock item : stockList) {
            if (item.itemNumber==(itemNumber1)) {
                stockList.remove(item);
                System.out.println("Item deleted successfully!");
                return;
            }
        }

        System.out.println("Item not found.");
    }

    public void sortItems() {
        Collections.sort(stockList, new Comparator<Stock>() {
            public int compare(Stock item1, Stock item2) {
                return Double.compare(item1.price, item2.price);
            }
        });

        System.out.println("Items sorted by price:");
        for (Stock item : stockList) {
            System.out.println("Item number: " + item.itemNumber);
            System.out.println("Item name: " + item.itemName);
            System.out.println("Price: " + item.price);
        }
    }
    
    public ArrayList<Stock> ShowList() {
    	return stockList;
    }

//    public class Main {
    	  public static void main(String[] args) {   // the main method in your program without the static modifier, the program gets compiled without compilation errors. But, at the time of execution JVM does not consider this new method (without static) as the entry point of the program.
    	      StockManager stockManager = new StockManager();
    	      Scanner scanner = new Scanner(System.in);

    	      while (true) {
    	          System.out.println("1. Add item");
    	          System.out.println("2. Search item");
    	          System.out.println("3. Modify item");
    	          System.out.println("4. Delete item");
    	          System.out.println("5. Sort items by price");
    	          System.out.println("6. All list of item");
    	          System.out.println("7. Exit");

    	          System.out.print("Enter choice: ");
    	          int choice = scanner.nextInt();
    	          scanner.nextLine();

    	            switch (choice) {
                    case 1:
                        stockManager.addItem();
                        break;

                    case 2:
                        stockManager.searchItem();
                        break;

                    case 3:
                        stockManager.modifyItem();
                        break;

                    case 4:
                        stockManager.deleteItem();
                        break;

                    case 5:
                        stockManager.sortItems();
                        break;
                        
                    case 6:
                    	stockManager.ShowList();
                    	

                    case 7:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice.");
                        break;
                }


            }
        }
    }

    	                  


