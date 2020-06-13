package com.example.planets;

import java.util.HashSet;
import java.util.Set;

public class Planet extends HeavenlyBody {

    private Set<Moon> moons = new HashSet<>();
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, "Planet");
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getOrbitalPeriod() {
        return super.getOrbitalPeriod();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public void addMoon(String name, double orbitalPeriod){
        moons.add(new Moon(name, orbitalPeriod));
    }

    public void printMoons(){
        for(Moon moon : moons){
            System.out.println(moon.getName() + ": " + moon.getOrbitalPeriod());
        }
    }

    public static class Moon extends HeavenlyBody {

        public Moon(String name, double orbitalPeriod) {
            super(name, orbitalPeriod, "Moon");
        }

    }
}
