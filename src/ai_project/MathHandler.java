package ai_project;

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
        return (x.nextInt() % limit);
    }

    /**
     * generate random number between 0 and 1
     *
     * @return
     */
    public double getRandNum() {
        Random x = new Random();
        return (x.nextInt() % 1000) / 1000;
    }

    /**
     * return value of gaussian function
     *
     * @param x
     * @return
     */
    public double gaussianValue(double x) {
        double a = 1 / (Math.sqrt(Constants.VARIANCE) * Math.sqrt(2 * Math.PI));
        double b = Constants.AVERAGE;
        double c = Math.sqrt(Constants.VARIANCE);

        return a * Math.exp((-1 * (x - b) * (x - b)) / (2 * Math.sqrt(c) * Math.sqrt(c)));
    }

    /**
     * Computes gradin for sin(x) - x^2 + x
     * @param state
     * @return
     */
    public double gradian(double state) {
        return Math.cos(state) - 2 * state + 1;
    }
}
