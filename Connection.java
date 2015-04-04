package com.test.baggage.route;

public class Connection {
	private final Node target;
	private final double weight;
	
	
	public Node getTarget() {
		return target;
	}


	public double getWeight() {
		return weight;
	}


	public Connection(Node argTarget, double argWeight) {
		target = argTarget;
		weight = argWeight;
	}
}
