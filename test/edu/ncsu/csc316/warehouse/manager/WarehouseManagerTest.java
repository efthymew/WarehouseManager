package edu.ncsu.csc316.warehouse.manager;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * tests warehouse manager behavior
 * 
 * @author Graham Efthymiou
 *
 */
public class WarehouseManagerTest {

	/** tests manager */
	@Test
	public void test() {
		WarehouseManager manager = new WarehouseManager("input/sample.csv");
		//System.out.println(manager.getMinimumRoutesReport());
		String minRouteString = "Minimum Routes [\n"
				+ "   Asheville - Charlotte (131 miles)\n"
				+ "   Charlotte - Winston Salem (83 miles)\n"
				+ "   Durham - Raleigh (24 miles)\n"
				+ "   Fayetteville - Rocky Mount (94 miles)\n"
				+ "   Fayetteville - Wilmington (93 miles)\n"
				+ "   Greenville - Rocky Mount (42 miles)\n"
				+ "   Raleigh - Wilmington (129 miles)\n"
				+ "   Raleigh - Winston Salem (103 miles)\n"
				+ "]\n";
		assertEquals(manager.getMinimumRoutesReport(), minRouteString);
		
		//System.out.print(manager.getWarehouseCitiesReport(1));
		String warehouseCityString = "Potential Warehouse Sites with at least 2 associated routes [\n"
				+ "   Raleigh with 3 routes\n"
				+ "   Charlotte with 2 routes\n"
				+ "   Fayetteville with 2 routes\n"
				+ "   Rocky Mount with 2 routes\n"
				+ "   Wilmington with 2 routes\n"
				+ "   Winston Salem with 2 routes\n"
				+ "]\n";
		assertEquals(warehouseCityString, manager.getWarehouseCitiesReport(2));
	}

}
