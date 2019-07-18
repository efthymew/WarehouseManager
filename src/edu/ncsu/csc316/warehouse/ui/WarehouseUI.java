package edu.ncsu.csc316.warehouse.ui;

import java.io.File;
import java.util.Scanner;
import edu.ncsu.csc316.warehouse.manager.WarehouseManager;

/**
 * ui class responsible for client interaction
 * @author Graham Efthymiou, Jin Gao
 *
 */
public class WarehouseUI {
    /** instance of ware house manager to be used */
    private WarehouseManager wm;
	/**
	 * main method
	 * @param args command line args
	 */
	public static void main(String[] args) {
		new WarehouseUI();
	}
	/**
	 * This is the constructor 
	 * for WarehouseUI
	 */
	public WarehouseUI() {
	    Scanner in = new Scanner(System.in);
	    System.out.println("Welcome to the Warehouse Manager");
	    System.out.print("Please enter file that contains route information: ");
	    String file = in.next();
	    while(!fileCheck(file)) {
	        System.out.print("File does not exist, please enter a new file: ");
            file = in.next();
	    }
	    wm = new WarehouseManager(file);
	    int choice = askForChoices(in);
	    while(choice != 3) {
	        if(choice == 1) {
	            System.out.printf("%s\n", wm.getMinimumRoutesReport());
	        } else if(choice == 2) {
	            System.out.print("Enter minimum number of associated routes: ");
	            int num = in.nextInt();
	            String ret = wm.getWarehouseCitiesReport(num);
	            if( ret.length() < 65 ) 
	                System.out.printf("No warehouse locations identified. \n");
	            else 
	                System.out.printf("%s\n", wm.getWarehouseCitiesReport(num));
	        } else {
	            System.out.print("Invalid choice.\n");
	        }
	        choice = askForChoices(in);
	    }
        System.out.println("GoodBye!!!");
	}
    /**
     * This method asks the users for choice of functions
     * once all the files are loaded
     * @param in scanner to be used
     * @return choice from user
     */
    private int askForChoices(Scanner in) {
        System.out.print("(1) Generate Minimum Routes to Connect Cities\n" 
                + "(2) Identify Potential Warehouse Cities\n" 
                + "(3) Quit Warehouse Manager\n" 
                + "Enter your choice: ");
        String choice = in.next();
        try {
            return Integer.parseInt(choice);
        } catch(NumberFormatException e) {
            return -1;
        }
    }
    /**
     * This method checks if the given file exists or not
     * @param file name of file to be checked
     * @return true if file exits false if file does not exist
     */
    private boolean fileCheck(String file) {
        File f = new File(file);
        return f.exists();
    }
}
