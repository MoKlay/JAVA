package com.example.Stage_3;

public class Product {
  private final int id;
  private String name;
  private String UPC;
  private String manufacturer;
  private double price;
  private int retentionPeriod;
  private int quantity;

  public Product(int id, String name, String UPC, String manufacturer, double price, int retentionPeriod,
      int quantity) {
    this.id = id;
    this.name = name;
    this.UPC = UPC;
    this.manufacturer = manufacturer;
    this.price = price;
    this.retentionPeriod = retentionPeriod;
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public int getRetentionPeriod() {
    return retentionPeriod;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Product [id=" + id + ", name=" + name + ", UPC=" + UPC + ", manufacturer=" + manufacturer + ", price="
        + price + ", retentionPeriod=" + retentionPeriod + ", quantity=" + quantity + "]";
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setUPC(String uPC) {
    UPC = uPC;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setRetentionPeriod(int retentionPeriod) {
    this.retentionPeriod = retentionPeriod;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

}
