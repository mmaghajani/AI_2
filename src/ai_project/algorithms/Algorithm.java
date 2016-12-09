package ai_project.algorithms;


import ai_project.data_structures.Node;
import ai_project.problems.Problem;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public abstract class Algorithm {

    protected int maxUsedMemory = 0;

    public abstract Node apply(Problem problem);

    public void setMaxUsedMemory(int count) {
        maxUsedMemory = count;
    }

    public int getMaxUsedMemory() {
        return maxUsedMemory;
    }
}
