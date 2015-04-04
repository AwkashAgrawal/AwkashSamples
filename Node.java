package com.test.baggage.route;

import java.util.ArrayList;
import java.util.List;


public class Node implements Comparable<Node>{

	private final String name;
	private List<Connection> adjacencies;
	private double minDistance = Double.POSITIVE_INFINITY;
	private Node previous;

	public Node(String argName) {
		name = argName;
		adjacencies = new ArrayList<Connection>();
	}

	public String toString() {
		return name;
	}
	
	public void addAdjacentNode(Connection connection)
	{
		adjacencies.add(connection);
	}
	
	public List<Connection> getAdjacencies() {
		return adjacencies;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public double getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public String getName() {
		return name;
	}

	public int compareTo(Node other) {
		return Double.compare(minDistance, other.minDistance);
	}
	
}
