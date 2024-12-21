package com.example.Stage_4.Arline;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Airline {
  private final List<Airplane> airplanes;

  public Airline() {
    this.airplanes = new ArrayList<>();
  }

  public void addAirplane(Airplane airplane) {
    airplanes.add(airplane);
  }

  public int getTotalCapacity() {
    return airplanes.stream().mapToInt(Airplane::getSeats).sum();
  }

  public int getTotalCarryingCapacity() {
    return airplanes.stream().mapToInt(Airplane::getCarryingCapacity).sum();
  }

  public List<Airplane> sortPlanesByFlightRange() {
    return airplanes.stream()
        .sorted(Comparator.comparingInt(Airplane::getFlightRange))
        .collect(Collectors.toList());
  }

  public List<Airplane> findPlanesByFuelConsumption(double minConsumption, double maxConsumption) {
    return airplanes.stream()
        .filter(plane -> plane.getFuelConsumption() >= minConsumption && plane.getFuelConsumption() <= maxConsumption)
        .collect(Collectors.toList());
  }

  public void printAirplanes() {
    airplanes.forEach(System.out::println);
  }
}
