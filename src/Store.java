import java.util.*;

public class Store {
    public static void main(String[] args) {

        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Модель-1", 8, 512, "Windows", "gray"));
        // Специально ввел повтор, чтобы проверить, будет ли выводиться на печать
        laptops.add(new Laptop("Модель-1", 8, 512, "Windows", "gray"));
        laptops.add(new Laptop("Модель-2", 8, 512, "Windows", "white"));
        laptops.add(new Laptop("Модель-3", 8, 512, "Windows", "black"));
        laptops.add(new Laptop("Модель-4", 16, 1024, "Windows", "gray"));
        laptops.add(new Laptop("Модель-5", 16, 1024, "Windows", "white"));
        laptops.add(new Laptop("Модель-6", 16, 1024, "Windows", "black"));
        laptops.add(new Laptop("Модель-7", 32, 2048, "Windows", "gray"));
        laptops.add(new Laptop("Модель-8", 32, 2048, "Windows", "white"));
        laptops.add(new Laptop("Модель-9", 32, 2048, "Windows", "black"));

        laptops.add(new Laptop("Модель-1", 8, 512, "macOS", "gray"));
        laptops.add(new Laptop("Модель-2", 8, 512, "macOS", "white"));
        laptops.add(new Laptop("Модель-3", 8, 512, "macOS", "black"));
        laptops.add(new Laptop("Модель-4", 16, 1024, "macOS", "gray"));
        laptops.add(new Laptop("Модель-5", 16, 1024, "macOS", "white"));
        laptops.add(new Laptop("Модель-6", 16, 1024, "macOS", "black"));
        laptops.add(new Laptop("Модель-7", 32, 2048, "macOS", "gray"));
        laptops.add(new Laptop("Модель-8", 32, 2048, "macOS", "white"));
        laptops.add(new Laptop("Модель-9", 32, 2048, "macOS", "black"));

        laptops.add(new Laptop("Модель-1", 8, 512, "linux", "gray"));
        laptops.add(new Laptop("Модель-2", 8, 512, "linux", "white"));
        laptops.add(new Laptop("Модель-3", 8, 512, "linux", "black"));
        laptops.add(new Laptop("Модель-4", 16, 1024, "linux", "gray"));
        laptops.add(new Laptop("Модель-5", 16, 1024, "linux", "white"));
        laptops.add(new Laptop("Модель-6", 16, 1024, "linux", "black"));
        laptops.add(new Laptop("Модель-7", 32, 2048, "linux", "gray"));
        laptops.add(new Laptop("Модель-8", 32, 2048, "linux", "white"));
        laptops.add(new Laptop("Модель-9", 32, 2048, "linux", "black"));


        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filter = new HashMap<>();

        System.out.println("Введите цифру, соответствующую для поиска по:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Введите минимальное значение ОЗУ:");
                int minRam = scanner.nextInt();
                filter.put("ram", minRam);
                break;
            case 2:
                System.out.println("Введите минимальный объем ЖД:");
                int minStorage = scanner.nextInt();
                filter.put("hardDisk", minStorage);
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                String os = scanner.next();
                filter.put("os", os);
                break;
            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.next();
                filter.put("color", color);
                break;
            default:
                System.out.println("Некорректный выбор.");
                return;
        }

        Set<Laptop> filteredLaptops = filterLaptops(laptops, filter);

        System.out.println("Выберите ноутбук по заданному фильтру:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
        scanner.close();
    }

    private static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, Object> filter) {
        Set<Laptop> result = new HashSet<>();

        for (Laptop laptop : laptops) {
            if (meetsTheCriteria(laptop, filter)) {
                result.add(laptop);
            }
        }

        return result;
    }

    private static boolean meetsTheCriteria(Laptop laptop, Map<String, Object> filter) {
        for (Map.Entry<String, Object> entry : filter.entrySet()) {
            String criterion = entry.getKey();
            Object value = entry.getValue();

            switch (criterion) {
                case "ram":
                    if (laptop.getRam() < (int) value) {
                        return false;
                    }
                    break;
                case "hardDisk":
                    if (laptop.getHardDisk() < (int) value) {
                        return false;
                    }
                    break;
                case "os":
                    if (!laptop.getOs().equalsIgnoreCase((String) value)) {
                        return false;
                    }
                    break;
                case "color":
                    if (!laptop.getColor().equalsIgnoreCase((String) value)) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }

        return true;
    }
}