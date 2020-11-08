import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс пользователя.
 */
public class TestingUser implements TestingUserService {
    /**
     * Имя пользователя.
     */
    private String name = null;

    /**
     * Введенный логин пользователя.
     */
    private String login = null;
    /**
     * Введенный пароль пользователя.
     */
    private String password = null;

    /**
     * Имя администратора.
     */
    private String nameAdmin = "Администратор";
    /**
     * Логин администратора.
     */
    private String loginAdmin = "admin";
    /**
     * Пароль администратора.
     */
    private String passwordAdmin = "12345678";

    /**
     * Имя зарегистрированного пользователя.
     */
    private String nameRegisterUser = null;
    /**
     * Логин зарегистрированного пользователя.
     */
    private String loginRegisterUser = null;
    /**
     * Пароль зарегистрированного пользователя.
     */
    private String passwordRegisterUser = null;

    /**
     * Список зарегистрированных пользователей.
     */
    ArrayList<ArrayList<String>> registerUsersList = new ArrayList <ArrayList<String>>();

    /**
     * Конструктор.
     */
    public TestingUser()
    {
    }

    /**
     * Регистрация пользователя.
     */
    @Override
    public void register() {
        System.out.println("Регистрация");

        System.out.println("Введите логин");
        Scanner in = new Scanner(System.in);
        loginRegisterUser = in.nextLine();

        System.out.println("Введите пароль");
        in = new Scanner(System.in);
        passwordRegisterUser = in.nextLine();

        System.out.println("Как Вас зовут?");
        in = new Scanner(System.in);
        nameRegisterUser = in.nextLine();

        System.out.println("Вы успешно зарегистрировались в системе!\n");

        ArrayList<String> registerUserList = new ArrayList<String>();
        registerUserList.add(loginRegisterUser);
        registerUserList.add(passwordRegisterUser);
        registerUserList.add(nameRegisterUser);
        registerUsersList.add(registerUserList);

        selectActionInSystem();
    }

    /**
     * Вход в систему.
     */
    @Override
    public void login()
    {
        System.out.println("Вход в систему");
        System.out.println("Введите логин");
        Scanner in = new Scanner(System.in);
        login = in.nextLine();

        System.out.println("Введите пароль");
        in = new Scanner(System.in);
        password = in.nextLine();

        if (isUserExists() == true)
        {
            TestingTakingTheTest takingTheTest = new TestingTakingTheTest();

            System.out.println("Вход выполнен.");
            System.out.println("Вы вошли в систему как " + name);

            logout();
        }
        else
        {
            System.out.println("Пользователь не найден!");
            login();
        }
    }

    /**
     * Выход из системы.
     */
    @Override
    public void logout()
    {
        System.out.println("Для выхода из системы введите \"Выйти\"");

        Scanner in = new Scanner(System.in);

        while (!in.nextLine().equals("Выйти"))
        {
            System.out.println("Для выхода из системы введите \"Выйти\"");

            in = new Scanner(System.in);
        }
        System.out.println("Выход из системы выполнен.\n");
        selectActionInSystem();
    }

    /**
     * Возвращает найден ли пользователь.
     * @return true - пользователь найден.
     */
    private boolean isUserExists()
    {
        for (int i = 0; i < registerUsersList.size(); i ++)
        {
            if (login.equals(registerUsersList.get(i).get(0)) &&
                    password.equals(registerUsersList.get(i).get(1)))
            {
                name = registerUsersList.get(i).get(2);
                return true;
            }
        }
        if (login.equals(loginAdmin) &&
            password.equals(passwordAdmin))
        {
            name = nameAdmin;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Выбор пользователем действия в системе.
     */
    @Override
    public void selectActionInSystem()
    {
        System.out.println("Если Вы хотите войти в систему введите \"Вход\"");
        System.out.println("Если Вы хотите зарегистрироваться в системе введите \"Регистрация\"");

        Scanner in = new Scanner(System.in);
        String inputedSelectAction =  in.nextLine();

        if (inputedSelectAction.equals("Вход"))
        {
            login();
        }
        if (inputedSelectAction.equals("Регистрация"))
        {
            register();
        }
        else
        {
            selectActionInSystem();
        }
    }
}