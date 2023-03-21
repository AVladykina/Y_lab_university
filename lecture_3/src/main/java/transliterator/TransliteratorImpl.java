package transliterator;

public class TransliteratorImpl implements Transliterator {

    @Override
    public String transliterate(String source) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            switch (source.charAt(i)) {
                case 'А':
                    output.append('A');
                    break;
                case 'Б':
                    output.append('B');
                    break;
                case 'В':
                    output.append('V');
                    break;
                case 'Г':
                    output.append('G');
                    break;
                case 'Д':
                    output.append('D');
                    break;
                case 'Е':
                    output.append('E');
                    break;
                case 'Ё':
                    output.append('E');
                    break;
                case 'Ë':
                    output.append('E');
                    break;
                case 'Ж':
                    output.append("ZH");
                    break;
                case 'З':
                    output.append('Z');
                    break;
                case 'И':
                    output.append('I');
                    break;
                case 'Й':
                    output.append('I');
                    break;
                case 'К':
                    output.append('K');
                    break;
                case 'Л':
                    output.append('L');
                    break;
                case 'М':
                    output.append('M');
                    break;
                case 'Н':
                    output.append('N');
                    break;
                case 'О':
                    output.append('O');
                    break;
                case 'П':
                    output.append('P');
                    break;
                case 'Р':
                    output.append('R');
                    break;
                case 'С':
                    output.append('S');
                    break;
                case 'Т':
                    output.append('T');
                    break;
                case 'У':
                    output.append('U');
                    break;
                case 'Ф':
                    output.append('F');
                    break;
                case 'Х':
                    output.append("KH");
                    break;
                case 'Ц':
                    output.append("TS");
                    break;
                case 'Ч':
                    output.append("CH");
                    break;
                case 'Ш':
                    output.append("SH");
                    break;
                case 'Щ':
                    output.append("SHCH");
                    break;
                case 'Ъ':
                    output.append("IE");
                    break;
                case 'Ы':
                    output.append('Y');
                    break;
                case 'Ь':
                    break;
                case 'Э':
                    output.append('E');
                    break;
                case 'Ю':
                    output.append("IU");
                    break;
                case 'Я':
                    output.append("IA");
                    break;
                default:
                    output.append(source.charAt(i));
            }
        }
        return String.valueOf(output);
    }
}
