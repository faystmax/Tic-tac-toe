/**
 * Created with IntelliJ IDEA
 * User: Maxim Amosov <faystmax@gmail.com>
 * Date: 18.03.2017
 * Time: 12:49
 *
 *  Класс представляет собой основную логику игры (Tic-tac-toe) Крестики-нолики
 */
public class MainLogic {

    private int demension;          ///< Размерность игры (3x3, 6x6) , должна быть  3 <= demension <= 10

    public int getDemension() {
        return demension;
    }

    public void setDemension(int demension) throws IllegalArgumentException {
        if (demension < 3 || demension > 10) {
            throw new IllegalArgumentException(Integer.toString(demension));
        }
        this.demension = demension;
    }
}
