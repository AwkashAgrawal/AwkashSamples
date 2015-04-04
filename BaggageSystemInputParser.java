package com.test.baggage.route;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BaggageSystemInputParser {

	private Map<String, Node> baggageSystemGraph = new HashMap<String, Node>();
	
	private Map<String, Departure> flightIdToDepartureMap = new HashMap<String, Departure>();
	private List<Baggage> baggages = new LinkedList<Baggage>();
	
	
	public Map<String, Node> getBaggageSystemGraph() {
		return baggageSystemGraph;
	}

	
	public List<Baggage> getBaggages() {
		return baggages;
	}

	public void parseInput() throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(
"D:\\n1\\route\\src\\main\\java\\com\\test\\baggage\\route\\input.txt"));
		String lineInput;
		boolean conveyerSystem = false;
		boolean flightDetails = false;
		
		while ((lineInput = bufferedReader.readLine()) != null) {
			if (lineInput.contains("Section")) {
				if (isConveryerSystem(lineInput)) {
					conveyerSystem = true;
				} else if (isDeparture(lineInput)) {
					conveyerSystem = false;
					flightDetails = true;

				} else {
					flightDetails = false;
				}

				continue;
			} 
			else if(lineInput.isEmpty())
			{
				continue;
			}
			else {
				if (conveyerSystem) {
					String[] nodesAndWeight = lineInput.split(" ");
					Node sourceNode = baggageSystemGraph.get(nodesAndWeight[0]);
					Node targetNode = baggageSystemGraph.get(nodesAndWeight[1]);

					if (targetNode == null) {
						targetNode = new Node(nodesAndWeight[1]);
						baggageSystemGraph.put(nodesAndWeight[1], targetNode);
					}
					if (sourceNode == null) {
						sourceNode = new Node(nodesAndWeight[0]);
						baggageSystemGraph.put(nodesAndWeight[0], sourceNode);
					}

					Connection connection = new Connection(targetNode,
							new Double(nodesAndWeight[2]));
					sourceNode.addAdjacentNode(connection);
					
					Connection connection2 = new Connection(sourceNode,
							new Double(nodesAndWeight[2]));
					targetNode.addAdjacentNode(connection2);
					
				} else if (flightDetails) {
					String flightAndDepartureNode[] = lineInput.split(" ");

					flightIdToDepartureMap.put(
							flightAndDepartureNode[0],
							new Departure(flightAndDepartureNode[0],
									baggageSystemGraph.get(flightAndDepartureNode[1]),
									flightAndDepartureNode[2],
									flightAndDepartureNode[3]));
				}
				else
				{
					String baggageArray[] = lineInput.split(" ");
					
					Node targetNode = baggageArray[2].equalsIgnoreCase("ARRIVAL") ?
							baggageSystemGraph.get("BaggageClaim") :flightIdToDepartureMap.get(baggageArray[2]).getDepartureNode();
							
					Baggage baggageObject = new Baggage(baggageArray[0],
											baggageSystemGraph.get(baggageArray[1]), 
											targetNode,
											baggageArray[2]);
					baggages.add(baggageObject);
					
				}

			}

		}
		bufferedReader.close();
	}

	public boolean isConveryerSystem(String lineInput) {
		return lineInput.contains("Conveyor");
	}

	public boolean isDeparture(String lineInput) {
		return lineInput.contains("Departures");
	}

	public boolean isBags(String lineInput) {
		return lineInput.contains("Departures");
	}

}
