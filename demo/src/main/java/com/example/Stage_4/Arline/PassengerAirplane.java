package com.example.Stage_4.Arline;

public class PassengerAirplane extends Airplane {
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
