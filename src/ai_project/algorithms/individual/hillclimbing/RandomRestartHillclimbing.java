package ai_project.algorithms.individual.hillclimbing;

import ai_project.Constants;
import ai_project.data_structures.Node;
import ai_project.problems.Problem;

import java.util.ArrayList;

/**
 * Created by mma on 12/8/16.
 */
public class RandomRestartHillclimbing extends Hillclimbing {
    @Override
    public Node apply(Problem problem) {
        int restartLimit = Constants.RESTART_LIMIT;
        boolean flag;
        Node currentNode = null ;
        while (restartLimit > 0) {
            currentNode = problem.getRandomInitialState();
            while (!problem.isGoal(currentNode)) {
                ArrayList<Node> nextStates = problem.nextState(currentNode);
                flag = false;
                for (Node nextState : nextStates) {
                    increaseNumOfVisitedNode();
                    if (problem.objectiveFunction(currentNode) < problem.objectiveFunction(nextState)) {
                        increaseNumOfExpandedNode();
                        nextState.setParent(currentNode);
                        currentNode = nextState;
                        flag = true;
                    }
                }
                //local maximum
                if (flag == false) {
                    if (restartLimit == 0)
                        return currentNode;
                    break;
                }
            }
            if (problem.isGoal(currentNode))
                return currentNode;
            else
                restartLimit--;
        }

        return currentNode;
    }
}
