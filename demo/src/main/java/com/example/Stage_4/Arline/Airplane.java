package com.example.Stage_4.Arline;

public class Airplane {
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
