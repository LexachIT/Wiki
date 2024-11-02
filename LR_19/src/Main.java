import java.awt.*;

// ClothingSize enumeration
/**
 * Класс,описыввающий размеры одежды.
 */
enum ClothingSize {
    XXS(32),
    XS(34),
    S(36),
    M(38),
    L(40);

    private final int euroSize;

    ClothingSize(int euroSize) {
        this.euroSize = euroSize;
    }

    public String getDescription() {
        return this == XXS ? "Детскый размер" : "Взрослый размер";
    }
}

// Gender Clothing Interfaces
/**
 * Интерфейс, описывающий одетую мужчиной одежду.
 */
interface MenClothing {
    void dressMen();
}
/**
 * Интерйфейс,описывающий одетую женщиной одежду.
 */
interface WomenClothing {
    void dressWomen();
}
/**
 * Класс,описыввающий одежду.
 */
abstract class Clothing {
    int size;
    double cost;
    String color;
}
/**
 * Класс,описыввающий футболку для метода dressMen и dressWomen.
 */
class TShirt extends Clothing implements MenClothing, WomenClothing {
   TShirt (int size,double cost,String color)
   { this.size = size;this.cost = cost;this.color=color;}
    @Override
    public void dressMen() {
System.out.println("Мужчина надевает футболку");
    }

    @Override
    public void dressWomen() {
        System.out.println("Женщина надевает футболку");
    }
}
/**
 * Класс,описыввающий штаны для метода dressMen и метода dressWomen.
 */
class Pants extends Clothing implements MenClothing, WomenClothing {
    Pants (int size,double cost,String color)
    { this.size = size;this.cost = cost;this.color=color;}
    @Override
    public void dressMen() {
        System.out.println("Мужчина надевает штаны");
    }

    @Override
    public void dressWomen() {
        System.out.println("Женщина надевает штаны");
    }
}
/**
 * Класс,описыввающий юбку для метода dressWomen.
 */
class Skirt extends Clothing implements WomenClothing {
    Skirt (int size,double cost,String color)
    { this.size = size;this.cost = cost;this.color=color;}
    @Override
    public void dressWomen() {
        System.out.println("Женщина надевает юбку");
    }
}
/**
 * Класс,описыввающий галстук для метода dressMen.
 */
class Tie extends Clothing implements MenClothing {
    Tie (int size,double cost,String color)
    { this.size = size;this.cost = cost;this.color=color;}
    @Override
    public void dressMen() {
        System.out.println("Мужчина надевает галстук");
    }
}
/**
 * Класс,который отображает информацию, связанную с одеждой.
 */
class Atelier {
    /**
     * Метод,благодаря которому будет отображаться одежда женщины и ее параметры.
     */
    void dressWomen(Clothing[] clothes) {
        for (Clothing item : clothes) {
            if (item instanceof WomenClothing) {
                System.out.println("Одежда женщины: Размер: "+ item.size + ", " +
                        "Цена: " + item.cost + ", " + "Цвет: " + item.color + "\n");
            }
        }
    }
    /**
     * Метод,благодаря которому будет отображаться одежда мужчины и ее параметры.
     */
    void dressMen(Clothing[] clothes) {
        for (Clothing item : clothes) {
            if (item instanceof MenClothing) {
                System.out.println("Одежда мужчины: Размер: "+ item.size + ", " +
                        "Цена: " + item.cost + ", " + "Цвет: " + item.color + "\n");
            }
        }
    }
}
/**
 * Главный класс программы, демонстрирующий работу с массивом объектов класса Student.
 */
class Main {
    /**
     * Главная функция программы.
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        /**
         * Массив объектов класса Cloths, содержащий информацию об одежде.
         */
        Clothing[] Cloths = {
                new TShirt(32,200,"Черный"),
                new Pants(40,320,"Зеленый"),
                new Skirt(36,800,"Темно-синяя"),
                new Tie(38,450,"Красный")
        };
        /**
         * Методы для основной работы приложения.
         */
        Atelier atelier = new Atelier();
        atelier.dressMen(Cloths);
        atelier.dressWomen(Cloths);
    }
}