package ai_project;

/**
 * Created by mma on 12/8/16.
 */
public class Constants {
    /**
     * Average property for Gaussian function
     */
    public static final double AVERAGE = 0 ;
    /**
     * Variance property for Gaussian function
     */
    public static final double VARIANCE = 0.2;
    /**
     * Step limitation for GA.The number of total fitness evaluation.
     * Can be overridden by user in input state
     */
    public static int GA_STEP_LIMITATION = 800;
    /**
     * Number of population in GA.
     * Can be overridden by user in input state
     */
    public static int NUMBER_OF_POPULATION = 20;
    /**
     * Number of members in parent selection . must be even and less than NUMBER_OF_POPULATION !
     * Can be overridden by user in input state
     */
    public static int PARENT_SELECTION_RATE = 4;
    /**
     * step length for next state in continuous space
     */
    public static final double NEXT_STEP_RATE = 10;
    /**
     * for first choice hillclimbing , for searching a random neighbor
     */
    public static final int RANDOM_RATE = 1000 ;
    /**
     * step limitation for Simulated Anealing
     */
    public static final int STEP_LIMIT = 10000000;
    /**
     * Restart limitation for Random Restart Hillclimbing
     */
    public static final int RESTART_LIMIT = 100;
    /**
     * Precision for equation
     */
    public static final double PRECISION_SOLVING_EQUATION = 0.01 ;
}
