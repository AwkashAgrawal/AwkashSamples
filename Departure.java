package com.test.baggage.route;

public class Departure {
	
	public String flightId;
	public Node departureNode;
	public String destination;
	public String time;
	
	public Departure(String flightId, Node departureNode, String destination,
			String time) {
		super();
		this.flightId = flightId;
		this.departureNode = departureNode;
		this.destination = destination;
		this.time = time;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public Node getDepartureNode() {
		return departureNode;
	}
	public void setDepartureNode(Node departureNode) {
		this.departureNode = departureNode;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	
}
