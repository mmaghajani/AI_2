package ai_project.algorithms;


import ai_project.data_structures.Node;
import ai_project.problems.Problem;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public abstract class Algorithm {
    protected ArrayList<Node> f;
    protected ArrayList<Node> e;
    protected int numOfExpandedNode = 0;
    protected int numOfVisitedNode = 0;
    protected int maxUsedMemory = 0;

    public abstract Node apply(Problem problem);

    public void increaseNumOfExpandedNode() {
        this.numOfExpandedNode++;
    }

    public void setNumOfExpandedNode(int number) {
        this.numOfExpandedNode = number;
    }

    public void increaseNumOfVisitedNode() {
        this.numOfVisitedNode++;
    }

    public void setNumOfVisitedNode(int number) {
        this.numOfVisitedNode = number;
    }

    public void setMaxUsedMemory(int count) {
        maxUsedMemory = count;
    }

    public int getMaxUsedMemory() {
        return maxUsedMemory;
    }

    public int getNumOfExpandedNode() {
        return numOfExpandedNode;
    }

    public int getNumOfVisitedNode() {
        return numOfVisitedNode;
    }
}
