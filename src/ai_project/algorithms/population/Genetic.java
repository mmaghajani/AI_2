package ai_project.algorithms.population;

import ai_project.Constants;
import ai_project.MathHandler;
import ai_project.ResponseFormatter;
import ai_project.data_structures.Node;
import ai_project.problems.Problem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by mma on 12/8/16.
 */
public class Genetic extends PopulationAlgorithm {
    ArrayList<Node> population = new ArrayList<>();
    private int N = Constants.NUMBER_OF_POPULATION;
    private int K = Constants.PARENT_SELECTION_RATE;

    public Genetic() {
        details = new HashMap<>();
    }

    @Override
    public Node apply(Problem problem) {
        population = generateInitialPopulation(problem);
        int stepLimit = Constants.GA_STEP_LIMITATION;
        while (stepLimit > 0 && !isGoal(population, problem)) {
            for (Node node : population) {
                node.setFitness(problem.objectiveFunction(node));
            }
            ArrayList<Node> parents = selectParentsWithTournamentSelection(problem);
            ArrayList<Node> children = crossoverAndOffspring(parents, problem);
            children = mutation(children, problem);
            population = remainingSelection(children, problem);
            details.put(Constants.GA_STEP_LIMITATION - stepLimit, computeDetails(problem));
            stepLimit--;
        }
        return bestNode(population, problem);
    }

    private boolean isGoal(ArrayList<Node> population, Problem problem) {
        for (int i = 0; i < population.size(); i++) {
            if (problem.isGoal(population.get(i)))
                return true;
        }
        return false;
    }

    private ArrayList<Double> computeDetails(Problem problem) {
        population.sort((node, t1) -> {
            if (problem.objectiveFunction(node) > problem.objectiveFunction(t1))
                return 1;
            else if (problem.objectiveFunction(node) == problem.objectiveFunction(t1))
                return 0;
            else
                return -1;
        });

        double sum = 0;
        double avg;
        for (int i = 0; i < population.size(); i++)
            sum += problem.objectiveFunction(population.get(i));
        avg = sum / (double) population.size();
        //result array that first member's is best fitness and last member's
        //is worth fitness and middle is average
        ArrayList<Double> result = new ArrayList<>();
        result.add(problem.objectiveFunction(population.get(population.size() - 1)));
        result.add(problem.objectiveFunction(population.get(0)));
        result.add(avg);

        return result;
    }

    private Node bestNode(ArrayList<Node> population, Problem problem) {
        Node max = population.get(0);
        for (int i = 0; i < population.size(); i++) {
            if (problem.objectiveFunction(population.get(i)) > problem.objectiveFunction(max)) {
                max = population.get(i);
            }
        }
        return max;
    }

    private ArrayList<Node> remainingSelection(ArrayList<Node> children, Problem problem) {
        MathHandler math = MathHandler.getInstance();
        //Adds K/2 node to population
        for (int i = 0; i < children.size(); i++) {
            population.add(children.get(i));
        }
        //Deletes K/2 node from population based on fitness
        ArrayList<Node> temp = new ArrayList<>();
        for (int i = 0; i < K ; i++) {
            int x = math.getIntegerRandNum(population.size());
            temp.add(population.get(x));
        }
        temp.sort(math.getComparator(problem));
        for( int i = K-1 ; i >= K/2 ; i-- ){
            population.remove(temp.get(i));
        }

        return population;
    }

    private ArrayList<Node> mutation(ArrayList<Node> children, Problem problem) {
        return problem.mutation(children);
    }

    private ArrayList<Node> crossoverAndOffspring(ArrayList<Node> parents, Problem problem) {
        ArrayList<Node> offspring = new ArrayList<>();
        for (int i = 0; i < parents.size(); i = i + 2) {
            //problem object generates child from parents
            Node child = problem.crossover(parents.get(i), parents.get(i + 1));
            offspring.add(child);
            child.setFitness(problem.objectiveFunction(child));
        }
        return offspring;
    }

    private ArrayList<Node> selectParentsWithTournamentSelection(Problem problem) {
        int initialNumber = K * 2;
        if (initialNumber > N)
            initialNumber = N;
        ArrayList<Node> tempResult = new ArrayList<>();
        MathHandler math = MathHandler.getInstance();
        //random selection for initial selection
        ArrayList<Node> temp = (ArrayList<Node>) population.clone();
        for (int i = 0; i < initialNumber; i++) {
            Node node = temp.get(math.getIntegerRandNum(temp.size()));
            tempResult.add(node);
            temp.remove(node);
        }
        //sort temp result array based on fitness
        tempResult.sort(math.getComparator(problem));
        //select best PARENT_SELECTION_RATE number of temp result for final result
        ArrayList<Node> result = new ArrayList<>();
        for (int i = 0; i < K; i++)
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
