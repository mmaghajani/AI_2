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
    public static final double VARIANCE = 0.01;
    /**
     * Step limitation for GA.The number of total fitness evaluation
     */
    public static final int GA_STEP_LIMITATION = 1000;
    /**
     * Number of population in GA
     */
    public static final int NUMBER_OF_POPULATION = 50;
    /**
     * Number of members in parent selection . must be even and less than NUMBER_OF_POPULATION !
     */
    public static final int PARENT_SELECTION_RATE = 4;
    /**
     * for first choice hillclimbing , for searching a random neighbor
     */
    public static int RANDOM_RATE = 1000 ;
    /**
     * step limitation for Simulated Anealing
     */
    public static int STEP_LIMIT = 1000;
    /**
     * Restart limitation for Random Restart Hillclimbing
     */
    public static int RESTART_LIMIT = 10;
    /**
     * Precision for equation
     */
    public static double PRECISION_SOLVING_EQUATION = 0.01 ;
}
