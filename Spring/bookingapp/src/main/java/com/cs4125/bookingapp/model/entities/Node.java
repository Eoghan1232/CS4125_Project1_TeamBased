package com.cs4125.bookingapp.model.entities;

import javax.persistence.*;

@Entity
public class Node {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer nodeID;
    private String nodeName;
    private String nodeStation;

    public Node(){}

    public Node(String nodeName, String nodeStation) {
        this.nodeName = nodeName;
        this.nodeStation = nodeStation;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeStation() {
        return nodeStation;
    }

    public void setNodeStation(String nodeStation) {
        this.nodeStation = nodeStation;
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeID=" + nodeID +
                ", nodeName=" + nodeName +
                ", nodeStation=" + nodeStation +
                '}';
    }
}