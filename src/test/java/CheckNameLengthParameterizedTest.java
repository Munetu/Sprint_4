import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CheckNameLengthParameterizedTest {
    private final String nameSurname;
    private final boolean expectedBoolean;

    public CheckNameLengthParameterizedTest(String nameSurname, boolean expectedBoolean){
        this.nameSurname = nameSurname;
        this.expectedBoolean = expectedBoolean;
    }

    @Parameterized.Parameters(name = "Тестовые данные: имя фамилия (количество символов) {0}, ожидаемый результат {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"12", false},
                {"123", true},
                {"1234", true},
                {"1234567890123456789", true},
                {"12345678901234567890", false}
        };
    }

    @Test
    public void checkNameLengthReturnsExpectedBoolean(){
        Account account = new Account(nameSurname);
        Assert.assertEquals("Вернулось неправильное логическое значение", expectedBoolean, account.checkNameLength(nameSurname));
    }
}
