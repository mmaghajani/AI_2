package algorithms;

import algorithms.Algorithm;
import data_structures.Node;
import problems.Problem;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by mma on 12/5/16.
 */
public class SimulatedAnealing extends Algorithm {

    int stepLimit = 1000;

    @Override
    public Node apply(Problem problem) {
        MathHandler math = MathHandler.getInstance() ;
        int steps = 0;
        Node initial = problem.getInitialState();
        Node currentNode = initial ;
        while (steps < stepLimit) {
            ArrayList<Node> nextStates = problem.nextState(currentNode);
            Node next = nextStates.get(math.getIntegerRandNum(nextStates.size()));
            if( problem.objectiveFunction(currentNode) < problem.objectiveFunction(next)){
                currentNode = next ;
            }else if(math.getRandNum() > p(steps)) {
                currentNode = next ;
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
