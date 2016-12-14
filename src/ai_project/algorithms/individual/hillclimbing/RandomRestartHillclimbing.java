package ai_project.algorithms.individual.hillclimbing;

import ai_project.Constants;
import ai_project.data_structures.Node;
import ai_project.problems.Problem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mma on 12/8/16.
 */
public class RandomRestartHillclimbing extends Hillclimbing {

    public RandomRestartHillclimbing() {
        getInputs();
        name = "Random Restart Hill Climbing Algorithm";
    }

    public void getInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter inputs.For ignore each item press an negative number.");
        System.out.println("Please Enter restart limit for random restart hill climbing . Default value("
                + Constants.RESTART_LIMIT + ") :");
        int x = sc.nextInt();
        if (x > 0)
            Constants.RESTART_LIMIT = x;
    }

    @Override
    public Node apply(Problem problem) {
        int restartLimit = Constants.RESTART_LIMIT;
        boolean flag;
        Node currentNode = null;
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
