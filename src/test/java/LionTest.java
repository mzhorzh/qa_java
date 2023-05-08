import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    //Объявдяем мок для семейства кошачих
    @Mock
    Feline feline;

    //Проверка того что конструктор возвращает ошибку если указать "Нет пола"
    @Test(expected = Exception.class)
    public void checkConstructorShowException() throws Exception {
        Lion lion = new Lion("Нет пола", feline);
    }

    //Проверка того что вызывается метод getKittens для семейства кошачьих
    @Test
    public void checkGetKittenMethodCalled() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    //Проверка того что при указании пола льва "Самец" метод doesHaveMane возращает true
    @Test
    public void checkHaveManeReturnTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Assert.assertTrue("", lion.doesHaveMane());
    }

    //Проверка того что при указании пола льва "Самка" метод doesHaveMane возращает false
    @Test
    public void checkHaveManeReturnFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Assert.assertFalse("", lion.doesHaveMane());
    }

    //Проверка того что для вида "Хищник" вызывается метод getFood
    @Test
    public void checkFelineGetFoodCalledWithPredator() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
}
