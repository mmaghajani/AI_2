package ai_project.problems;

import ai_project.data_structures.Node;

import java.util.ArrayList;

/**
 * Created by mma on 12/9/16.
 */
public class EquationSolving extends Problem {
    @Override
    public Node getInitialState() {
        return null;
    }

    @Override
    public Node getRandomInitialState() {
        return null;
    }

    @Override
    public ArrayList<Node> nextState(Node node) {
        return null;
    }

    @Override
    public boolean isGoal(Node node) {
        return false;
    }

    @Override
    public int getCost(Node src, Node dest) {
        return 0;
    }

    @Override
    public ArrayList<Node> crossover(Node parent1, Node parent2) {
        return null;
    }

    @Override
    public ArrayList<Node> mutation(ArrayList<Node> children) {
        return null;
    }

    @Override
    public Node getGoalState() {
        return null;
    }

    @Override
    public int objectiveFunction(Node node) {
        return 0;
    }
}
