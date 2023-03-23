package transliterator;

public class TransliteratorImpl implements Transliterator {

    private static String[] alphabet = {"A", "B", "V", "G", "D", "E", "ZH", "Z", "I", "I", "K", "L",
            "M", "N", "O", "P", "R", "S", "T", "U", "F", "KH", "TS", "CH", "SH", "SHCH", "IE", "Y", "", "E", "IU", "IA"};

    @Override
    public String transliterate(String source) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (c >= 'А' && c <= 'Я') {
                output.append(alphabet[c - 'А']);
            } else if (c == 'Ë' || c == 'Ё') {
                output.append('E');
            } else {
                output.append(c);
            }
        }
        return String.valueOf(output);
    }
}
