package com.example.planets;

import javax.swing.*;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.util.*;

public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<Planet> planets = new HashSet<>();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        boolean flag = true;
        while (flag) {
            printTitle();
            printInstructions();
            int userChoice = scan.nextInt();
            scan.nextLine();
            switch (userChoice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    addPlanet();
                    break;
                case 2:
                    printPlanets();
                    break;
                case 3:
                    addMoon();
                    break;
                case 4:
                    printMoons();
                    break;
                case 5:
                    flag = false;
                default:
                    System.out.println("Wrong choice: 1 - 5");
            }
        }

    }

    public static void printTitle() {
        System.out.println("<<<<<<<<<<<<<<<<Welcome to the Planet App>>>>>>>>>>>>>>>>");
    }

    public static void printInstructions() {
        System.out.println("0 -> Print Instructions");
        System.out.println("1 -> Add Planet");
        System.out.println("2 -> Print Planets");
        System.out.println("3 -> Add Moon");
        System.out.println("4 -> Print Moons");
        System.out.println("5 -> Quit Application");
    }

    public static void addPlanet() {
        System.out.println("Enter planet name: ");
        String name = scan.nextLine();
        System.out.println("Enter orbital Period: ");
        int orbitalPeriod = scan.nextInt();
        Planet planet = new Planet(name, orbitalPeriod);
        solarSystem.put(planet.getName(), planet);
    }

    public static void printPlanets() {
        for (String planet : solarSystem.keySet()) {
            System.out.println(planet);
        }
    }

    public static void addMoon() {
        boolean check = true;
        Planet planet;
        System.out.println("Enter name of planet you would like to add a moon to: ");
        String userPlanet = scan.nextLine();
        for (String planets : solarSystem.keySet()) {
            if (userPlanet.equals(planets)) {
                planet = (Planet) solarSystem.get(planets);
                System.out.println("Enter name of moon: ");
                String name = scan.nextLine();
                System.out.println("Enter orbital period");
                int orbitalPeriod = scan.nextInt();
                scan.nextLine();
                planet.addMoon(name, orbitalPeriod);
                check = false;
            }
        }

        if(!check){
            System.out.println("Moon successfully added");
        }else{
            System.out.println("Moon was not added");
        }
    }

    public static void printMoons() {
        boolean check = true;
        System.out.println("Enter planet name to list moons");
        String planet = scan.nextLine();
        for (String planets : solarSystem.keySet()) {
            if (planet.equalsIgnoreCase(planets)) {
                Planet planet1 = (Planet) solarSystem.get(planet);
                planet1.printMoons();
                check = false;
            }

        }

        if(check){
            System.out.println("Planet could not be found. Please add it.");
        }
    }
}


