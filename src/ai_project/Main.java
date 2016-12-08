package ai_project;

import ai_project.algorithms.informed_search.AStar;
import ai_project.algorithms.uninformed_search.BFS;
import ai_project.algorithms.uninformed_search.BidirectionalSearch;
import ai_project.algorithms.uninformed_search.UniformCostSearch;
import ai_project.algorithms.uninformed_search.dfs.DepthLimitedSearch;
import ai_project.algorithms.uninformed_search.dfs.UnlimitedDFS;
import ai_project.problems.Queens;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public class Main {
    public static void main(String[] args) {
        ProblemSolvingAgent agent = new ProblemSolvingAgent();
        configRobotProblem(agent);
        configQueensProblem(agent);
    }

    private static void configQueensProblem(ProblemSolvingAgent agent) {
        Queens queensProblem = new Queens();
        agent.configure(queensProblem, new BFS());
        ResponseFormatter.getInstance().format(agent, agent.solve(false));
        agent.configure(queensProblem, new DepthLimitedSearch(8));
        ResponseFormatter.getInstance().format(agent, agent.solve(true));
        agent.configure(queensProblem, new AStar());
        ResponseFormatter.getInstance().format(agent, agent.solve(false));
    }

    private static void configRobotProblem(ProblemSolvingAgent agent) {
        ArrayList<Integer> horizontalWall = new ArrayList<>();
        horizontalWall.add(16);
        horizontalWall.add(17);
        ArrayList<Integer> verticalWall = new ArrayList<>();
        verticalWall.add(9);
        verticalWall.add(15);
        Robot robotProblem = new Robot(5, 5, horizontalWall, verticalWall);
        agent.configure(robotProblem, new UniformCostSearch());
        ResponseFormatter.getInstance().format(agent, agent.solve(true));
        agent.configure(robotProblem, new UnlimitedDFS());
        ResponseFormatter.getInstance().format(agent, agent.solve(true));
        agent.configure(robotProblem, new BidirectionalSearch());
        ResponseFormatter.getInstance().format(agent, agent.solve(true));
        agent.configure(robotProblem, new AStar());
        ResponseFormatter.getInstance().format(agent, agent.solve(true));
    }
}
