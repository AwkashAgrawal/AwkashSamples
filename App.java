package com.test.baggage.route;

import java.io.IOException;
import java.util.List;

/**
 * Djkstra algorithm is used to find out the shortest route
 */
public class App {

	public static void main(String[] args) {
		BaggageSystemInputParser baggageSystemInputParser = new BaggageSystemInputParser();
		try {
			baggageSystemInputParser.parseInput();
		} catch (IOException ioe) {
			System.out.println("Exception while parsing input file");
			ioe.printStackTrace();
		}

		/*
		 * Example Output:
		 * 
		 * 0001 Concourse_A_Ticketing A5 A1 : 11
		 * 
		 * 0002 A5 A1 A2 A3 A4 : 9
		 * 
		 * 0003 A2 A1 : 1
		 * 
		 * 0004 A8 A9 A10 A5 : 6
		 * 
		 * 0005 A7 A8 A9 A10 A5 BaggageClaim : 12
		 */

		List<Baggage> baggages = baggageSystemInputParser.getBaggages();

		for (Baggage baggage : baggages) {
			
			RouteFinder routeFinder = new ShortestBaggageRouteFinder(
					baggage.getSourceNode(), baggageSystemInputParser.getBaggageSystemGraph().values());

			List<Node> path = routeFinder.findRoute(baggage.getSourceNode(),
					baggage.getTargetNode());
			System.out.print(baggage.getId() + " "
					+ baggage.getSourceNode().getName());

			for (Node node : path) {
				System.out.print(node.getName() + ":");
			}
			System.out.print(path.get(path.size() - 1).getMinDistance());
			System.out.println("\r\n");
		}
	}
}
