package ai_project.algorithms;

import ai_project.Constants;
import ai_project.data_structures.Node;
import ai_project.problems.Problem;

import java.util.ArrayList;

/**
 * Created by mma on 12/8/16.
 */
public class Genetic extends Algorithm {
    ArrayList<Node> population = new ArrayList<>();
    @Override
    public Node apply(Problem problem) {
        population = generateInitialPopulation();
        int stepLimit = Constants.GA_STEP_LIMITATION ;
        while(stepLimit > 0 ){
            ArrayList<Node> parents = selectParents();
            ArrayList<Node> children = crossoverAndOffspring(parents);
            children = mutation(children);
            population = remainingSelection(children);
            stepLimit--;
        }
        return bestNode(population);
    }

    private Node bestNode(ArrayList<Node> population) {
        return null;
    }

    private ArrayList<Node> remainingSelection(ArrayList<Node> children) {
        return null;
    }

    private ArrayList<Node> mutation(ArrayList<Node> children) {
        return null;
    }

    private ArrayList<Node> crossoverAndOffspring(ArrayList<Node> parents) {
        return null;
    }

    private ArrayList<Node> selectParents() {
        return null;
    }

    private ArrayList<Node> generateInitialPopulation() {
        return null;
    }
}
