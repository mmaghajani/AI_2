package ai_project.data_structures;

/**
 * Created by mma on 12/9/16.
 */
public class EquationSolvingNode extends Node {
    private double state = 0.2;

    public EquationSolvingNode(double state) {
        this.state = state;
    }

    public void setState(double state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if ((int) o == state)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "sin (" + state + ") ? " + state + "^2 - " + state ;
    }

    @Override
    public Object getState() {
        return state ;
    }
}
