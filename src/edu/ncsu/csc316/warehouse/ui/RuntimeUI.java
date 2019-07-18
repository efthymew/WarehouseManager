package edu.ncsu.csc316.warehouse.ui;

import edu.ncsu.csc316.warehouse.manager.WarehouseManager;

/**
 * ui for displaying runtimes
 * 
 * @author Graham Efthymiou
 *
 */
public class RuntimeUI {

    /**
     * main method
     * 
     * @param args
     *            command line args
     */
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        WarehouseManager m = new WarehouseManager("input/routes_dense_random_4.csv");
        long end1 = System.currentTimeMillis();
        System.out.println("dense \ngraph building runtime: " + (end1 - start1) + "ms");
        long start2 = System.currentTimeMillis();
        m.getWarehouseCitiesReport(2);
        long end2 = System.currentTimeMillis();
        System.out.println("(4)warehouse city report runtime: " + (end2 - start2) + "ms");

        start1 = System.currentTimeMillis();
        m = new WarehouseManager("input/routes_dense_random_8.csv");
        end1 = System.currentTimeMillis();
        System.out.println("graph building runtime: " + (end1 - start1) + "ms");
        start2 = System.currentTimeMillis();
        m.getWarehouseCitiesReport(2);
        end2 = System.currentTimeMillis();
        System.out.println("(8)warehouse city report runtime: " + (end2 - start2) + "ms");
        
        start1 = System.currentTimeMillis();
        m = new WarehouseManager("input/routes_dense_random_16.csv");
        end1 = System.currentTimeMillis();
        System.out.println("graph building runtime: " + (end1 - start1) + "ms");
        start2 = System.currentTimeMillis();
        m.getWarehouseCitiesReport(2);
        end2 = System.currentTimeMillis();
        System.out.println("(16)warehouse city report runtime: " + (end2 - start2) + "ms");
        
        start1 = System.currentTimeMillis();
        m = new WarehouseManager("input/routes_dense_random_32.csv");
        end1 = System.currentTimeMillis();
        System.out.println("graph building runtime: " + (end1 - start1) + "ms");
        start2 = System.currentTimeMillis();
        m.getWarehouseCitiesReport(2);
        end2 = System.currentTimeMillis();
        System.out.println("(32)warehouse city report runtime: " + (end2 - start2) + "ms");
        
        start1 = System.currentTimeMillis();
        m = new WarehouseManager("input/routes_dense_random_64.csv");
        end1 = System.currentTimeMillis();
        System.out.println("graph building runtime: " + (end1 - start1) + "ms");
        start2 = System.currentTimeMillis();
        m.getWarehouseCitiesReport(2);
        end2 = System.currentTimeMillis();
        System.out.println("(64)warehouse city report runtime: " + (end2 - start2) + "ms");
        
        start1 = System.currentTimeMillis();
        m = new WarehouseManager("input/routes_dense_random_128.csv");
        end1 = System.currentTimeMillis();
        System.out.println("graph building runtime: " + (end1 - start1) + "ms");
        start2 = System.currentTimeMillis();
        m.getWarehouseCitiesReport(2);
        end2 = System.currentTimeMillis();
        System.out.println("(128)warehouse city report runtime: " + (end2 - start2) + "ms");
        
        start1 = System.currentTimeMillis();
        m = new WarehouseManager("input/routes_dense_random_256.csv");
        end1 = System.currentTimeMillis();
        System.out.println("graph building runtime: " + (end1 - start1) + "ms");
        start2 = System.currentTimeMillis();
        m.getWarehouseCitiesReport(2);
        end2 = System.currentTimeMillis();
        System.out.println("(256)warehouse city report runtime: " + (end2 - start2) + "ms");
        
        start1 = System.currentTimeMillis();
        m = new WarehouseManager("input/routes_dense_random_512.csv");
        end1 = System.currentTimeMillis();
        System.out.println("graph building runtime: " + (end1 - start1) + "ms");
        start2 = System.currentTimeMillis();
        m.getWarehouseCitiesReport(2);
        end2 = System.currentTimeMillis();
        System.out.println("(512)warehouse city report runtime: " + (end2 - start2) + "ms");
        
        start1 = System.currentTimeMillis();
        m = new WarehouseManager("input/routes_dense_random_1024.csv");
        end1 = System.currentTimeMillis();
        System.out.println("graph building runtime: " + (end1 - start1) + "ms");
        start2 = System.currentTimeMillis();
        m.getWarehouseCitiesReport(2);
        end2 = System.currentTimeMillis();
        System.out.println("(1024)warehouse city report runtime: " + (end2 - start2) + "ms");

        // sparse now
        start1 = System.currentTimeMillis();
        m = new WarehouseManager("input/routes_sparse_random_4.csv");
        end1 = System.currentTimeMillis();
        System.out.println("sparse \ngraph building runtime: " + (end1 - start1) + "ms");
        start2 = System.currentTimeMillis();
        m.getWarehouseCitiesReport(2);
        end2 = System.currentTimeMillis();
        System.out.println("(4)warehouse city report runtime: " + (end2 - start2) + "ms");
        
        start1 = System.currentTimeMillis();
        m = new WarehouseManager("input/routes_sparse_random_8.csv");
        end1 = System.currentTimeMillis();
        System.out.println("graph building runtime: " + (end1 - start1) + "ms");
        start2 = System.currentTimeMillis();
        m.getWarehouseCitiesReport(2);
        end2 = System.currentTimeMillis();
        System.out.println("(8)warehouse city report runtime: " + (end2 - start2) + "ms");
        
        start1 = System.currentTimeMillis();
        m = new WarehouseManager("input/routes_sparse_random_16.csv");
        end1 = System.currentTimeMillis();
        System.out.println("graph building runtime: " + (end1 - start1) + "ms");
        start2 = System.currentTimeMillis();
        m.getWarehouseCitiesReport(2);
        end2 = System.currentTimeMillis();
        System.out.println("(16)warehouse city report runtime: " + (end2 - start2) + "ms");
        
        start1 = System.currentTimeMillis();
        m = new WarehouseManager("input/routes_sparse_random_32.csv");
        end1 = System.currentTimeMillis();
        System.out.println("graph building runtime: " + (end1 - start1) + "ms");
        start2 = System.currentTimeMillis();
        m.getWarehouseCitiesReport(2);
        end2 = System.currentTimeMillis();
        System.out.println("(32)warehouse city report runtime: " + (end2 - start2) + "ms");
        
        start1 = System.currentTimeMillis();
        m = new WarehouseManager("input/routes_sparse_random_64.csv");
        end1 = System.currentTimeMillis();
        System.out.println("graph building runtime: " + (end1 - start1) + "ms");
        start2 = System.currentTimeMillis();
        m.getWarehouseCitiesReport(2);
        end2 = System.currentTimeMillis();
        System.out.println("(64)warehouse city report runtime: " + (end2 - start2) + "ms");
        
        start1 = System.currentTimeMillis();
        m = new WarehouseManager("input/routes_sparse_random_128.csv");
        end1 = System.currentTimeMillis();
        System.out.println("graph building runtime: " + (end1 - start1) + "ms");
        start2 = System.currentTimeMillis();
        m.getWarehouseCitiesReport(2);
        end2 = System.currentTimeMillis();
        System.out.println("(128)warehouse city report runtime: " + (end2 - start2) + "ms");
        
        start1 = System.currentTimeMillis();
        m = new WarehouseManager("input/routes_sparse_random_256.csv");
        end1 = System.currentTimeMillis();
        System.out.println("graph building runtime: " + (end1 - start1) + "ms");
        start2 = System.currentTimeMillis();
        m.getWarehouseCitiesReport(2);
        end2 = System.currentTimeMillis();
        System.out.println("(256)warehouse city report runtime: " + (end2 - start2) + "ms");
        
        start1 = System.currentTimeMillis();
        m = new WarehouseManager("input/routes_sparse_random_512.csv");
        end1 = System.currentTimeMillis();
        System.out.println("graph building runtime: " + (end1 - start1) + "ms");
        start2 = System.currentTimeMillis();
        m.getWarehouseCitiesReport(2);
        end2 = System.currentTimeMillis();
        System.out.println("(512)warehouse city report runtime: " + (end2 - start2) + "ms");
        
        start1 = System.currentTimeMillis();
        m = new WarehouseManager("input/routes_sparse_random_1024.csv");
        end1 = System.currentTimeMillis();
        System.out.println("graph building runtime: " + (end1 - start1) + "ms");
        start2 = System.currentTimeMillis();
        m.getWarehouseCitiesReport(2);
        end2 = System.currentTimeMillis();
        System.out.println("(1024)warehouse city report runtime: " + (end2 - start2) + "ms");
    }
}
