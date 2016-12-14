package ai_project;

import ai_project.data_structures.Node;
import ai_project.problems.Problem;

import java.util.Comparator;
import java.util.Random;

/**
 * Created by mma on 12/8/16.
 */
public class MathHandler {
    private static MathHandler ourInstance = new MathHandler();

    public static MathHandler getInstance() {
        return ourInstance;
    }

    private MathHandler() {
    }

    /**
     * get integer random number for neighbor selection
     *
     * @param limit
     * @return
     */
    public int getIntegerRandNum(int limit) {
        Random x = new Random();
        return (Math.abs(x.nextInt() % limit));
    }

    /**
     * generate random number between 0 and 1
     *
     * @return
     */
    public double getRandNum() {
        Random x = new Random();
        double result = ((double)(Math.abs(x.nextInt() % 1000)) / 1000);
        return result;
    }

    /**
     * return value of gaussian function
     * @param x
     * @return
     */
    public double gaussianValue(double x) {
        double a = 1 / (Math.sqrt(Constants.VARIANCE) * Math.sqrt(2 * Math.PI));
        double b = Constants.AVERAGE;
        double c = Math.sqrt(Constants.VARIANCE);

        double y = (-1 * (x - b) * (x - b)) ;
        double z = (2 * c * c) ;
        double f = y/z;
        double r = (a * Math.exp(f));
        return r;
    }

    /**
     * Computes gradin for sin(x) - x^2 + x
     * @param state
     * @return
     */
    public double gradian(double state) {
        return Math.cos(state) - 2 * state + 1;
    }

    /**
     * Return a comparator for sort descending
     * @param problem
     * @return
     */
    public Comparator<Node> getComparator(Problem problem){
        return (node, t1) -> {
            if (problem.objectiveFunction(node) > problem.objectiveFunction(t1))
                return -1;
            else if (problem.objectiveFunction(node) == problem.objectiveFunction(t1))
                return 0;
            else
                return 1;
        };
    }
}
