package ai_project;

import ai_project.problems.Queens;
import com.sun.corba.se.impl.orbutil.closure.Constant;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mma on 10/26/16.
 */
public class Main {
    public static void main(String[] args) {
        getInputs();
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
