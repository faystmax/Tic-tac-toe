import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA
 * User: Maxim Amosov <faystmax@gmail.com>
 * Date: 18.03.2017
 * Time: 12:53
 */
public class MainLogicTest {

    private MainLogic mainLogic;            ///< Экземпляр класса Основной логики игры

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

    @Test(expected = IllegalStateException.class)
    public void setDimension_5_whileGameStarts() {
        mainLogic.startGame();
        mainLogic.setDemension(5);
    }

    //endregion

    //region Тесты на isStart

    @Test
    public void isStartGame() {
        mainLogic.stopGame();
        mainLogic.startGame();
        assertTrue(mainLogic.isStart());
    }

    @Test
    public void isStopGame() {
        mainLogic.stopGame();
        assertFalse(mainLogic.isStart());
    }

    @Test(expected = IllegalStateException.class)
    public void doubleStart() {
        mainLogic.startGame();
        mainLogic.startGame();
    }

    @Test
    public void doubleEnd() {
        mainLogic.stopGame();
        mainLogic.stopGame();
    }

    //endregion

    //region Тесты на ход игры(moveAt)

    @Test
    public void moveAt_0_0_AndCheckReturn0() {
        mainLogic.stopGame();
        mainLogic.setCountToWin(3);
        mainLogic.startGame();
        assertEquals(0, mainLogic.moveAt(0, 0, 1));
    }

    @Test(expected = IllegalStateException.class)
    public void moveAtSameCell() {
        mainLogic.stopGame();
        mainLogic.setCountToWin(3);
        mainLogic.startGame();
        mainLogic.moveAt(0, 0, 1);
        mainLogic.moveAt(0, 0, 2);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void moveAtCellOutOf() {
        mainLogic.stopGame();
        mainLogic.setCountToWin(3);
        mainLogic.startGame();
        mainLogic.moveAt(-1, -2, 1);
    }

    @Test
    public void moveAtAndCheckIfGameEnds() {
        mainLogic.stopGame();
        mainLogic.setCountToWin(3);
        mainLogic.startGame();
        mainLogic.moveAt(0, 0, 1);
        mainLogic.moveAt(0, 1, 1);
        assertEquals(1, mainLogic.moveAt(0, 2, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void moveAtWhithIlegalArgument() {
        mainLogic.stopGame();
        mainLogic.setCountToWin(3);
        mainLogic.startGame();
        mainLogic.moveAt(0, 0, 0);
        mainLogic.moveAt(1, 1, 3);
        mainLogic.moveAt(2, 2, -1);
    }

    @Test
    public void moveAtAndCheckIfKrestWin() {
        mainLogic.stopGame();
        mainLogic.setDemension(3);
        mainLogic.setCountToWin(3);
        mainLogic.startGame();
        mainLogic.moveAt(0, 0, 1);
        mainLogic.moveAt(0, 1, 2);
        mainLogic.moveAt(0, 2, 1);
        mainLogic.moveAt(1, 0, 2);
        mainLogic.moveAt(1, 1, 1);
        mainLogic.moveAt(1, 2, 2);
        mainLogic.moveAt(2, 0, 1);
        mainLogic.moveAt(2, 1, 2);
        assertEquals(1, mainLogic.moveAt(2, 2, 1));
    }

    @Test
    public void moveAtAndCheckIfBraw() {
        mainLogic.stopGame();
        mainLogic.setDemension(3);
        mainLogic.setCountToWin(3);
        mainLogic.startGame();
        mainLogic.moveAt(0, 0, 1);
        mainLogic.moveAt(0, 1, 2);
        mainLogic.moveAt(0, 2, 1);
        mainLogic.moveAt(1, 0, 2);
        mainLogic.moveAt(1, 1, 1);
        mainLogic.moveAt(1, 2, 1);
        mainLogic.moveAt(2, 0, 2);
        mainLogic.moveAt(2, 1, 1);
        assertEquals(3, mainLogic.moveAt(2, 2, 2));
    }

    //endregion

    //region Тесты на countToWin

    @Test(expected = IllegalArgumentException.class)
    public void setWrongCountToWin_0() {
        mainLogic.stopGame();
        mainLogic.setDemension(3);
        mainLogic.setCountToWin(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setWrongCountToWin_5() {
        mainLogic.stopGame();
        mainLogic.setDemension(3);
        mainLogic.setCountToWin(5);
    }

    @Test
    public void setRightCountToWin_3() {
        mainLogic.stopGame();
        mainLogic.setDemension(3);
        mainLogic.setCountToWin(3);
        assertEquals(3, mainLogic.getCountToWin());
    }

    @Test
    public void setRightCountToWin_5_WhithDemension3() {
        mainLogic.stopGame();
        mainLogic.setDemension(5);
        mainLogic.setCountToWin(3);
        assertEquals(3, mainLogic.getCountToWin());
    }

    @Test(expected = IllegalStateException.class)
    public void setRightCountToWinWhenGameStart() {
        mainLogic.stopGame();
        mainLogic.setDemension(5);
        mainLogic.setCountToWin(3);
        mainLogic.startGame();
        mainLogic.setCountToWin(4);
    }

    //endregion
}