import java.util.ArrayList;
import java.util.Scanner;

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
     * Сервис по работе с тестами.
     */
    private TestingTestService testService = null;

    /**
     * Список пользователей.
     */
    private ArrayList<TestingUser> usersList = new ArrayList<TestingUser>();

    /**
     * Пользователь существует.
     */
    private boolean userFound = false;

    /**
     * Пароль существующего пользователя введен корректно.
     */
    private boolean passwordIsCorrect = false;

    /**
     * Конструктор.
     */
    public TestingUserService()
    {
        addAdmin();
        testService = new TestingTestService();
    }

    /**
     * Регистрация пользователя.
     */
    @Override
    public void register() throws Exception
    {
        System.out.println("Регистрация");

        System.out.println("Введите логин");
        Scanner in = new Scanner(System.in);

        TestingUser registerUser = new TestingUser(in.nextLine());

        System.out.println("Введите пароль");
        in = new Scanner(System.in);
        registerUser.setPassword(in.nextLine());

        System.out.println("Как Вас зовут?");
        in = new Scanner(System.in);
        registerUser.setName(in.nextLine());

        System.out.println("Вы успешно зарегистрировались в системе!\n");

        usersList.add(registerUser);

        selectActionInSystem();
    }

    /**
     * Вход в систему.
     */
    @Override
    public void login() throws Exception
    {
        System.out.println("Вход в систему");
        System.out.println("Введите логин");
        Scanner in = new Scanner(System.in);
        TestingUser userTryingLogin = new TestingUser(in.nextLine());

        System.out.println("Введите пароль");
        in = new Scanner(System.in);
        userTryingLogin.setPassword(in.nextLine());

        searchUser(userTryingLogin);

        for (int i = 0; i < usersList.size(); i++)
        {
            if (userFound == false)
            {
                System.err.println("Пользователь не найден");
                selectActionInSystem();
            }
            else if (passwordIsCorrect == false)
            {
                System.err.println("Вы ввели неверный пароль");
                selectActionInSystem();
            }
            else if (userFound == true && passwordIsCorrect == true)
            {
                System.out.println("Вход выполнен.");
                System.out.println("Вы вошли в систему как " + user.getStatusUser() + user.getName());

                userActions();
            }
        }
    }

    /**
     * Выход из системы.
     */
    @Override
    public void logout() throws Exception
    {

        user = null;

        System.out.println("Выход из системы выполнен.\n");
        selectActionInSystem();
    }

    /**
     * Выбор пользователем действия в системе.
     */
    @Override
    public void selectActionInSystem() throws Exception
    {
        user = null;
        Scanner in;
        String inputedSelectAction = new String();
        boolean isValidInputedValue = false;


        while (isValidInputedValue == false)
        {
            System.out.println("\nЕсли Вы хотите войти в систему введите \"1\"");
            System.out.println("Если Вы хотите зарегистрироваться в системе введите \"2\"");

            in = new Scanner(System.in);
            inputedSelectAction = in.nextLine();

            if (inputedSelectAction.length() != 1 ||
                    inputedSelectAction.charAt(0) != TestingConst.ONE &&
                            inputedSelectAction.charAt(0) != TestingConst.TWO)
            {
                System.err.println("Некорректный ввод");
            }
            else
            {
                isValidInputedValue = true;
            }
        }

        if (inputedSelectAction.charAt(0) == TestingConst.ONE)
        {
            login();
        }
        if (inputedSelectAction.charAt(0) == TestingConst.TWO)
        {
            register();
        }
    }

    /**
     * Ищет пользователя в списке.
     * @param userTryingLogin - введенные данные пользователя при попытке входа в систему.
     */
    private void searchUser(TestingUser userTryingLogin)
    {
        for (int i = 0; i < usersList.size(); i++)
        {
            TestingUser userAtList = usersList.get(i);
            if (userAtList.getLogin().equals(userTryingLogin.getLogin()) == true)
            {
                userFound = true;
            }
            if (userFound == true && userAtList.getPassword().equals(userTryingLogin.getPassword()) == true)
            {
                passwordIsCorrect = true;
                user = userAtList;
            }
        }
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
     * Действия пользователя после входа в систему.
     */
    private void userActions() throws Exception
    {
        if (user.isUserIsAdmin() == true)
        {
            testService.actionsWithTest();
        }
        else
        {
            TestingTakingTheTest taking = new TestingTakingTheTest();
        }
        selectActionInSystem();
    }
}
