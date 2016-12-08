package algorithms;

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
        int steps = 0;
        Node initial = problem.getInitialState();
        Node currentNode = initial ;
        while (steps < stepLimit) {
            ArrayList<Node> nextStates = problem.nextState(currentNode);
            Node next = nextStates.get(getIntegerRandNum(nextStates.size()));
            if( problem.objectiveFunction(currentNode) < problem.objectiveFunction(next)){
                currentNode = next ;
            }else if(getRandNum() > p(steps)) {
                currentNode = next ;
            }
            steps++;
        }
        return currentNode;
    }

    private double p(double t) {
        return 1 / t;
    }

    private int getIntegerRandNum(int limit){
        Random x = new Random();
        return (x.nextInt()%limit);
    }

    private double getRandNum(){
        Random x = new Random();
        return (x.nextInt() % 1000) / 1000 ;
    }
}
