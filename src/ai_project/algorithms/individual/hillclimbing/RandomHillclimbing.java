package ai_project.algorithms.individual.hillclimbing;

import ai_project.MathHandler;
import ai_project.data_structures.Node;
import ai_project.problems.Problem;

import java.util.ArrayList;

/**
 * Created by mma on 12/8/16.
 */
public class RandomHillclimbing extends Hillclimbing {

    public RandomHillclimbing() {
        name = "Stochastic Hill Climbing";
    }

    @Override
    public Node apply(Problem problem) {
        MathHandler math = MathHandler.getInstance();
        //get initial state
        Node currentNode = problem.getInitialState();
        currentNode.setFitness((int) problem.objectiveFunction(currentNode));
        while (!problem.isGoal(currentNode)) {
            ArrayList<Node> nextStates = problem.nextState(currentNode);
            for (Node node : nextStates) {
                node.setFitness((int) problem.objectiveFunction(node));
            }
            setNumOfVisitedNode(getNumOfVisitedNode() + nextStates.size());
            nextStates = deriveIncrementedNextStates(nextStates, currentNode, problem);
            if (nextStates.size() == 0) {
                //local maximum
                return currentNode;
            } else {
                Node next = nextStates.get(math.getIntegerRandNum(nextStates.size()));
                increaseNumOfExpandedNode();
                next.setParent(currentNode);
                currentNode = next;
            }
        }

        return currentNode;
    }

    /**
     * this method filters next states makes objective function incremented
     *
     * @param nextStates
     * @param currentNode
     * @param problem     problem class for compute values of objective function
     * @return incremented next states
     */
    private ArrayList<Node> deriveIncrementedNextStates(ArrayList<Node> nextStates, Node currentNode
            , Problem problem) {
        ArrayList<Node> result = new ArrayList<>();
        for (Node state : nextStates) {
            if (problem.objectiveFunction(currentNode) < problem.objectiveFunction(state)) {
                result.add(state);
            }
        }
        return result;
    }
}
