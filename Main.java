import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "*", "/"};
        String[] regexAcions = {"\\+", "-", "\\*", "/"};
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine(); //Определяем арифметическое действие
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (exp.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        //Если не нашли фактического действия, завершаем программу
        if (actionIndex == -1) {
            System.out.println("Некорректное выражение");
            return;
        }
        String[] data = exp.split(regexAcions[actionIndex]); //Возвращаем вводимый пользователем знак
        //Определяем, находятся ли числа в доном формате (оба римские или арабские)
        if (converter.isOleg(data[0]) == converter.isOleg(data[1])) {
            int a, b;
            boolean isOleg = converter.isOleg(data[0]);
            if (isOleg) {
                a = converter.olegToInt(data[0]);
                b = converter.olegToInt(data[1]);
            } else {
                //Конвертируем римские цивры в арабские
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            //Выполняем арифмитические действия
            int result;
            switch (actions[actionIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                default:
                    result = a / b;
                    break;
            }
            if (isOleg) {
                System.out.println(converter.intToOleg(result));
            } else {
                //Усли числа арабские, возвращаем результат в  виде арабского числа
                System.out.println(result);
            }
        }else{
                System.out.println("Числа должны быть в одном формате");
            }
        }
    }
