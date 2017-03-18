import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA
 * User: Maxim Amosov <faystmax@gmail.com>
 * Date: 18.03.2017
 * Time: 12:53
 */
public class MainLogicTest {

    MainLogic mainLogic;            ///< Экземпляр класса Основной логики игры

    @Before
    public void setUp() throws Exception {
        mainLogic = new MainLogic();
    }

    //region Тесты на Demension

    @Test(expected = IllegalArgumentException.class)
    public void setDimension_0() {
        mainLogic.setDemension(0);
    }

    @Test
    public void setDimension_3() {
        mainLogic.setDemension(3);
        assertEquals(3, mainLogic.getDemension());
    }

    @Test
    public void setDimension_10() {
        mainLogic.setDemension(10);
        assertEquals(10, mainLogic.getDemension());
    }

    @Test
    public void setDimension_6() {
        mainLogic.setDemension(6);
        assertEquals(6, mainLogic.getDemension());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setDimension_100() {
        mainLogic.setDemension(100);
    }

    //endregion

    //region Тесты на isStart

    @Test
    public void isStartGame(){
        mainLogic.startGame();
        assertTrue(mainLogic.isStart());
    }

    @Test
    public void isStopGame(){
        mainLogic.stopGame();
        assertFalse(mainLogic.isStart());
    }

    //endregion
}