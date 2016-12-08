package algorithms;

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
     * @param limit
     * @return
     */
    public int getIntegerRandNum(int limit){
        Random x = new Random();
        return (x.nextInt()%limit);
    }

    /**
     * generate random number between 0 and 1
     * @return
     */
    public double getRandNum(){
        Random x = new Random();
        return (x.nextInt() % 1000) / 1000 ;
    }
}
