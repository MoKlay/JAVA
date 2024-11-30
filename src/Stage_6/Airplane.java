package Stage_6;

public interface Airplane {
  void undergoMaintenance(); // Пройти техосмотр

  void repair(); // Отремонтировать

  void performFlight(String destination); // Осуществить рейс

  void refuel(); // Заправить

  void getAirplaneInfo(); // Получить информацию о самолете

  void setAirplaneInfo(String info); // Изменить информацию о самолете

}
