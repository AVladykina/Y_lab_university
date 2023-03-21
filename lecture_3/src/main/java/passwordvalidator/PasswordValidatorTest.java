/*
https://www.examclouds.com/ru/java/java-core-russian/lesson17-tasks
1. Создать статический метод, который принимает на вход три параметра: login,
password и confirmPassword.
2. Login должен содержать только латинские буквы, цифры и знак подчеркивания.
Если login не соответствует - выбросить WrongLoginException с текстом “Логин
содержит недопустимые символы”
3. Длина login должна быть меньше 20 символов. Если login не соответствует этим
требованиям, необходимо выбросить WrongLoginException с текстом “Логин
слишком длинный”
4. Password должен содержать только латинские буквы, цифры и знак
подчеркивания. Если password не соответствует этим требованиям, необходимо
выбросить WrongPasswordException с текстом “Пароль содержит недопустимые
символы”
5. Длина password должна быть меньше 20 символов. Если password не
соответствует этим требованиям, необходимо выбросить
WrongPasswordException с текстом “Пароль слишком длинный”
6. Также password и confirmPassword должны быть равны. Если password не
соответствует этим требованиям, необходимо выбросить
WrongPasswordException с текстом “Пароль и подтверждение не совпадают”
7. WrongPasswordException и WrongLoginException - пользовательские классы
исключения с двумя конструкторами – один по умолчанию, второй принимает
сообщение исключения и передает его в конструктор класса Exception.
8. Обработка исключений проводится внутри метода. Обработка исключений -
вывод сообщения об ошибке консоль
9. Метод возвращает true, если значения верны или false в другом случае.
 */

package passwordvalidator;

public class PasswordValidatorTest {

    public static void main(String[] args) {


        String login = "login";
        String password = "password";
        String confirmPassword = "password";

        if (PasswordValidator.register(login, password, confirmPassword)) {
            System.out.println("Регистрация прошла успешно");
        } else {
            System.out.println("Ошибка при регистрации");
        }
    }

}
