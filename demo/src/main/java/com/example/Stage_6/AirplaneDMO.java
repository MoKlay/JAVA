package com.example.Stage_6;

public class AirplaneDMO {
  public static class CivilAirplane implements Airplane {
    private String model;
    private String registrationNumber;
    private int flightHours;
    private boolean needsMaintenance;
    private String info;

    public CivilAirplane(String model, String registrationNumber) {
      this.model = model;
      this.registrationNumber = registrationNumber;
      this.flightHours = 0;
      this.needsMaintenance = false;
      this.info = "";
    }

    
    @Override
    public void undergoMaintenance() {
      System.out.println(model + " (" + registrationNumber + ") прошел технический осмотр.");
      needsMaintenance = false;
    }

    @Override
    public void repair() {
      System.out.println(model + " (" + registrationNumber + ") отремонтирован.");
    }

    @Override
    public void performFlight(String destination) {
      System.out.println(model + " (" + registrationNumber + ") выполнил рейс в " + destination + ".");
      flightHours++;
      needsMaintenance = flightHours > 100; // Пример: техосмотр требуется после 100 часов полета
    }

    @Override
    public void refuel() {
      System.out.println(model + " (" + registrationNumber + ") заправлен.");
    }

    @Override
    public void getAirplaneInfo() {
      System.out.println("Информация о самолете " + model + " (" + registrationNumber + "): " + info);
    }

    @Override
    public void setAirplaneInfo(String info) {
      this.info = info;
    }

    public int getFlightHours() {
      return flightHours;
    }

    public boolean isNeedsMaintenance() {
      return needsMaintenance;
    }

    
    @Override
    public String toString() {
      return "Model: " + model + ", Registration Number: " + registrationNumber + ", Flight Hours: " + flightHours;
    }


    public String getModel() {
      return model;
    }


    public void setModel(String model) {
      this.model = model;
    }


    public String getRegistrationNumber() {
      return registrationNumber;
    }


    public void setRegistrationNumber(String registrationNumber) {
      this.registrationNumber = registrationNumber;
    }


    public void setFlightHours(int flightHours) {
      this.flightHours = flightHours;
    }


    public void setNeedsMaintenance(boolean needsMaintenance) {
      this.needsMaintenance = needsMaintenance;
    }


    public String getInfo() {
      return info;
    }


    public void setInfo(String info) {
      this.info = info;
    }
  }

  public static class MilitaryAirplane implements Airplane {
    private String model;
    private String registrationNumber;
    private String weaponSystem;
    private String info;

    public MilitaryAirplane(String model, String registrationNumber, String weaponSystem) {
      this.model = model;
      this.registrationNumber = registrationNumber;
      this.weaponSystem = weaponSystem;
      this.info = "";
    }
    @Override
    public void undergoMaintenance() {
      System.out.println(model + " (" + registrationNumber + ") прошел технический осмотр.");
    }

    @Override
    public void repair() {
      System.out.println(model + " (" + registrationNumber + ") отремонтирован.");
    }

    @Override
    public void performFlight(String destination) {
      System.out.println(model + " (" + registrationNumber + ") выполнил боевой вылет в " + destination + ".");
    }

    @Override
    public void refuel() {
      System.out.println(model + " (" + registrationNumber + ") заправлен.");
    }

    @Override
    public void getAirplaneInfo() {
      System.out.println("Информация о самолете " + model + " (" + registrationNumber + "): " + info);
    }

    @Override
    public void setAirplaneInfo(String info) {
      this.info = info;
    }

    public String getWeaponSystem() {
      return weaponSystem;
    }

    
    @Override
    public String toString() {
      return "Model: " + model + ", Registration Number: " + registrationNumber + ", Weapon System: " + weaponSystem;
    }

    public String getModel() {
      return model;
    }

    public void setModel(String model) {
      this.model = model;
    }

    public String getRegistrationNumber() {
      return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
      this.registrationNumber = registrationNumber;
    }

    public void setWeaponSystem(String weaponSystem) {
      this.weaponSystem = weaponSystem;
    }

    public String getInfo() {
      return info;
    }

    public void setInfo(String info) {
      this.info = info;
    }
  }
}
