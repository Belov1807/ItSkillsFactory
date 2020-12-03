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

        boolean userFound = false;
        boolean passwordIscCorrect = false;

        for (int i = 0; i < usersList.size(); i++)
        {
            TestingUser userAtList = usersList.get(i);
            if (userAtList.getLogin().equals(userTryingLogin.getLogin()) == true)
            {
                userFound = true;
            }
            if (userFound == true && userAtList.getPassword().equals(userTryingLogin.getPassword()) == true)
            {
                passwordIscCorrect = true;
                user = userAtList;
            }
        }

        if (userFound == false)
        {
            throw new Exception("Пользователь не найден");
        } else if (passwordIscCorrect == false)
        {
            throw new Exception("Вы ввели неверный пароль");
        }
    }

    /**
     * Регистрация пользователя.
     */
    @Override
    public void register() throws Exception
    {
        TestingUser registerUser = new TestingUser(login);
        registerUser.setPassword(password);
        registerUser.setName(name);

        for (int i = 0; i < usersList.size(); i++)
        {
            TestingUser userAtList = usersList.get(i);
            if (userAtList.getLogin().equals(registerUser.getLogin()) == true)
            {
                throw new Exception("Пользователь с таким логином уже есть в системе.");
            }
        }

        usersList.add(registerUser);
    }

    /**
     * Выход из системы.
     */
    @Override
    public void logout()
    {
        System.exit(0);
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

    /**
     * Возвращает является ли пользователь администратором.
     * @return true - пользователь является администратором.
     */
    @Override
    public boolean isUserIsAdmin()
    {
        return user.isUserIsAdmin();
    }
}
