package snilsvalidator;

public class SnilsValidatorImpl implements SnilsValidator {

    @Override
    public boolean validate(String snils) {
        if (snils == null || snils.length() != 11 || !snils.matches("\\d+")) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (snils.charAt(i) - '0') * (9 - i);
        }

        int controlNumber = sum < 100 ? sum : sum == 100 ? 0 : sum % 101;
        return controlNumber == Integer.parseInt(snils.substring(9));
    }
}
