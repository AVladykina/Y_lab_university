package filesort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class Sorter {
    public File sortFile(File dataFile) throws IOException {
        Scanner scanner = new Scanner(dataFile);
        long[] block = new long[10_000_000];
        int i = 0;
        int blockIndex = 0;
        while (scanner.hasNextLong()) {
            if (i == block.length) {
                writeFile(blockIndex++, block, i);
                i = 0;
            }
            long n = scanner.nextLong();
            block[i++] = n;
        }
        if (i > 0) {
            writeFile(blockIndex++, block, i);
        }
        scanner.close();
        return mergeRange(0, blockIndex);

    }

    private void writeFile(int fileIndex, long[] array, int arrayLength) throws FileNotFoundException {
        Arrays.sort(array, 0, arrayLength);
        File file = new File(String.valueOf(fileIndex));
        try (PrintWriter pw = new PrintWriter(file)) {
            for (int j = 0; j < arrayLength; j++) {
                pw.println(array[j]);
            }
            pw.flush();
        }
    }

    private File mergeFiles(File file1, File file2) throws FileNotFoundException {
        File file = new File(UUID.randomUUID().toString());
        try (Scanner scanner1 = new Scanner(file1);
             Scanner scanner2 = new Scanner(file2);
             PrintWriter pw = new PrintWriter(file)
        ) {
            long number1 = scanner1.nextLong();
            long number2 = scanner2.nextLong();
            Scanner tail;
            for (; ; ) {
                if (number1 <= number2) {
                    pw.println(number1);
                    if (!scanner1.hasNextLong()) {
                        tail = scanner2;
                        break;
                    }
                    number1 = scanner1.nextLong();

                } else {
                    pw.println(number2);
                    if (!scanner2.hasNextLong()) {
                        tail = scanner1;
                        break;
                    }
                    number2 = scanner2.nextLong();
                }
            }
            while (tail.hasNextLong()) {
                pw.println(tail.nextLong());
            }
            pw.flush();
        }
        file1.delete();
        file2.delete();
        return file;
    }

    private File mergeRange(int begin, int end) throws FileNotFoundException {
        if (end - begin > 2) {
            int mid = (end - begin) / 2 + begin;
            return mergeFiles(mergeRange(begin, mid), mergeRange(mid, end));
        }
        if (end - begin == 2) {
            File file1 = new File(String.valueOf(begin));
            File file2 = new File(String.valueOf(end - 1));
            return mergeFiles(file1, file2);
        }
        return new File(String.valueOf(begin));
    }
}
