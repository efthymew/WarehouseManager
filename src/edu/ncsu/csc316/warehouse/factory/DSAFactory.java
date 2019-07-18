package edu.ncsu.csc316.warehouse.factory;

import edu.ncsu.csc316.dsa.Weighted;
import edu.ncsu.csc316.dsa.graph.AdjacencyMapGraph;
import edu.ncsu.csc316.dsa.graph.Graph;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap;
import edu.ncsu.csc316.dsa.sorter.MergeSorter;
import edu.ncsu.csc316.dsa.sorter.Sorter;

/**
 * Factory for creating new data structure and algorithm instances
 * 
 * @author Dr. King
 *
 */
public class DSAFactory {

	/**
	 * Returns a data structure that implements an hash map
	 * 
	 * @param <K> - the key type
	 * @param <V> - the value type
	 * @return a data structure that implements an unordered map
	 */
	public static <K, V> Map<K, V> getMap() {
		return getLinearProbingHashMap();
	}

	/**
	 * returns a data structure that implements a graph
	 * 
	 * @param <V> vertex type
	 * @param <E> edge type
	 * @return graph
	 */
	public static <V, E extends Weighted> Graph<V, E> getGraph() {
		return getAdjacencyMapGraph();
	}

	/**
	 * Returns a comparison based sorter
	 * 
	 * @param <E> - the element type
	 * @return a comparison based sorter
	 */
	public static <E extends Comparable<E>> Sorter<E> getComparisonSorter() {
		return getMergeSorter();
	}

	/**
	 * returns a hash map using linear probing
	 * 
	 * @return linear probing hash map
	 */
	private static <K, V> LinearProbingHashMap<K, V> getLinearProbingHashMap() {
		return new LinearProbingHashMap<K, V>();
	}

	/**
	 * Returns a mergesorter
	 * 
	 * @return a mergesorter
	 */
	private static <E extends Comparable<E>> Sorter<E> getMergeSorter() {
		return new MergeSorter<E>();
	}

	/**
	 * returns adjacency map graph instance
	 * 
	 * @return adjacency map graph
	 */
	private static <V, E extends Weighted> AdjacencyMapGraph<V, E> getAdjacencyMapGraph() {
		return new AdjacencyMapGraph<V, E>();
	}
}
