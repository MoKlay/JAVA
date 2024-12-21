package com.example.Stage_5;

import com.example.Stage_5.BlueRayDisc.CatalogEntry;
import java.util.ArrayList;
import java.util.List;


/*
 * Создать класс BlueRayDisc с внутренним классом, с помощью объектов 
 * которого можно хранить информацию о каталогах, подкаталогах и записях.
 */

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

    public void addSubEntry(String name, String type) {
      CatalogEntry entry = new BlueRayDisc.CatalogEntry(name, type);
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
      return "CatalogEntry { name='" + name + 
      "', type='" + type + "' }";
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

  public static class Types {
    public static final String DIRECTORY = "directory";
    public static final String SUBDIRECTORY = "subdirectory";
    public static final String FILE = "file";
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Disc title: ").append(discTitle).append("\n");
    sb.append("Catalog entries:\n");

    printCatalog(rootCatalog, 0, sb);

    return sb.toString();
  }

  // Вспомогательная функция для печати структуры каталога
  private static String printCatalog(List<CatalogEntry> entries, int indentLevel, StringBuilder sb) {
    for (CatalogEntry entry : entries) {
      for (int i = 0; i < indentLevel; i++) {
        sb.append("  ");
      }
      sb.append(entry).append("\n");
      if (entry.getType().equals("directory") || entry.getType().equals("subdirectory")) {
        printCatalog(entry.getSubEntries(), indentLevel + 1, sb);
      }
    }
    return sb.toString();
  }
}

public class Main {
  public static void main(String[] args) {
    BlueRayDisc disc = new BlueRayDisc("My Movie Collection");

    // Создаем корневой каталог
    BlueRayDisc.CatalogEntry root = new BlueRayDisc.CatalogEntry("Movies", BlueRayDisc.Types.DIRECTORY);
    disc.addRootCatalogEntry(root);

    // Создаем подкаталоги
    root.addSubEntry("Action", BlueRayDisc.Types.SUBDIRECTORY);
    root.addSubEntry("Comedy", BlueRayDisc.Types.SUBDIRECTORY);

    // Добавляем записи (файлы)
    root.addSubEntry("Terminator.mkv", BlueRayDisc.Types.FILE);
    root.addSubEntry("Shrek.mkv", BlueRayDisc.Types.FILE);

    System.err.println(disc);
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
