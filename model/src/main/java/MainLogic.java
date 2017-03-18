/**
 * Created with IntelliJ IDEA
 * User: Maxim Amosov <faystmax@gmail.com>
 * Date: 18.03.2017
 * Time: 12:49
 * <p>
 * Класс представляет собой основную логику игры (Tic-tac-toe) Крестики-нолики
 */
public class MainLogic {

    private int demension;          ///< Размерность игры (3x3, 6x6) , должна быть  3 <= demension <= 10
    private boolean start;          ///< Переменная символизирующая начало игры (true - игра идёт, false - иначе)

    /**
     * Инициализация логики
     */
    MainLogic() {
        demension = 3;
        start = false;
    }

    /**
     *  Получаем размерность игры
     * @return текущую размерность игры
     */
    public int getDemension() {
        return demension;
    }

    /**
     * Установка Размерности
     * @param demension - размерность игры
     * @throws IllegalArgumentException
     */
    public void setDemension(int demension) throws IllegalArgumentException {
        if (demension < 3 || demension > 10) {
            throw new IllegalArgumentException(Integer.toString(demension));
        }
        this.demension = demension;
    }

    /**
     * Начинаем игру
     * @throws IllegalStateException при попытке начала игры, которая уже идёт
     */
    public void startGame() throws IllegalStateException {
        if(start == true){
            throw new IllegalStateException();
        }
        start=true;
    }

    /**
     * Проверка: начата ли игра?
     * @return true - игра идёт, false иначе
     */
    public boolean isStart() {
        return start;
    }

    /**
     * Остановка игры
     */
    public void stopGame() {
        start = false;
    }
}
