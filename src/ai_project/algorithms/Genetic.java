package ai_project.algorithms;

import ai_project.Constants;
import ai_project.MathHandler;
import ai_project.data_structures.Node;
import ai_project.problems.Problem;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by mma on 12/8/16.
 */
public class Genetic extends Algorithm {
    ArrayList<Node> population = new ArrayList<>();
    private int N = Constants.NUMBER_OF_POPULATION;
    private int K = Constants.PARENT_SELECTION_RATE;

    @Override
    public Node apply(Problem problem) {
        population = generateInitialPopulation(problem);
        int stepLimit = Constants.GA_STEP_LIMITATION;
        while (stepLimit > 0) {
            ArrayList<Node> parents = selectParentsWithTournamentSelection(problem);
            ArrayList<Node> children = crossoverAndOffspring(parents , problem);
            children = mutation(children);
            population = remainingSelection(children);
            stepLimit--;
        }
        return bestNode(population);
    }

    private Node bestNode(ArrayList<Node> population) {
        return null;
    }

    private ArrayList<Node> remainingSelection(ArrayList<Node> children) {
        return null;
    }

    private ArrayList<Node> mutation(ArrayList<Node> children) {
        return null;
    }

    private ArrayList<Node> crossoverAndOffspring(ArrayList<Node> parents , Problem problem) {
        ArrayList<Node> offspring = new ArrayList<>();
        for( int i = 0 ; i < parents.size() ; i = i+2 ){
            ArrayList<Node> childs = problem.crossover(parents.get(i) , parents.get(i+1));
            offspring.add(childs.get(0));
            offspring.add(childs.get(1));
        }
        return offspring;
    }

    private ArrayList<Node> selectParentsWithTournamentSelection(Problem problem) {
        int initialNumber = Constants.PARENT_SELECTION_RATE * 2;
        if (initialNumber > Constants.NUMBER_OF_POPULATION)
            initialNumber = Constants.NUMBER_OF_POPULATION;
        ArrayList<Node> tempResult = new ArrayList<>();
        MathHandler math = MathHandler.getInstance();
        //random selection for initial selection
        for (int i = 0; i < initialNumber; i++) {
            Node node = population.get(math.getIntegerRandNum(population.size()));
            if (!tempResult.contains(node))
                tempResult.add(node);
            else
                i--;
        }
        //sort temp result array based on fitness
        tempResult.sort((node, t1) -> {
            if(problem.objectiveFunction(node) > problem.objectiveFunction(t1))
                return 1;
            else if(problem.objectiveFunction(node) == problem.objectiveFunction(t1))
                return 0;
            else
                return -1;
        });
        //select best PARENT_SELECTION_RATE number of temp result for final result
        ArrayList<Node> result = new ArrayList<>();
        for( int i = 0 ; i < Constants.PARENT_SELECTION_RATE ; i++ )
            result.add(tempResult.get(i));
        return result;
    }

    private ArrayList<Node> generateInitialPopulation(Problem problem) {
        ArrayList<Node> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            result.add(problem.getRandomInitialState());
        }
        return result;
    }
}
