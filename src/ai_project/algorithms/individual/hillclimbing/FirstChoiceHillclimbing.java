package ai_project.algorithms.individual.hillclimbing;

import ai_project.Constants;
import ai_project.MathHandler;
import ai_project.data_structures.Node;
import ai_project.problems.Problem;

import java.util.ArrayList;

/**
 * Created by mma on 12/8/16.
 */
public class FirstChoiceHillclimbing extends Hillclimbing {
    @Override
    public Node apply(Problem problem) {
        MathHandler math = MathHandler.getInstance();
        //get initial state
        Node currentNode = problem.getInitialState();
        while (true) {
            ArrayList<Node> nextStates = problem.nextState(currentNode);
            int index = Constants.RANDOM_RATE;
            boolean flag = false;
            while(index > 0 ){
                Node next = nextStates.get(math.getIntegerRandNum(nextStates.size())) ;
                increaseNumOfVisitedNode();
                if( problem.objectiveFunction(currentNode) < problem.objectiveFunction(next)){
                    increaseNumOfExpandedNode();
                    next.setParent(currentNode);
                    currentNode = next;
                    flag = true;
                    break;
                }
                index--;
            }
            //local maximum
            if( flag == false )
                return currentNode ;
        }
    }
}