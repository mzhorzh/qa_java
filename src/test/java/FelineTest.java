import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class FelineTest {

    //Набор параметров для переменных kittensCount и expectedKittensCount
    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {1, 1},
                {2, 2},
                {3, 3}
        };
    }

    // Объявляем переменные
    private final int kittensCount;
    private final int expectedKittensCount;

    //Конструктор для тестовых данных
    public FelineTest(int kittensCount, int expectedKittensCount) {
        this.kittensCount = kittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    //Проверка того что метод getFamily возвращает "Кошачьи"
    @Test
    public void checkGetFamilyReturnFeline() {
        Feline feline = new Feline();
        Assert.assertEquals("Вызываемый метод должен вернуть \"Кошачьи\" ", "Кошачьи", feline.getFamily());
    }

    //Проверка того что для вида "Хищник" вызывается метод getFood
    @Test
    public void eatMeatGetFoodCalledWithХищник() throws Exception {
        Feline spyFeline = Mockito.spy(new Feline());
        spyFeline.eatMeat();
        Mockito.verify(spyFeline).getFood("Хищник");
    }

    //Проверка того что метод getKittens без аргументов возвращает 1
    @Test
    public void getKittensNoArgsReturnsOne() {
        Feline feline = new Feline();
        Assert.assertEquals("getKittens() должен вернуть 1",1, feline.getKittens());
    }

    //Проверка того что getKittens(int kittensCount) с использованием тестовых данных возвращает kittensCount
    @Test
    public void testGetKittensWithTestData() {
        Feline feline = new Feline();
        Assert.assertEquals("getKittens(int kittensCount) должен вернуть kittensCount", expectedKittensCount, feline.getKittens(kittensCount));
    }
}
