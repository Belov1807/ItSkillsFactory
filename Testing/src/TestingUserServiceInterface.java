/**
 * Интерфейс пользователя.
 */
public interface TestingUserServiceInterface
{
    /**
     * Выбор пользователем действия в системе.
     */
    public void selectActionInSystem() throws Exception;

    /**
     * Регистрация пользователя.
     */
    public void register() throws Exception;

    /**
     * Вход в систему.
     */
    public void login() throws Exception;

    /**
     * Выход из системы.
     */
    public void logout() throws Exception;
}
