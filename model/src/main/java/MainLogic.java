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
    private int gameResult;         ///< Результат игры (0 - игра идёт либо ещё не началась, 1 - победили крестики, 0 - победили нолики)

    /**
     * Инициализация логики
     */
    MainLogic() {
        demension = 3;
        start = false;
        gameResult = 0;
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
        gameResult = 0;

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
     * Основной метод хода игры
     *
     * @param x      - координата x      (0<=x<=demension)
     * @param y      - координата y      (0<=x<=demension)
     * @param player - игрок (1 - крестик,  2 -нолик)
     * @return int    0 - игра идёт,  1 - победили крестики, 2 - победили нолики
     * @throws ArrayIndexOutOfBoundsException x или y за границами допустимых значений
     * @throws IllegalStateException          ход сделан на ячеку, на которую уже ходили
     * @throws IllegalArgumentException       не аерный ввод 1,2
     */
    public int moveAt(int x, int y, int player) throws ArrayIndexOutOfBoundsException, IllegalStateException, IllegalArgumentException {
        if (x < 0 || x > demension ||
                y < 0 || y > demension) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (player != 1 && player != 2) {
            throw new IllegalArgumentException();
        }
        if (gameField[x][y] != 0) {
            throw new IllegalStateException();
        }
        gameField[x][y] = player;

        gameResult = CheckWinner();
        return gameResult;
    }

    private int CheckWinner() {
        return 0;
    }
}
