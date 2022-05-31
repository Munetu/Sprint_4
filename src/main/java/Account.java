import lombok.NonNull;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
                 в строке не меньше 3 и не больше 19 символов,
                 в строке есть только один пробел,
                 пробел стоит не в начале и не в конце строки.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */

        return checkNameLength(name) && checkNameStartsNEndsWithSpace(name) && checkNameHasOnlyOneSpace(name);
    }

    public boolean checkNameLength(@NonNull String name) {
        return name.length() >= 3 && name.length() <= 19;
    }

    public boolean checkNameStartsNEndsWithSpace(@NonNull String name) {
        return !name.startsWith(" ") && !name.endsWith(" ");
    }

    public boolean checkNameHasOnlyOneSpace(@NonNull String name) {
        int i = name.indexOf(" ");
        int count = 0;
        while (i != -1 && count < 2) {
            i = name.indexOf(" ", i + 1);
            count += 1;
        }
        return count == 1;
    }
}
