package Stage_5;

import Stage_5.BlueRayDisc.CatalogEntry;
import java.util.ArrayList;
import java.util.List;

class BlueRayDisc {
  private String discTitle;
  private final List<CatalogEntry> rootCatalog;

  public BlueRayDisc(String discTitle) {
    this.discTitle = discTitle;
    this.rootCatalog = new ArrayList<>();
  }

  public void addRootCatalogEntry(CatalogEntry entry) {
    rootCatalog.add(entry);
  }

  public List<CatalogEntry> getRootCatalog() {
    return rootCatalog;
  }

  public String getDiscTitle() {
    return discTitle;
  }

  // Внутренний класс для хранения информации о каталогах, подкаталогах и записях
  public static class CatalogEntry {
    private String name;
    private String type; // "directory", "subdirectory", "file"
    private final List<CatalogEntry> subEntries; // Только для каталогов и подкаталогов

    public CatalogEntry(String name, String type) {
      this.name = name;
      this.type = type;
      this.subEntries = new ArrayList<>(); // Инициализируем список подэлементов
    }

    public void addSubEntry(CatalogEntry entry) {
      if (type.equals("directory") || type.equals("subdirectory")) {
        subEntries.add(entry);
      } else {
        throw new IllegalStateException("Cannot add subentries to a file.");
      }
    }

    public List<CatalogEntry> getSubEntries() {
      return subEntries;
    }

    public String getName() {
      return name;
    }

    public String getType() {
      return type;
    }

    @Override
    public String toString() {
      return "CatalogEntry{" +
          "name='" + name + '\'' +
          ", type='" + type + '\'' +
          '}';
    }

    public void setName(String name) {
      this.name = name;
    }

    public void setType(String type) {
      this.type = type;
    }
  }

  public void setDiscTitle(String discTitle) {
    this.discTitle = discTitle;
  }
}

public class Main {
  public static void main(String[] args) {
    BlueRayDisc disc = new BlueRayDisc("My Movie Collection");

    // Создаем корневой каталог
    BlueRayDisc.CatalogEntry root = new BlueRayDisc.CatalogEntry("Movies", "directory");
    disc.addRootCatalogEntry(root);

    // Создаем подкаталоги
    BlueRayDisc.CatalogEntry action = new BlueRayDisc.CatalogEntry("Action", "subdirectory");
    BlueRayDisc.CatalogEntry comedy = new BlueRayDisc.CatalogEntry("Comedy", "subdirectory");
    root.addSubEntry(action);
    root.addSubEntry(comedy);

    // Добавляем записи (файлы)
    BlueRayDisc.CatalogEntry terminator = new BlueRayDisc.CatalogEntry("Terminator.mkv", "file");
    BlueRayDisc.CatalogEntry shrek = new BlueRayDisc.CatalogEntry("Shrek.mkv", "file");
    action.addSubEntry(terminator);
    comedy.addSubEntry(shrek);

    // Выводим структуру каталога
    printCatalog(disc.getRootCatalog(), 0);
  }

  // Вспомогательная функция для печати структуры каталога
  public static void printCatalog(List<CatalogEntry> entries, int indentLevel) {
    for (CatalogEntry entry : entries) {
      for (int i = 0; i < indentLevel; i++) {
        System.out.print("  ");
      }
      System.out.println(entry);
      if (entry.getType().equals("directory") || entry.getType().equals("subdirectory")) {
        printCatalog(entry.getSubEntries(), indentLevel + 1);
      }
    }
  }
}
