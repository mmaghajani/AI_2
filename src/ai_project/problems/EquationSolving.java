package ai_project.problems;

import ai_project.Constants;
import ai_project.MathHandler;
import ai_project.data_structures.EquationSolvingNode;
import ai_project.data_structures.Node;

import java.util.ArrayList;

/**
 * Created by mma on 12/9/16.
 */
public class EquationSolving extends Problem {
    @Override
    public Node getInitialState() {
        return new EquationSolvingNode(0.2);
    }

    @Override
    public Node getRandomInitialState() {
        MathHandler math = MathHandler.getInstance();
        //generate random number between 0.2 to 3.14
        int state = (math.getIntegerRandNum(294) + 20) / 100;
        return new EquationSolvingNode(state);
    }

    @Override
    public ArrayList<Node> nextState(Node node) {
        ArrayList<Node> nextState = new ArrayList<>();
        double state = ((double) node.getState());
        double nextState1 = state + 0.01;
        double nextState2 = state - 0.01;
        nextState.add(new EquationSolvingNode(nextState1));
        nextState.add(new EquationSolvingNode(nextState2));
        return nextState;
    }

    @Override
    public boolean isGoal(Node node) {
        double state = (double) node.getState();
        if (Math.abs(Math.sin(state) - state * state + state) < Constants.PRECISION_SOLVING_EQUATION)
            return true;
        else
            return false;
    }

    @Override
    public int getCost(Node src, Node dest) {
        return 0;
    }

    @Override
    public Node crossover(Node parent1, Node parent2) {
        EquationSolvingNode offspring = new EquationSolvingNode((
                (double) parent1.getState() + (double) parent2.getState()) / 2);
        return offspring;
    }

    @Override
    public ArrayList<Node> mutation(ArrayList<Node> children) {
        MathHandler math = MathHandler.getInstance();
        for (int i = 0; i < children.size(); i++) {
            double x = (double) children.get(i).getState();
            double gaussianValue = math.gaussianValue(x);
            ((EquationSolvingNode) children.get(i)).setState(gaussianValue);
        }
        return children;
    }


    @Override
    public Node getGoalState() {
        return null;
    }

    @Override
    public double objectiveFunction(Node node) {
        double state = (double) node.getState();
        double res = Math.abs(Math.sin(state) - state * state + state);
        return -1 * res;
    }
}
