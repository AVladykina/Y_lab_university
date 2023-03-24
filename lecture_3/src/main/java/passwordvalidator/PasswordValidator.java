package passwordvalidator;

public class PasswordValidator {

    public static boolean register(String login, String password, String confirmPassword) {
        try {
            // проверяем login
            if (!login.matches("[a-zA-Z0-9_]+")) {
                throw new WrongLoginException("Логин содержит недопустимые символы");
            }
            if (login.length() >= 20) {
                throw new WrongLoginException("Логин слишком длинный");
            }

            // проверяем password
            if (!password.matches("[a-zA-Z0-9_]+")) {
                throw new WrongPasswordException("Пароль содержит недопустимые символы");
            }
            if (password.length() >= 20) {
                throw new WrongPasswordException("Пароль слишком длинный");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароль и подтверждение не совпадают");
            }
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
}
