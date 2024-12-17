package com.example.Stage_6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AirplaneDMOTest {

  private AirplaneDMO.CivilAirplane civilAirplane;
  private AirplaneDMO.MilitaryAirplane militaryAirplane;

  @BeforeEach
  void setUp() {
    civilAirplane = new AirplaneDMO.CivilAirplane("Boeing 737", "N12345");
    militaryAirplane = new AirplaneDMO.MilitaryAirplane("F-16", "M12345", "Missile System");
  }

  @Test
  void testCivilAirplaneInitialValues() {
    assertEquals("Boeing 737", civilAirplane.getModel());
    assertEquals("N12345", civilAirplane.getRegistrationNumber());
    assertEquals(0, civilAirplane.getFlightHours());
    assertFalse(civilAirplane.isNeedsMaintenance());
  }

  @Test
  void testPerformFlightIncrementsFlightHours() {
    civilAirplane.performFlight("New York");
    assertEquals(1, civilAirplane.getFlightHours());
    assertFalse(civilAirplane.isNeedsMaintenance());

    // Simulate more flights
    for (int i = 0; i < 100; i++) {
      civilAirplane.performFlight("Destination " + i);
    }
    assertEquals(101, civilAirplane.getFlightHours());
    assertTrue(civilAirplane.isNeedsMaintenance());
  }

  @Test
  void testUndergoMaintenance() {
    civilAirplane.performFlight("Los Angeles");
    civilAirplane.performFlight("Los Angeles");
    civilAirplane.undergoMaintenance();
    assertFalse(civilAirplane.isNeedsMaintenance());
  }

  @Test
  void testMilitaryAirplaneInitialValues() {
    assertEquals("F-16", militaryAirplane.getModel());
    assertEquals("M12345", militaryAirplane.getRegistrationNumber());
    assertEquals("Missile System", militaryAirplane.getWeaponSystem());
  }

  @Test
  void testMilitaryAirplanePerformFlight() {
    militaryAirplane.performFlight("Enemy Territory");
    // No specific assertions here, just checking if it runs without exceptions
  }

  @Test
  void testSetAndGetInfo() {
    civilAirplane.setAirplaneInfo("This is a commercial airplane.");
    assertEquals("This is a commercial airplane.", civilAirplane.getInfo());

    militaryAirplane.setAirplaneInfo("This is a military airplane.");
    assertEquals("This is a military airplane.", militaryAirplane.getInfo());
  }
}
