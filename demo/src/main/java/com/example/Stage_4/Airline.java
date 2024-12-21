package com.example.Stage_4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Airline {
  public static class Airplane {
    protected String model;
    protected int seats;
    protected int carryingCapacity;
    protected int flightRange;
    protected double fuelConsumption;

    public Airplane(String model, int seats, int carryingCapacity, int flightRange, double fuelConsumption) {
      this.model = model;
      this.seats = seats;
      this.carryingCapacity = carryingCapacity;
      this.flightRange = flightRange;
      this.fuelConsumption = fuelConsumption;
    }

    public int getSeats() {
      return seats;
    }

    public int getCarryingCapacity() {
      return carryingCapacity;
    }

    public int getFlightRange() {
      return flightRange;
    }

    public double getFuelConsumption() {
      return fuelConsumption;
    }

    @Override
    public String toString() {
      return "Model: " + model + ", Seats: " + seats + ", Carrying Capacity: " + carryingCapacity +
          " kg, Flight Range: " + flightRange + " km, Fuel Consumption: " + fuelConsumption + " l/km";
    }
  }

  public static class PassengerAirplane extends Airplane {
    private boolean businessClass;

    public PassengerAirplane(String model, int seats, int carryingCapacity, int flightRange, double fuelConsumption,
        boolean businessClass) {
      super(model, seats, carryingCapacity, flightRange, fuelConsumption);
      this.businessClass = businessClass;
    }

    @Override
    public String toString() {
      return super.toString() + ", Business Class: " + businessClass;
    }

    public boolean isBusinessClass() {
      return businessClass;
    }

    public void setBusinessClass(boolean businessClass) {
      this.businessClass = businessClass;
    }
  }

  public static class CargoAirplane extends Airplane {
    private int maxCargoWeight;

    public CargoAirplane(String model, int carryingCapacity, int flightRange, double fuelConsumption,
        int maxCargoWeight) {
      super(model, 0, carryingCapacity, flightRange, fuelConsumption); // 0 мест для пассажиров
      this.maxCargoWeight = maxCargoWeight;
    }

    @Override
    public String toString() {
      return super.toString() + ", Max Cargo Weight: " + maxCargoWeight + " kg";
    }

    public int getMaxCargoWeight() {
      return maxCargoWeight;
    }

    public void setMaxCargoWeight(int maxCargoWeight) {
      this.maxCargoWeight = maxCargoWeight;
    }
  }

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
