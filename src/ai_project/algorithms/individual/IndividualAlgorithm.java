package ai_project.algorithms.individual;

import ai_project.algorithms.Algorithm;

/**
 * Created by mma on 12/9/16.
 */
public abstract class IndividualAlgorithm extends Algorithm {
    protected int numOfExpandedNode = 0;

    protected int numOfVisitedNode = 0;

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

    public int getNumOfExpandedNode() {
        return numOfExpandedNode;
    }

    public int getNumOfVisitedNode() {
        return numOfVisitedNode;
    }

}
