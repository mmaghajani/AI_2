package ai_project.problems;

import ai_project.MathHandler;
import ai_project.data_structures.Node;
import ai_project.data_structures.QueensNode;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public class Queens extends Problem {
    @Override
    public Node getInitialState() {
        int[] state = new int[8];
//        for (int i = 0; i < 8; i++)
//            state[i] = i;
        state[0] = 0;
        state[1] = 1;
        state[2] = 2;
        state[3] = 3;
        state[4] = 4;
        state[5] = 5;
        state[6] = 6;
        state[7] = 7;
        QueensNode node = new QueensNode(state);
        return node;
    }

    @Override
    public Node getRandomInitialState() {
        MathHandler math = MathHandler.getInstance();
        int[] state = new int[8];
        for (int i = 0; i < 8; i++)
            state[i] = math.getIntegerRandNum(8);

        QueensNode node = new QueensNode(state);
        return node;
    }

    @Override
    public ArrayList<Node> nextState(Node node) {
        ArrayList<Node> next = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int[] state1 = ((int[]) node.getState()).clone();
            if (state1[i] > 0) {
                state1[i]--;
                QueensNode nextState = new QueensNode(state1);
                next.add(nextState);
            }
            int[] state2 = ((int[]) node.getState()).clone();
            if (state2[i] < 7) {
                state2[i]++;
                QueensNode nextState = new QueensNode(state2);
                next.add(nextState);
            }
        }
        return next;
    }

    @Override
    public boolean isGoal(Node node) {
        return isGaurd(node);
    }

    private boolean isGaurd(Node node) {
        int[] state = ((int[]) node.getState());
        int[] mark = new int[8];
        for (int i = 0; i < 8; i++)
            mark[i] = 0;
        for (int i = 0; i < 8; i++) {
            if (mark[state[i]] != 0)
                return false;
            else
                mark[state[i]] = 1;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                if (state[j] == state[i] - (j - i) || state[j] == state[i] + (j - i))
                    return false;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (state[j] == state[i] - (i - j) || state[j] == state[i] + (i - j))
                    return false;
            }
        }
        return true;
    }

    @Override
    public int getCost(Node src, Node dest) {
        return 1;
    }

    @Override
    public Node crossover(Node parent1, Node parent2) {
        MathHandler math = MathHandler.getInstance();
        int breakPoint = math.getIntegerRandNum(8);
        int[] state = new int[8];
        //generate first child
        for (int i = 0; i < 8; i++) {
            if (i < breakPoint)
                state[i] = ((int[]) parent1.getState())[i];
            else
                state[i] = ((int[]) parent2.getState())[i];
        }
        QueensNode offspring = new QueensNode(state.clone());
        return offspring;
    }

    @Override
    public ArrayList<Node> mutation(ArrayList<Node> children) {
        ArrayList<Node> result = new ArrayList<>();
        MathHandler math = MathHandler.getInstance();
        for (Node node : children) {
            int x = math.getIntegerRandNum(8);
            int[] state = ((int[]) node.getState());
            state[x] = math.getIntegerRandNum(8);
            ((QueensNode) node).setState(state);
            result.add(node);
        }
        return result;
    }

    @Override
    public Node getGoalState() {
        return null;
    }

    @Override
    public double objectiveFunction(Node node) {
        int counter = 0;
        int[] state = ((int[]) node.getState());
        int[] mark = new int[8];
        for (int i = 0; i < 8; i++)
            mark[i] = 0;

        for (int i = 0; i < 8; i++) {
            mark[state[i]] = 1;
        }

        for (int i = 0; i < 8; i++) {
            if (mark[i] == 0)
                counter++;
        }

        counter *= 2 ;

        for (int i = 0; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                try {
                    if (state[i] - j == state[i + j])
                        counter++;
                }catch(Exception e){

                }
                try {
                    if (state[i] - j == state[i - j])
                        counter++;
                }catch(Exception e){

                }
                try {
                    if (state[i] + j == state[i + j])
                        counter++;
                }catch(Exception e){

                }
                try {
                    if (state[i] + j == state[i - j])
                        counter++;
                }catch(Exception e){

                }
            }
        }

        return -(counter/2) ;
    }
}
