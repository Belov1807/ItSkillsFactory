import java.util.ArrayList;

/**
 * Сервис взаимодействия с пользователем.
 */
public class TestingUserService implements TestingUserServiceInterface
{
    /**
     * Пользователь.
     */
    private TestingUser user = null;

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
     * Список пользователей.
     */
    private ArrayList<TestingUser> usersList = new ArrayList<TestingUser>();

    /**
     * Конструктор.
     */
    public TestingUserService()
    {
        addAdmin();
    }

    /**
     * Вход в систему.
     */
    @Override
    public void login() throws Exception
    {
        TestingUser userTryingLogin = new TestingUser(login);
        userTryingLogin.setPassword(password);

        for (int i = 0; i < usersList.size(); i++)
        {
            TestingUser userAtList = usersList.get(i);
            if (userAtList.getLogin().equals(userTryingLogin.getLogin()) == false)
            {
                throw new Exception("Пользователь не найден");
            }
            else if (userAtList.getPassword().equals(userTryingLogin.getPassword()) == false)
            {
                throw new Exception("Вы ввели неверный пароль");
            }
            else if (userAtList.getLogin().equals(userTryingLogin.getLogin()) == true &&
                    userAtList.getPassword().equals(userTryingLogin.getPassword()) == true)
            {
                user = userAtList;
            }
        }
    }

    /**
     * Регистрация пользователя.
     */
    @Override
    public void register()
    {
        TestingUser registerUser = new TestingUser(login);
        registerUser.setPassword(password);
        registerUser.setName(name);

        usersList.add(registerUser);
    }

    /**
     * Выход из системы.
     */
    @Override
    public void logout()
    {
    }

    /**
     * Добавляет в список Администратора.
     */
    private void addAdmin()
    {
        TestingUser admin = new TestingUser(true, TestingConst.ADMIN_LOGIN);
        admin.setPassword(TestingConst.ADMIN_PASSWORD);
        admin.setName(TestingConst.ADMIN_NAME);

        usersList.add(admin);
    }

    /**
     * Устанавливает логин.
     * @param login логин.
     */
    @Override
    public void setLogin(String login)
    {
        this.login = login;
    }

    /**
     * Устанавливает пароль пользователя.
     * @param password - пароль пользователя.
     */
    @Override
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * Устанавливает имя пользователя.
     * @param name - имя пользователя.
     */
    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Возвращает логин текущего пользователя.
     * @return логин пользователя.
     */
    @Override
    public String getLogin()
    {
        return user.getLogin();
    }
}
