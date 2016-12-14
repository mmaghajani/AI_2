package ai_project.algorithms;


import ai_project.data_structures.Node;
import ai_project.problems.Problem;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public abstract class Algorithm {

    protected int maxUsedMemory = 0;

    protected String name;

    /**
     * Apply this algorithm on the problem
     * @param problem
     * @return
     */
    public abstract Node apply(Problem problem);

    /**
     * Getter for name of the algorithm
     * @return
     */
    public String getName() {
        return name;
    }
}
