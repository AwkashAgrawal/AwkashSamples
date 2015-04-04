package com.test.baggage.route;

public class Baggage {
	private String id;
	private Node sourceNode;
	private Node targetNode;
	private String flightId;
	
	public String getId() {
		return id;
	}

	public Node getSourceNode() {
		return sourceNode;
	}

	public Node getTargetNode() {
		return targetNode;
	}


	public String getFlightId() {
		return flightId;
	}


	public Baggage(String id, Node sourceNode,Node targetNode,String flightId) {
		super();
		this.id = id;
		this.sourceNode = sourceNode;
		this.targetNode = targetNode;
		this.flightId = flightId;
	}
	
	
	public boolean isArrival()
	{
		return flightId.equalsIgnoreCase("ARRIVAL");
	}

}
