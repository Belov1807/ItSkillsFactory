/**
 * Класс пользователя.
 */
public class TestingUser
{
    /**
     * Логин пользователя.
     */
    private String login = new String();
    /**
     * Пароль пользователя.
     */
    private String password = new String();
    /**
     * Имя пользователя.
     */
    private String name = new String();

    /**
     * Является ли пользователь администратором.
     */
    private boolean userIsAdmin = false;

    /**
     * Конструктор.
     * @param userIsAdmin - является ли пользователь администратором.
     * @param login - логин пользователя.
     */
    public TestingUser(boolean userIsAdmin, String login)
    {
        this.userIsAdmin = userIsAdmin;
        this.login = login;
    }

    /**
     * Конструктор.
     * @param login - логин пользователя.
     */
    public TestingUser(String login)
    {
        userIsAdmin = false;
        this.login = login;
    }

    /**
     * Устанавливает пароль пользователя.
     * @param password - пароль пользователя.
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * Устанавливает имя пользователя.
     * @param name - имя пользователя.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Возвращает логин пользователя.
     * @return логин пользователя.
     */
    public String getLogin()
    {
        return login;
    }

    /**
     * Возвращает пароль пользователя.
     * @return пароль пользователя.
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Возвращает имя пользователя.
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Возвращает является ли пользователь администратором.
     * @return true - пользователь является администратором.
     */
    public boolean isUserIsAdmin()
    {
        return userIsAdmin;
    }

    /**
     * Возвращает статус пользователя.
     * @return - статус пользователя.
     */
    public String getStatusUser()
    {
        if (userIsAdmin == false)
        {
            return TestingConst.STATUS_USER_SIMPLE_USER;
        }
        return TestingConst.STATUS_USER_ADMIN;
    }
}
