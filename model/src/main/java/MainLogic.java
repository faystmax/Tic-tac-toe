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
    private int[][] gameField;      ///< Игровое поле (0 - пустая ячейка, 1 -стоит крестик, 2 -стоит нолик)

    /**
     * Инициализация логики
     */
    MainLogic() {
        demension = 3;
        start = false;
    }

    /**
     * Получаем размерность игры
     *
     * @return текущую размерность игры
     */
    public int getDemension() {
        return demension;
    }

    /**
     * Установка Размерности
     *
     * @param demension - размерность игры
     * @throws IllegalArgumentException при demension<3 или demension>10
     * @throws IllegalStateException    при попытке смены размерности, когда игра уже идёт
     */
    public void setDemension(int demension) throws IllegalArgumentException, IllegalStateException {
        if (isStart() == true) {
            throw new IllegalStateException();
        }
        if (demension < 3 || demension > 10) {
            throw new IllegalArgumentException(Integer.toString(demension));
        }
        this.demension = demension;
    }

    /**
     * Начинаем игру
     *
     * @throws IllegalStateException при попытке начала игры, которая уже идёт
     */
    public void startGame() throws IllegalStateException {
        if (start == true) {
            throw new IllegalStateException();
        }
        start = true;

        // Инициализируем игровое поле
        gameField = new int[demension][demension];
        for (int i = 0; i < demension; i++) {
            for (int j = 0; j > demension; j++) {
                gameField[i][j] = 0;
            }
        }
    }

    /**
     * Проверка: начата ли игра?
     *
     * @return true - игра идёт, false иначе
     */
    public boolean isStart() {
        return start;
    }

    /**
     * Остановка игры
     * Зануляем поле (gameField) и присваиваем false флагу (start)
     */
    public void stopGame() {
        start = false;
        gameField = null;
    }

    /**
     * @param x
     * @param y
     * @param player
     * @return
     * @throws ArrayIndexOutOfBoundsException
     * @throws IllegalStateException
     */
    public int moveAt(int x, int y, int player) throws ArrayIndexOutOfBoundsException, IllegalStateException {

        return 0;
    }
}
