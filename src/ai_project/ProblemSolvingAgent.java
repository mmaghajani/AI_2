package ai_project;

import ai_project.algorithms.Algorithm;
import ai_project.data_structures.Node;
import ai_project.problems.Problem;

/**
 * Created by mma on 10/26/16.
 */
public class ProblemSolvingAgent {
    private Problem problem;
    private Algorithm searchAlgorithm;

    public ProblemSolvingAgent() {

    }

    public ProblemSolvingAgent(Problem problem, Algorithm searchAlgorithm) {
        this.problem = problem;
        this.searchAlgorithm = searchAlgorithm;
    }

    public Problem getProblem() {
        return problem;
    }

    public Algorithm getSearchAlgorithm() {
        return searchAlgorithm;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public void setSearchAlgorithm(Algorithm algorithm) {
        this.searchAlgorithm = algorithm;
    }

    public void configure(Problem problem, Algorithm searchAlgorithm) {
        this.problem = problem;
        this.searchAlgorithm = searchAlgorithm;
    }

    public Node solve(){
        return searchAlgorithm.apply(problem);
    }

}
