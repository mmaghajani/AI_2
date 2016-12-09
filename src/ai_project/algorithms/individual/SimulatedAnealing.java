package ai_project.algorithms.individual;

import ai_project.Constants;
import ai_project.MathHandler;
import ai_project.data_structures.Node;
import ai_project.problems.Problem;

import java.util.ArrayList;

/**
 * Created by mma on 12/5/16.
 */
public class SimulatedAnealing extends IndividualAlgorithm {

    int stepLimit = Constants.STEP_LIMIT;

    @Override
    public Node apply(Problem problem) {
        MathHandler math = MathHandler.getInstance() ;
        int steps = 0;
        Node initial = problem.getInitialState();
        Node currentNode = initial ;
        while (steps < stepLimit && !problem.isGoal(currentNode)) {
            ArrayList<Node> nextStates = problem.nextState(currentNode);
            Node next = nextStates.get(math.getIntegerRandNum(nextStates.size()));
            increaseNumOfVisitedNode();
            if( problem.objectiveFunction(currentNode) < problem.objectiveFunction(next)){
                next.setParent(currentNode);
                currentNode = next ;
                increaseNumOfExpandedNode();
            }else if(math.getRandNum() > p(steps)) {
                next.setParent(currentNode);
                currentNode = next ;
                increaseNumOfExpandedNode();
            }
            steps++;
        }
        return currentNode;
    }

    /**
     * computes p function
     * @param t step of problem
     * @return values of p function
     */
    private double p(double t) {
        return 1 / t;
    }
}
