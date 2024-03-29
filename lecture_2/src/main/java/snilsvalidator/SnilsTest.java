/* Номер СНИЛС состоит из 11 цифра, и валидация номера СНИЛС выполняется по
        следующим правилам:
        Алгоритм проверки контрольного числа
        Вычислить сумму произведений цифр СНИЛС (с 1-й по 9-ю) на следующие коэффициенты — 9, 8, 7, 6, 5, 4, 3, 2, 1 (т.е. номера цифр в обратном порядке).
        Вычислить контрольное число от полученной суммы следующим образом:
        если она меньше 100, то контрольное число равно этой сумме;
        если равна 100, то контрольное число равно 0;
        если больше 100, то вычислить остаток от деления на 101 и далее:
        если остаток от деления равен 100, то контольное число равно 0;
        в противном случае контрольное число равно вычисленному остатку от деления.
        Сравнить полученное контрольное число с двумя младшими разрядами СНИЛС. Если они равны, то СНИЛС верный.

 */

package snilsvalidator;

public class SnilsTest {

    public static void main(String[] args) {

        System.out.println(new SnilsValidatorImpl().validate("01468870570"));
        System.out.println(new SnilsValidatorImpl().validate("90114404441"));

    }
}
