package com.example.Stage_4.Arline;

public class CargoAirplane extends Airplane {
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