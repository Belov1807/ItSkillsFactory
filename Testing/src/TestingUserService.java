/**
 * Интерфейс пользователя.
 */
public interface TestingUserService
{
    /**
     * Выбор пользователем действия в системе.
     */
    public void selectActionInSystem();

    /**
     * Регистрация пользователя.
     */
    public void register();

    /**
     * Вход в систему.
     */
    public void login();

    /**
     * Выход из системы.
     */
    public void logout();
}
