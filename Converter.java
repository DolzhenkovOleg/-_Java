import java.util.TreeMap;

public class Converter {
    TreeMap<Character, Integer> olegKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabianKeyMap = new TreeMap<>();

    public Converter() {
        olegKeyMap.put('I', 1);
        //olegKeyMap.put('II', 2);
       // olegKeyMap.put('III', 3);
       // olegKeyMap.put('IV', 4);
        olegKeyMap.put('V', 5);
        //olegKeyMap.put('VI', 6);
       // olegKeyMap.put('VII', 7);
       // olegKeyMap.put('VIII', 8);
       // olegKeyMap.put('IX', 9);
        olegKeyMap.put('X', 10);

        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
       // arabianKeyMap.put(8, "VIII");
      //  arabianKeyMap.put(7, "VII");
      //  arabianKeyMap.put(6, "VI");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
       // arabianKeyMap.put(3, "III");
       // arabianKeyMap.put(2, "II");
        arabianKeyMap.put(1, "I");
    }


    public boolean isOleg(String number) {
        return olegKeyMap.containsKey(number.charAt(0)); //Из String в Chair
    }
    public String intToOleg(int number) {
        String oleg = "";
        int arabianKey;
        do {
            arabianKey = arabianKeyMap.floorKey(number);
            oleg += arabianKeyMap.get(arabianKey);
            number -= arabianKey;
        } while (number !=0);
        return oleg;
    }
    public int olegToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = olegKeyMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = olegKeyMap.get(arr[i]);
            if (arabian < olegKeyMap.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }
}
