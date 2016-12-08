package algorithms.hillclimbing;

import data_structures.Node;
import problems.Problem;

import java.util.ArrayList;

/**
 * Created by mma on 12/8/16.
 */
public class SimpleHillclimbing extends Hillclimbing {
    @Override
    public Node apply(Problem problem) {
        Node currentNode = problem.getInitialState();
        boolean flag = false;
        while (true) {
            ArrayList<Node> nextStates = problem.nextState(currentNode);
            flag = false;
            for (Node nextState : nextStates) {
                if (problem.objectiveFunction(currentNode) < problem.objectiveFunction(nextState)) {
                    currentNode = nextState;
                    flag = true;
                }
            }
            //local maximum
            if( flag == false )
                return currentNode ;
        }
    }
}
