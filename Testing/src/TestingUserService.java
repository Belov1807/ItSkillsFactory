/**
 * Интерфейс пользователя.
 */
public interface TestingUserService
{
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
