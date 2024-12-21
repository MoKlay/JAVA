package com.example.Inputs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;

public class Resource {
  public static File getResourceFile(String name) {
    try {
      URL url = Resource.class.getClassLoader().getResource(name);
      File file = new File(url.getFile());
      return file;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  public static InputStream getResourceStream(String name) {
    try {
      InputStream url = Resource.class.getClassLoader().getResourceAsStream(name);
      return url;
    } catch (Exception e) {
      throw new RuntimeException("Resource not found: " + name);
    }
  }
  public static BufferedReader getBufferedReader(String name) throws FileNotFoundException {
    URL url = Resource.class.getClassLoader().getResource(name);
    return new BufferedReader(new FileReader(url.getFile()));
  }
}
