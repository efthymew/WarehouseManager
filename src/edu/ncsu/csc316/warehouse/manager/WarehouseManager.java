package edu.ncsu.csc316.warehouse.manager;

import edu.ncsu.csc316.dsa.graph.Graph;
import edu.ncsu.csc316.dsa.graph.MinimumSpanningTreeUtil;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.Map.Entry;
import edu.ncsu.csc316.dsa.sorter.Sorter;
import edu.ncsu.csc316.warehouse.data.Route;
import edu.ncsu.csc316.warehouse.factory.DSAFactory;
import edu.ncsu.csc316.warehouse.io.InputFileReader;

/**
 * warehouse manager class with methods for generating minimum routes and
 * warehouse cities
 * 
 * @author Graham Efthymiou, Jin Gao
 *
 */
public class WarehouseManager {

	/** graph */
	private Graph<String, Route> graph;

	/**
	 * instantiates manager given path to route file csv
	 * 
	 * @param pathToRouteFile path to file
	 */
	public WarehouseManager(String pathToRouteFile) {
		graph = buildGraph(InputFileReader.readRouteInput(pathToRouteFile));
	}

	// You might consider implementing this private helper method
	/**
	 * builds graph using list of routes
	 * 
	 * @param routes list of routes
	 * @return graph of cities and routes
	 */
	private Graph<String, Route> buildGraph(List<Route> routes) {
		// initialize graph
		Graph<String, Route> g = DSAFactory.getGraph();
		// map to get vertices of strings (cities in routes)
		// in case route is added with pre-existing vertices in graph
		Map<String, Vertex<String>> vertexMap = DSAFactory.getMap();
		for (Route e : routes) {
			Vertex<String> v1 = null;
			Vertex<String> v2 = null;
			// check if already vertices in map
			if (vertexMap.get(e.getCity1()) == null) {
				// insert it in graph
				v1 = g.insertVertex(e.getCity1());
				// then to map
				vertexMap.put(e.getCity1(), v1);
			} else {
				// get existing vertex
				v1 = vertexMap.get(e.getCity1());
			}
			// same for second city in a route
			if (vertexMap.get(e.getCity2()) == null) {
				v2 = g.insertVertex(e.getCity2());
				vertexMap.put(e.getCity2(), v2);
			} else {
				v2 = vertexMap.get(e.getCity2());
			}
			g.insertEdge(v1, v2, e);
		}
		return g;

	}

//    // You might consider implementing this private helper method
//    private Graph<String,Route> buildGraph(PositionalList<Edge<Route>> routes) {
//        // TODO your code here
//    }

	/**
	 * Returns a string representation of the minimum route summary report (See UC2)
	 * 
	 * @return the string representation of the minimum route summary report
	 */
	public String getMinimumRoutesReport() {
		// get list of min edges
		PositionalList<Edge<Route>> mst = MinimumSpanningTreeUtil.kruskal(graph);
		MinRouteArrayEntry[] minRoutes = new MinRouteArrayEntry[mst.size()];
		// for every route in mst add to array to sort
		int count = 0;
		for (Edge<Route> e : mst) {
			minRoutes[count] = new MinRouteArrayEntry(e.getElement().getCity1(), e.getElement().getCity2(),
					e.getElement().getDistance());
			count++;
		}
		// sort routes **had to make new object tried sorting just routes, but are
		// sorted
		// ascending by distance, so made new obj to sort correctly
		Sorter<MinRouteArrayEntry> s = DSAFactory.getComparisonSorter();
		s.sort(minRoutes);

		StringBuilder minRouteReport = new StringBuilder();
		minRouteReport.append("Minimum Routes [\n");
		for (int i = 0; i < minRoutes.length; i++) {
			MinRouteArrayEntry r = minRoutes[i];
			minRouteReport
					.append(String.format("   %s - %s (%d miles)\n", r.getCity1(), r.getCity2(), r.getDistance()));
		}
		minRouteReport.append("]\n");
		return minRouteReport.toString();
	}

	/**
	 * Returns a string representation of the warehouse report (See UC3)
	 * 
	 * @param minRoutes the minimum number of routes associated with a city
	 * @return the string representation of the warehouse report
	 */
	public String getWarehouseCitiesReport(int minRoutes) {
		PositionalList<Edge<Route>> mst = MinimumSpanningTreeUtil.kruskal(graph);
		WarehouseCityArrayEntry[] whCities = new WarehouseCityArrayEntry[graph.numVertices()];

		/* algorithm 1 */
		
//		// go through vertices checking their appearances on edges in the mst and add
//		// them to the array
//		int size = 0;
//		for (Vertex<String> v : graph.vertices()) {
//			int numRoutes = 0;
//			// see if vertex is present on routes at all
//			for (Edge<Route> e : mst) {
//				if (e.getElement().getCity1().equals(v.getElement())
//						|| e.getElement().getCity2().equals(v.getElement())) {
//					numRoutes++;
//				}
//			}
//			whCities[size] = new WarehouseCityArrayEntry(v.getElement(), numRoutes);
//			size++;
//		}
		
		/* algorithm 2 */
		
//		Graph<String, Route> newGraph = DSAFactory.getGraph();
//		// map to get vertices of strings (cities in routes)
//		Map<String, Vertex<String>> vertexMap = DSAFactory.getMap();
//		for (Edge<Route> e : mst) {
//			Vertex<String> v1 = null;
//			Vertex<String> v2 = null;
//			String c1N = e.getElement().getCity1();
//			String c2N = e.getElement().getCity2();
//			if (vertexMap.get(c1N) == null) {
//				v1 = newGraph.insertVertex(c1N);
//				vertexMap.put(c1N, v1);
//			} else {
//				v1 = vertexMap.get(c1N);
//			} if (vertexMap.get(c2N) == null) {
//				v2 = newGraph.insertVertex(c2N);
//				vertexMap.put(c2N, v2);
//			} else {
//				v2 = vertexMap.get(c2N);
//			}
//			newGraph.insertEdge(v1, v2, e.getElement());
//			
//		}
//		int size = 0;
//		for (Vertex<String> v : newGraph.vertices()) {
//			whCities[size] = new WarehouseCityArrayEntry(v.getElement(), newGraph.outDegree(v));
//			size++;
//		}
		
		/* algorithm 3 */
		
		// map vertex name to num routes
		Map<String, Integer> numRoutes = DSAFactory.getMap();
		for (Edge<Route> e : mst) {
			String v1 = e.getElement().getCity1();
			String v2 = e.getElement().getCity2();
			if (numRoutes.get(v1) == null) {
				numRoutes.put(v1, 1);
			} else {
				// increment for every appearance in edge
				numRoutes.put(v1, numRoutes.get(v1) + 1);
			}
			if (numRoutes.get(v2) == null) {
				numRoutes.put(v2, 1);
			} else {
				// increment for every appearance in edge
				numRoutes.put(v2, numRoutes.get(v2) + 1);
			}
		}
		
		int size = 0;
		for (Entry<String, Integer> city : numRoutes.entrySet()) {
			whCities[size] = new WarehouseCityArrayEntry(city.getKey(), city.getValue());
			size++;
		}

		// sort it as desired
		Sorter<WarehouseCityArrayEntry> s = DSAFactory.getComparisonSorter();
		s.sort(whCities);

		// string build and print if their routes are greater or equal to the param
		StringBuilder warehouseReport = new StringBuilder();
		warehouseReport
				.append(String.format("Potential Warehouse Sites with at least %d associated routes [\n", minRoutes));
		for (int i = 0; i < whCities.length; i++) {
			WarehouseCityArrayEntry city = whCities[i];
			if (city.getNumRoutes() >= minRoutes) {
				warehouseReport
						.append(String.format("   %s with %d routes\n", city.getCityName(), city.getNumRoutes()));
			}
		}
		warehouseReport.append("]\n");
		return warehouseReport.toString();
	}

	/**
	 * array entry used for compareTo when sorting min route report
	 * 
	 * @author Graham Efthymiou
	 *
	 */
	private static class MinRouteArrayEntry implements Comparable<MinRouteArrayEntry> {

		/** city 1 */
		private String city1;
		/** city 2 */
		private String city2;
		/** distance b/w two */
		private int distance;

		/**
		 * returns city 1
		 * 
		 * @return the city1
		 */
		public String getCity1() {
			return city1;
		}

		/**
		 * returns distance
		 * 
		 * @return distance
		 */
		public int getDistance() {
			return distance;
		}

		/**
		 * sets distance
		 * 
		 * @param distance new distance
		 */
		public void setDistance(int distance) {
			this.distance = distance;
		}

		/**
		 * sets city1
		 * 
		 * @param city1 the city1 to set
		 */
		public void setCity1(String city1) {
			this.city1 = city1;
		}

		/**
		 * returns city2
		 * 
		 * @return the city2
		 */
		public String getCity2() {
			return city2;
		}

		/**
		 * sets city2
		 * 
		 * @param city2 the city2 to set
		 */
		public void setCity2(String city2) {
			this.city2 = city2;
		}

		/**
		 * instantiates entry
		 * 
		 * @param city1 city1
		 * @param city2 city2
		 * @param dist  distance
		 */
		public MinRouteArrayEntry(String city1, String city2, int dist) {
			setCity1(city1);
			setCity2(city2);
			setDistance(dist);
		}

		@Override
		public int compareTo(MinRouteArrayEntry array2) {
			if (getCity1().compareTo(array2.getCity1()) != 0) {
				return getCity1().compareTo(array2.getCity1());
			} else {
				return getCity2().compareTo(array2.getCity2());
			}
		}

	}

	/**
	 * array entry used for compareTo when sorting warehouse city report
	 * 
	 * @author Graham Efthymiou
	 *
	 */
	private static class WarehouseCityArrayEntry implements Comparable<WarehouseCityArrayEntry> {

		/** num routes */
		private int numRoutes;
		/** city name */
		private String cityName;

		/**
		 * instantiates entry
		 * 
		 * @param name      name
		 * @param numRoutes number of routes
		 */
		public WarehouseCityArrayEntry(String name, int numRoutes) {
			setCityName(name);
			setNumRoutes(numRoutes);
		}

		/**
		 * gets num routes
		 * 
		 * @return the numRoutes
		 */
		public int getNumRoutes() {
			return numRoutes;
		}

		/**
		 * sets num routes
		 * 
		 * @param numRoutes the numRoutes to set
		 */
		public void setNumRoutes(int numRoutes) {
			this.numRoutes = numRoutes;
		}

		/**
		 * returns city name
		 * 
		 * @return the cityName
		 */
		public String getCityName() {
			return cityName;
		}

		/**
		 * sets city name
		 * 
		 * @param cityName the cityName to set
		 */
		public void setCityName(String cityName) {
			this.cityName = cityName;
		}

		@Override
		public int compareTo(WarehouseCityArrayEntry array2) {
			if (getNumRoutes() < array2.getNumRoutes()) {
				return 1;
			} else if (getNumRoutes() > array2.getNumRoutes()) {
				return -1;
			} else {
				return getCityName().compareTo(array2.getCityName());
			}
		}

	}
}
