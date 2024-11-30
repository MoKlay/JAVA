package Stage_6;

import Stage_6.AirplaneDMO.CivilAirplane;
import Stage_6.AirplaneDMO.MilitaryAirplane;

public class Main {
  public static void main(String[] args) {
    Airplane civilPlane = new CivilAirplane("Boeing 737", "N737AA");
    Airplane militaryPlane = new MilitaryAirplane("F-22 Raptor", "12345", "AIM-120 AMRAAM");

    civilPlane.performFlight("London");
    civilPlane.getAirplaneInfo();
    civilPlane.setAirplaneInfo("Last Maintenance 10/10/2024");
    civilPlane.getAirplaneInfo();
    if (((CivilAirplane) civilPlane).isNeedsMaintenance()) {
      civilPlane.undergoMaintenance();
    }

    militaryPlane.performFlight("Target Area");
    militaryPlane.getAirplaneInfo();
    militaryPlane.setAirplaneInfo("Status: Ready");
    militaryPlane.getAirplaneInfo();
  }
}
