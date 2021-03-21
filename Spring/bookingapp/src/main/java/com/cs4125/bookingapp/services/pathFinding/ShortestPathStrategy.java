package com.cs4125.bookingapp.services.pathFinding;

import com.cs4125.bookingapp.model.entities.Connection;
import com.cs4125.bookingapp.model.entities.Route;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.PriorityQueue;

@Service
public class ShortestPathStrategy implements Strategy {

    @Override
    public List<Route> findPath(String startNode, String endNode, List<Connection> connections) {

        ArrayList<Vertex> vertices = new ArrayList<>();
        ArrayList<String> stationsAdded = new ArrayList<>();

        stationsAdded.add(startNode);
        stationsAdded.add(endNode);

        Vertex start = new Vertex(startNode);
        Vertex end = new Vertex(endNode);
        vertices.add(start);
        vertices.add(end);

        for (Connection c : connections) {

            if (!stationsAdded.contains(c.getStationOne())) {
                stationsAdded.add(c.getStationOne());
                vertices.add(new Vertex(c.getStationOne()));
            }
            if (!stationsAdded.contains(c.getStationTwo())) {
                stationsAdded.add(c.getStationTwo());
                vertices.add(new Vertex(c.getStationTwo()));
            }

        }

        for (Connection c : connections) {

            for (Vertex v : vertices) {
                if (v.getName().equals(c.getStationOne())) {
                    for (Vertex ver : vertices) {
                        if (ver.getName().equals(c.getStationTwo())) {
                            v.addNeighbour(new Edge(c.getDistance(), v, ver));
                        }
                    }
                } else if (v.getName().equals(c.getStationTwo())) {
                    for (Vertex ver : vertices) {
                        if (ver.getName().equals(c.getStationOne())) {
                            v.addNeighbour(new Edge(c.getDistance(), v, ver));
                        }
                    }
                }
            }

        }

        DijkstraShortestPath shortestPath = new DijkstraShortestPath();
        shortestPath.computeShortestPaths(start);

//        String mess =  vertices.get(vertices.indexOf(start)).getName() + " " + vertices.get(vertices.indexOf(end)).getName() + " " ;
//        mess += vertices.get(0).getName() + " " + vertices.get(2).getName() + " " + vertices.get(2).getDistance();

        List<Route> result = new ArrayList<>();
        String connectionPath = shortestPath.getShortestPathTo(end).toString();
        connectionPath = connectionPath.replaceAll("\\[", "").replaceAll("\\]", "");
        connectionPath = connectionPath.replaceAll("\\s+", "");
        if (connectionPath.equals(endNode)) {
            return result;
        } else {

            String[] temp = connectionPath.split(",");
            String res = "";

            for (int i = 0; i < temp.length - 1; i++) {
                for (Connection c : connections) {
                    if (c.getStationOne().equals(temp[i]) && c.getStationTwo().equals(temp[i + 1])) {
                        res += c.getConnectionId() + "&";
                    } else if (c.getStationTwo().equals(temp[i]) && c.getStationOne().equals(temp[i + 1])) {
                        res += c.getConnectionId() + "&";
                    }
                }
            }

            if (res.charAt(res.length() - 1) == '&') {
                res = res.substring(0, res.length() - 1);
            }

//      String result = "Shortest Path from " + startNode + " to " + endNode + ": " + shortestPath.getShortestPathTo(end);
            result.add(new Route(startNode, endNode, res));
//        return result;
            return result;
        }
    }
}


class Vertex implements Comparable<Vertex> {

    private String name;
    private List<Edge> adjacenciesList;
    private boolean visited;
    private Vertex predecessor;
    private double distance = Double.MAX_VALUE;

    public Vertex(String name) {
        this.name = name;
        this.adjacenciesList = new ArrayList<>();
    }

    public void addNeighbour(Edge edge) {
        this.adjacenciesList.add(edge);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getAdjacenciesList() {
        return adjacenciesList;
    }

    public void setAdjacenciesList(List<Edge> adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.distance, otherVertex.getDistance());
    }
}

class Edge {

    private double weight;
    private Vertex startVertex;
    private Vertex targetVertex;

    public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
        this.weight = weight;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }
}

class DijkstraShortestPath {

    public void computeShortestPaths(Vertex sourceVertex){

        sourceVertex.setDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);
        sourceVertex.setVisited(true);

        while( !priorityQueue.isEmpty() ){
            // Getting the minimum distance vertex from priority queue
            Vertex actualVertex = priorityQueue.poll();

            for(Edge edge : actualVertex.getAdjacenciesList()){

                Vertex v = edge.getTargetVertex();
                if(!v.isVisited())
                {
                    double newDistance = actualVertex.getDistance() + edge.getWeight();

                    if( newDistance < v.getDistance() ){
                        priorityQueue.remove(v);
                        v.setDistance(newDistance);
                        v.setPredecessor(actualVertex);
                        priorityQueue.add(v);
                    }
                }
            }
            actualVertex.setVisited(true);
        }
    }

    public List<Vertex> getShortestPathTo(Vertex targetVertex){
        List<Vertex> path = new ArrayList<>();

        for(Vertex vertex=targetVertex;vertex!=null;vertex=vertex.getPredecessor()){
            path.add(vertex);
        }

        Collections.reverse(path);
        return path;
    }

}

