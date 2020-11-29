/**
 * Интерфейс пользователя.
 */
public interface TestingUserServiceInterface
{
    /**
     * Вход в систему.
     */
    public void login() throws Exception;

    /**
     * Регистрация пользователя.
     */
    public void register();

    /**
     * Выход из системы.
     */
    public void logout() throws Exception;

    /**
     * Устанавливает логин пользователя.
     * @param login логин пользователя.
     */
    public void setLogin(String login);

    /**
     * Устанавливает пароль пользователя.
     * @param password - пароль пользователя.
     */
    public void setPassword(String password);

    /**
     * Устанавливает имя пользователя.
     * @param name - имя пользователя.
     */
    public void setName(String name);
}
