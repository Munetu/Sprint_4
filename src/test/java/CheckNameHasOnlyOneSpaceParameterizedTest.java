import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CheckNameHasOnlyOneSpaceParameterizedTest {
    private final String nameSurname;
    private final boolean expectedBoolean;

    public CheckNameHasOnlyOneSpaceParameterizedTest(String nameSurname, boolean expectedBoolean){
        this.nameSurname = nameSurname;
        this.expectedBoolean = expectedBoolean;
    }

    @Parameterized.Parameters(name = "Тестовые данные: имя фамилия {0}, ожидаемый результат {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"name", false},
                {"na me", true},
                {"na me ", false}
        };
    }

    @Test
    public void checkNameHasOnlyOneSpaceReturnsExpectedBoolean(){
        Account account = new Account(nameSurname);
        Assert.assertEquals("Вернулось неправильное логическое значение", expectedBoolean, account.checkNameHasOnlyOneSpace(nameSurname));
    }
}
