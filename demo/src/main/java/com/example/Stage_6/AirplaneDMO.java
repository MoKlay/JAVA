package com.example.Stage_6;

abstract class abstractAirplane implements Airplane {
  protected String model;
  protected String registrationNumber;
  protected String info;

  public abstractAirplane(String model, String registrationNumber) {
    this.model = model;
    this.registrationNumber = registrationNumber;
    this.info = "";
  }

  public abstract void undergoMaintenance();

  public abstract void repair();

  public abstract void performFlight(String destination);

  public abstract void refuel();

  public abstract void getAirplaneInfo();

  public abstract void setAirplaneInfo(String info);

  @Override
  public String toString() {
    return "Model: " + model + ", Registration Number: " + registrationNumber;
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

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }
}

public class AirplaneDMO {
  public static class CivilAirplane extends abstractAirplane {
    private int flightHours;
    private boolean needsMaintenance;

    public CivilAirplane(String model, String registrationNumber) {
      super(model, registrationNumber);
      this.flightHours = 0;
      this.needsMaintenance = false;
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
      return super.toString() + ", Flight Hours: " + flightHours;
    }
  }

  public static class MilitaryAirplane extends abstractAirplane {
    private String weaponSystem;

    public MilitaryAirplane(String model, String registrationNumber, String weaponSystem) {
      super(model, registrationNumber);
      this.weaponSystem = weaponSystem;
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
      return super.toString() + ", Weapon System: " + weaponSystem;
    }
  }
}
