package ai_project;

import ai_project.algorithms.Algorithm;
import ai_project.algorithms.individual.IndividualAlgorithm;
import ai_project.algorithms.population.PopulationAlgorithm;
import ai_project.data_structures.Node;
import ai_project.problems.Problem;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mma on 10/31/16.
 */
public class ResponseFormatter {
    private final String separator = "----------------------";

    private static ResponseFormatter ourInstance = new ResponseFormatter();

    public static ResponseFormatter getInstance() {
        return ourInstance;
    }

    private ResponseFormatter() {
    }

    /**
     * This format method is formatter for individual algorithms
     *
     * @param agent problem solving agent
     * @param goal  final node
     */
    public void formatIndividualAlgorithms(ProblemSolvingAgent agent, Node goal) {
        Algorithm algorithm = agent.getSearchAlgorithm();


        Node node = goal;
        ArrayList<Node> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.getParent();
        }

        System.out.println("Path : ");
        for (int i = path.size() - 1; i >= 0; i--)
            System.out.println(path.get(i));
        System.out.println(separator);
        System.out.println("number of expanded nodes : " + ((IndividualAlgorithm) algorithm).getNumOfExpandedNode());
        System.out.println("number of visited nodes : " + ((IndividualAlgorithm) algorithm).getNumOfVisitedNode());
        System.out.println(separator);
        System.out.println("fitness of goal : " + agent.getProblem().objectiveFunction(goal) + "\n\n\n");
    }

    /**
     * This method formats outputs of population algorithms.
     * @param agent
     * @param goal
     */
    public void formatPopulationAlgotithms(ProblemSolvingAgent agent , Node goal){
        Algorithm algorithm = agent.getSearchAlgorithm();
        HashMap<Integer , ArrayList<Double>> details = ((PopulationAlgorithm) algorithm).getDetails();

        System.out.println(separator);
        System.out.println("Number of total generation : " + details.size());
        for( int i = 0 ; i < details.size() ; i++ ){
            System.out.println("Generation " + i + " :");
            System.out.println("   The best fitness : " + details.get(i).get(0));
            System.out.println("   The worth fitness : " + details.get(i).get(1));
            System.out.println("   The average fitness : " + details.get(i).get(2));
        }

        System.out.println(separator);
        System.out.println(goal);
    }

    public void printOneDetail(int i , ArrayList<Double> detail){
        System.out.println("Generation " + i + " :");
        System.out.println("   The best fitness : " + detail.get(0));
        System.out.println("   The worth fitness : " + detail.get(1));
        System.out.println("   The average fitness : " + detail.get(2));
    }
}
