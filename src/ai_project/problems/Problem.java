package ai_project.problems;

import ai_project.data_structures.Node;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public abstract class Problem {
    public abstract Node getInitialState();

    public abstract Node getRandomInitialState();

    public abstract ArrayList<Node> nextState(Node node);

    public abstract boolean isGoal(Node node);

    public abstract int getCost(Node src, Node dest);

    public abstract ArrayList<Node> crossover(Node parent1 , Node parent2);

    public abstract ArrayList<Node> mutation(ArrayList<Node> children);

    public abstract Node getGoalState();

    public abstract int objectiveFunction(Node node);

    public double getPathCost(Node node){
        if(node == null )   return Double.MAX_VALUE ;
        return node.getAccessibilityCost() ;
    }
}
