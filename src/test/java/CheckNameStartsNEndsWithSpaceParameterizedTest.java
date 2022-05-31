import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CheckNameStartsNEndsWithSpaceParameterizedTest {

    private final String nameSurname;
    private final boolean expectedBoolean;

    public CheckNameStartsNEndsWithSpaceParameterizedTest(String nameSurname, boolean expectedBoolean){
        this.nameSurname = nameSurname;
        this.expectedBoolean = expectedBoolean;
    }

    @Parameterized.Parameters(name = "Тестовые данные: имя фамилия {0}, ожидаемый результат {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"name", true},
                {" name", false},
                {"name ", false},
                {"na me", true}
        };
    }

    @Test
    public void checkNameStartsNEndsWithSpaceReturnsExpectedBoolean(){
        Account account = new Account(nameSurname);
        Assert.assertEquals("Вернулось неправильное логическое значение", expectedBoolean, account.checkNameStartsNEndsWithSpace(nameSurname));
    }
}
