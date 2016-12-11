package ai_project;

import ai_project.algorithms.individual.SimulatedAnealing;
import ai_project.algorithms.individual.hillclimbing.FirstChoiceHillclimbing;
import ai_project.algorithms.individual.hillclimbing.RandomHillclimbing;
import ai_project.algorithms.individual.hillclimbing.RandomRestartHillclimbing;
import ai_project.algorithms.individual.hillclimbing.SimpleHillclimbing;
import ai_project.problems.Queens;
import com.sun.corba.se.impl.orbutil.closure.Constant;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mma on 10/26/16.
 */
public class Main {
    public static void main(String[] args) {
        ProblemSolvingAgent agent = new ProblemSolvingAgent();
        getInputs();
        configQueensProblem(agent);
    }

    private static void configQueensProblem(ProblemSolvingAgent agent) {
        Queens problem = new Queens();
        agent.setProblem(problem);
        agent.setSearchAlgorithm(new SimulatedAnealing());
        agent.solve();
        agent.setSearchAlgorithm(new SimpleHillclimbing());
        agent.solve();
        agent.setSearchAlgorithm(new FirstChoiceHillclimbing());
        agent.solve();
        agent.setSearchAlgorithm(new RandomHillclimbing());
        agent.solve();
        agent.setSearchAlgorithm(new RandomRestartHillclimbing());
        agent.solve();
    }

    private static void getInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of total evaluation for GA");
        Constants.GA_STEP_LIMITATION = sc.nextInt() ;
        System.out.println("Enter number of population");
        Constants.NUMBER_OF_POPULATION = sc.nextInt();
        System.out.println("Enter number of members as a parent");
        Constants.PARENT_SELECTION_RATE = sc.nextInt();

    }
}
