package ai_project.algorithms.hillclimbing;

import ai_project.Constants;
import ai_project.data_structures.Node;
import ai_project.problems.Problem;
import com.sun.corba.se.impl.orbutil.closure.Constant;

import java.util.ArrayList;

/**
 * Created by mma on 12/8/16.
 */
public class RandomRestartHillclimbing extends Hillclimbing {
    @Override
    public Node apply(Problem problem) {
        {
            int restartLimit = Constants.RESTART_LIMIT;
            Node currentNode = problem.getInitialState();
            boolean flag ;
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
                if (flag == false) {
                    restartLimit--;
                    if (restartLimit == 0)
                        return currentNode;
                }
            }
        }
    }
}
