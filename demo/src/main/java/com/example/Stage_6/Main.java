package com.example.Stage_6;

import com.example.Stage_6.AirplaneDMO.CivilAirplane;
import com.example.Stage_6.AirplaneDMO.MilitaryAirplane;

/*
 * Разработать проект управления процессами на основе создания и реализации интерфейсов для следующих предметных областей:
 * Самолеты. Возможности: 
 *  пройти техосмотр; 
 *  отремонтировать; 
 *  осуществить рейс; 
 *  заправить; 
 *  получить\изменить информацию о транспортном средстве. 
 * Добавить дополнительные возможности для самолета (военного и гражданского самолета).
 */

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
