/*Реализовать класс, описывающий комплексное число (действительная и мнимая часть
        должны иметь точность double). Должны быть доступны следующие операции:
        1. Cоздание нового числа по действительной части (конструктор с 1
        параметром)
        2. Создание нового числа по действительной и мнимой части (конструктор
        с 2 параметрами)
        3. Сложение
        4. Вычитание
        5. Умножение
        6. Операция получения модуля
        7. преобразование в строку (toString)
        (арифметические действия должны создавать новый экземпляр класса)
        Написать код, демонстрирующий работу с созданными классами
*/

package complexnum;

public class ComplexTest {

    public static void main(String[] args) {

        // создаем комплексное число 2+3i
        ComplexNumber num1 = new ComplexNumber(2, 3);

        // создаем комплексное число 4-5i
        ComplexNumber num2 = new ComplexNumber(4, -5);

        // выводим числа на экран
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        // складываем числа
        ComplexNumber sum = num1.add(num2);
        System.out.println("sum = " + sum);

        // вычитаем числа
        ComplexNumber diff = num1.subtract(num2);
        System.out.println("diff = " + diff);

        // умножаем числа
        ComplexNumber multiply = num1.multiply(num2);
        System.out.println("multiply = " + multiply);

        // находим модуль первого числа
        double mod = num1.abs();
        System.out.println("mod of num1 = " + mod);
    }
}
