import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    //Объявдяем мок для семейства кошачих
    @Mock
    Feline feline;

    //Проверка того, что метод getSound возвращает "Мяу"
    @Test
    public void checkCatVoice() {
        Cat cat = new Cat(feline);
        Assert.assertEquals("Метод должен вернуть\"Мяу\" ", "Мяу", cat.getSound());
    }

    //Проверка того, что метод eatMeat вызывается один раз
    @Test
    public void checkEatMeatCalled() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}
