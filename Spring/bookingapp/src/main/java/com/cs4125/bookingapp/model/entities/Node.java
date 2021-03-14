package com.cs4125.bookingapp.model.entities;

import javax.persistence.*;

@Entity
public class Node {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer nodeId;
    private String nodeName;
    private String nodeStation;

    public Node(){}

    public Node(String nodeName, String nodeStation) {
        this.nodeName = nodeName;
        this.nodeStation = nodeStation;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeID(Integer nodeId) {
        this.nodeId = nodeId;
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
                "nodeId=" + nodeId +
                ", nodeName=" + nodeName +
                ", nodeStation=" + nodeStation +
                '}';
    }
}