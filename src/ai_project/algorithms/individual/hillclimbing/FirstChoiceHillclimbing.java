package ai_project.algorithms.individual.hillclimbing;

import ai_project.Constants;
import ai_project.MathHandler;
import ai_project.data_structures.Node;
import ai_project.problems.Problem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mma on 12/8/16.
 */
public class FirstChoiceHillclimbing extends Hillclimbing {

    public FirstChoiceHillclimbing() {
        getInputs();
        name = "First Choice Hill Climbing Algorithm";
    }

    /**
     * This method get constants inputs
     */
    public void getInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter inputs.For ignore each item press an negative number.");
        System.out.println("Please Enter random rate for number of searching a random neighbor" +
                " in first choice hill climbing.Default value("
                + Constants.RANDOM_RATE + "):");
        int x = sc.nextInt();
        if (x > 0)
            Constants.RANDOM_RATE = x;
    }

    @Override
    public Node apply(Problem problem) {
        MathHandler math = MathHandler.getInstance();
        //get initial state
        Node currentNode = problem.getInitialState();
        while (!problem.isGoal(currentNode)) {
            ArrayList<Node> nextStates = problem.nextState(currentNode);
            int index = Constants.RANDOM_RATE;
            boolean flag = false;
            while (index > 0) {
                Node next = nextStates.get(math.getIntegerRandNum(nextStates.size()));
                increaseNumOfVisitedNode();
                if (problem.objectiveFunction(currentNode) < problem.objectiveFunction(next)) {
                    increaseNumOfExpandedNode();
                    next.setParent(currentNode);
                    currentNode = next;
                    flag = true;
                    break;
                }
                index--;
            }
            //local maximum
            if (flag == false)
                return currentNode;
        }

        return currentNode;
    }
}
