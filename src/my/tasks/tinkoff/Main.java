package my.tasks.tinkoff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arrayParam = new ArrayList<>();
        int countLine = 0;
        while (countLine < 3 && scanner.hasNextLine()) {
            String innerString = scanner.nextLine();
            countLine++;
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(innerString);
            while (matcher.find()) {
                arrayParam.add(Integer.parseInt(innerString.substring(matcher.start(), matcher.end())));
            }
        }
        // 0 - 1 количество сотрудников и время, когда один из сотрудников покинет офис (в минутах).
        // 2 - 6 В следующей строке n чисел — номера этажей, на которых находятся сотрудники
        //  7    В строке записан номер сотрудника, который уйдет через t минут

        int step;
        int size = arrayParam.size() - 1;
        int employeeForExit = arrayParam.get(1 + arrayParam.get(size));

        if (employeeForExit < arrayParam.get(1)) {
            step = arrayParam.get(size - 1) - 1;
        } else {
            step = employeeForExit - 2 + (arrayParam.get(size - 1));
        }

        System.out.println(step);
    }
}
