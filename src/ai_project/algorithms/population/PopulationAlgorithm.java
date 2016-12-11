package ai_project.algorithms.population;

import ai_project.algorithms.Algorithm;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mma on 12/9/16.
 */
public abstract class PopulationAlgorithm extends Algorithm {
    protected HashMap<Integer,ArrayList<Double>> details ;

    /**
     * Getter for details of algorithms that consists of
     * the best and worth and average of fitness in each generation.
     * size of details map is number of total generation.This HashMap maps generation number to detail's.
     * @return details map
     */
    public HashMap<Integer,ArrayList<Double>> getDetails(){
        return details ;
    }
}
