package ai_project.algorithms.individual;

import ai_project.Constants;
import ai_project.MathHandler;
import ai_project.data_structures.Node;
import ai_project.problems.Problem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mma on 12/5/16.
 */
public class SimulatedAnealing extends IndividualAlgorithm {

    int stepLimit;

    public SimulatedAnealing() {
        getInputs();
        stepLimit = Constants.STEP_LIMIT;
        name = "Simulated Anealing Algorithm";
    }

    public void getInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter inputs.For ignore each item press an negative number.");
        System.out.println("Please Enter step limit for simulated anealing .Default value(" +
                Constants.STEP_LIMIT + "):");
        int x = sc.nextInt();
        if (x > 0)
            Constants.STEP_LIMIT = x;
    }

    @Override
    public Node apply(Problem problem) {
        MathHandler math = MathHandler.getInstance();
        int steps = 1;
        Node initial = problem.getInitialState();
        Node currentNode = initial;
        while (steps < stepLimit && !problem.isGoal(currentNode)) {
            ArrayList<Node> nextStates = problem.nextState(currentNode);
            Node next = nextStates.get(math.getIntegerRandNum(nextStates.size()));
            increaseNumOfVisitedNode();
            if (problem.objectiveFunction(currentNode) <= problem.objectiveFunction(next)) {
                next.setParent(currentNode);
                currentNode = next;
                increaseNumOfExpandedNode();
            } else if (math.getRandNum() <= p(steps)) {
                next.setParent(currentNode);
                currentNode = next;
                increaseNumOfExpandedNode();
            }
            steps++;
        }
        return currentNode;
    }

    /**
     * computes p function
     *
     * @param t step of problem
     * @return values of p function
     */
    private double p(int t) {
        double result = Math.abs(Math.sin(t) / (double) t);
        return result;
    }
}
