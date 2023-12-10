import java.util.*;

class Laptop {
    private String model;
    private int ram;         //объем ОЗУ
    private int hardDisk;    //объем ЖД
    private String os;
    private String color;

    // Constructor
    public Laptop(String model, int ram, int storage, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.hardDisk = storage;
        this.os = os;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(int hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ноутбук[" +
                "модель='" + model + '\'' +
                ", ОЗУ=" + ram +
                ", объемЖД=" + hardDisk +
                ", ос='" + os + '\'' +
                ", цвет='" + color + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Laptop laptop = (Laptop) obj;
        return model.equals(laptop.model) &&
                ram == laptop.ram &&
                hardDisk == laptop.hardDisk &&
                os.equals(laptop.os) &&
                color.equals(laptop.color);
    }
    @Override
    public int hashCode() {
        return Objects.hash(model, ram, hardDisk, os, color);
    }
}