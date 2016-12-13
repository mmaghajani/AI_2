package ai_project.algorithms.individual.hillclimbing;

import ai_project.data_structures.Node;
import ai_project.problems.Problem;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by mma on 12/8/16.
 */
public class SimpleHillclimbing extends Hillclimbing {
    @Override
    public Node apply(Problem problem) {
        Node currentNode = problem.getInitialState();
        while (!problem.isGoal(currentNode)) {
            ArrayList<Node> nextStates = problem.nextState(currentNode);
            for( Node node : nextStates){
                node.setAccessibilityCost((int) problem.objectiveFunction(node));
            }
            Node next = getMaxNeighbor(nextStates , problem);
            setNumOfVisitedNode(getNumOfVisitedNode() + nextStates.size());
            if( problem.objectiveFunction(currentNode) >= problem.objectiveFunction(next))
                return currentNode;
            else{
                next.setParent(currentNode);
                currentNode = next;
                increaseNumOfExpandedNode();
            }
        }

        return currentNode;
    }

    private Node getMaxNeighbor(ArrayList<Node> nextStates , Problem problem) {
        nextStates.sort((node, t1) -> {
            if( problem.objectiveFunction(node) > problem.objectiveFunction(t1))
                return 1 ;
            else if( problem.objectiveFunction(node) > problem.objectiveFunction(t1))
                return 0 ;
            else
                return -1;
        });

        return nextStates.get(nextStates.size()-1);
    }
}
