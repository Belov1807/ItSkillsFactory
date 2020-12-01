/**
 * Интерфейс сервиса взаимодействия с пользователем.
 */
public interface TestingUserServiceInterface
{
    /**
     * Вход в систему.
     */
    void login() throws Exception;

    /**
     * Регистрация пользователя.
     */
    void register() throws Exception;

    /**
     * Выход из системы.
     */
    void logout() throws Exception;

    /**
     * Устанавливает логин пользователя.
     * @param login логин пользователя.
     */
    void setLogin(String login);

    /**
     * Устанавливает пароль пользователя.
     * @param password - пароль пользователя.
     */
    void setPassword(String password);

    /**
     * Устанавливает имя пользователя.
     * @param name - имя пользователя.
     */
    void setName(String name);

    /**
     * Возвращает логин пользователя.
     * @return логин пользователя.
     */
    String getLogin();

    /**
     * Возвращает является ли пользователь администратором.
     * @return true - пользователь является администратором.
     */
    boolean isUserIsAdmin();
}
