package HashMapTP2;

public class Main {
    public static void main(String[] args) {
        EpicDoubleHashMap<Integer, Integer, String> pantoneMap = new EpicDoubleHashMap<>();

        pantoneMap.addCode(2, 456);
        pantoneMap.addCode(1, 123);
        pantoneMap.addCode(4, 142);
        pantoneMap.addCode(6, 152);

        pantoneMap.removeCode(1);

        pantoneMap.addColor(1, "Blue");
        pantoneMap.addColor(2, "Yellow");
        pantoneMap.addCodeAndColor(3, 141, "Red");

        System.out.println("Codes");
        System.out.println(pantoneMap.getCodes());

        System.out.println("Colors");
        System.out.println(pantoneMap.getColors());

        System.out.println("Codes and colors");
        System.out.println(pantoneMap.getCodeAndColor());

        //EXTRA FUNCTIONALITIES
        // Quantity of Values (Codes and Colors)

        System.out.println(pantoneMap.quantityOfValues());

        System.out.println("\n");

        System.out.println(pantoneMap.repMap());

        System.out.println("Existen " +pantoneMap.valuesRepeated(1) + " valores repetidos");
    }
}
