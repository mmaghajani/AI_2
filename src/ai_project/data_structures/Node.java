package ai_project.data_structures;

/**
 * Created by mma on 10/26/16.
 */
public abstract class Node {
    protected double fitness;
    protected int depth = 0 ;
    protected Node parent = null ;

    public Node(){

    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setParent(Node parent){
        this.parent = parent ;
    }

    public Node getParent(){
        return parent ;
    }

    public abstract Object getState() ;
}
