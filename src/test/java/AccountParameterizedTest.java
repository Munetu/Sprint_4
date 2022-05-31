import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountParameterizedTest {

    private final String nameSurname;
    private final boolean expectedBoolean;

    public AccountParameterizedTest(String nameSurname, boolean expectedBoolean){
        this.nameSurname = nameSurname;
        this.expectedBoolean = expectedBoolean;
    }

    @Parameterized.Parameters(name = "Тестовые данные: имя фамилия (количество символов) {0}, ожидаемый результат {1}")
    public static Object[][] getAccountData() {
        return new Object[][]{
                {"  ", false},      //0 0 0
                {" ", false},       //0 0 1
                {"", false},        //0 1 0
                {"  123", false},   //1 0 0
                                    //ОТСУТСВУЕТ 0 1 1
                {" 1", false},      //1 0 1
                {"123", false},     //1 1 0
                {"12 3", true},    //1 1 1
        };
    }

    @Test
    public void checkNameToEmbossReturnsExpectedBoolean(){
        Account account = new Account(nameSurname);
        Assert.assertEquals("Вернулось неправильное логическое значение", expectedBoolean, account.checkNameToEmboss());
    }
}
