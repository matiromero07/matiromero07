package HashMapTP2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EpicDoubleHashMap<K extends Number, Codes, Colors> {
    HashMap<K, Codes> map1;
    HashMap<K, Colors> map2;

    boolean ban = false;

    public EpicDoubleHashMap() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }

    int contCodes = 0;

    public void addCode(K key, Codes code) {
        int var = 0;
        try {
            if (map1.containsKey(key)) {
                throw new RuntimeException("Ya existe la key, proba con otra");
            } else {
                Set<K> keys = map1.keySet();
                for (K key2 : keys) {
                    if (map1.get(key2).equals(code)) {
                        var++;
                    }
                }
                if (var >= 2) {
                    contCodes = 0;
                    throw new RuntimeException("Se repite 3 o mas veces el codigo: " + code);
                }
            }
            map1.put(key, code);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeCode(K key) {
        try {
            if (map1.containsKey(key)) {
                map1.remove(key);
                System.out.println("La key " + key + " fue removida");
            } else {
                throw new RuntimeException("La key no existe, no se puede remover");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void exists3times(Codes code) {
        int contCodes = 0;
        try {

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addColor(K key, Colors color) {
        int var = 0;

        try {
            if (map2.containsKey(key)) {
                throw new RuntimeException("Ya existe la key, proba con otra");
            } else {
                Set<K> keys = map2.keySet();
                for (K key2 : keys) {
                    if (map2.get(key2).equals(color)) {
                        var++;
                    }
                }
                if (var >= 2) {
                    try {
                        throw new RuntimeException("El value se repite 3 veces");
                    } catch (RuntimeException re) {
                        System.out.println("Error al agregar color: " + re.getMessage());
                    }
                }
            }
            map2.put(key, color);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addCodeAndColor(K key, Codes code, Colors color) {
        map1.put(key, code);
        map2.put(key, color);
    }

    public String getCodes() {
        String code = "";
        for (Map.Entry<K, Codes> entry : map1.entrySet()) {
            code += entry.getKey() + " = " + entry.getValue() + "\n";
        }
        return code;
    }

    public String getColors() {
        String color = "";
        for (Map.Entry<K, Colors> entry : map2.entrySet()) {
            color += entry.getKey() + " = " + entry.getValue() + "\n";
        }
        return color;
    }

    public String getCodeAndColor() {

        String code = "";
        String color = "";

        for (Map.Entry<K, Codes> entry : map1.entrySet()) {
            code += entry.getKey() + " = " + entry.getValue() + "\n";
        }

        for (Map.Entry<K, Colors> entry : map2.entrySet()) {
            color += entry.getKey() + " = " + entry.getValue() + "\n";
        }

        return code + color;
    }

    //EXTRA FUNCTIONALITIES
    // QUANTITY OF CODES AND COLORS

    public String quantityOfValues() {
        int numberOfCodes = 0;
        for (K i : map1.keySet()) {
            map1.get(i);
            numberOfCodes++;
            // System.out.println(map1.get(i));
        }
        int numberOfColors = 0;
        for (K i : map2.keySet()) {
            map2.get(i);
            numberOfColors++;
            // System.out.println(map2.get(i));
        }

        String quantityOfValues;
        String moreCodes = "Hay mas codigos que colores";
        String moreColors = "Hay mas colores que codigos";
        String sameQuantityValues = "Hay la misma cantidad de colores que de codigos";
        quantityOfValues = (numberOfCodes > numberOfColors) ? moreCodes : (numberOfCodes < numberOfColors) ? moreColors : sameQuantityValues;

        return "Cantidad de codigos: " + String.valueOf(numberOfCodes) + "\n" + "Cantidad de colores: " + String.valueOf(numberOfColors) + "\n" + quantityOfValues;

    }

    public int valuesRepeated(K key) {
        int c = 0;
        Set<K> keys = map1.keySet();
        Set<K> keys2 = map2.keySet();
        for (K key2 : keys) {
            if (map1.get(key2).equals(keys)) {
                c++;
            }
        }
        for (K key3 : keys2) {
            if (map2.get(key3).equals(keys2)) {
                c++;
            }
        }
        return c;
    }

    public boolean repMap() {
        int c = 0;
        for (Codes code : map1.values()) {
            c = 0;
            for (Codes code1 : map1.values()) {
                if (code.equals(code1)) {
                    c++;
                }
                if (c > 1) {
                    return true;
                }
            }
        }
        for (Colors color : map2.values()) {
            c = 0;
            for (Colors color1 : map2.values()) {
                if (color.equals(color1)) {
                    c++;
                }
                if (c > 1) {
                    return true;
                }
            }
        }
        return ban;
    }


//    public int valuesRepeated2(Codes code) {
//        int var = 0;
//        Set<K> keys = map1.keySet();
//        for (K key2 : keys) {
//            if (map1.get(key2).equals(code)) {
//                var++;
//            }
//        }
//        return var;
//    }
}