import java.util.Scanner;

/**
 * Диалог с пользователем.
 */
public class TestingUserDialog
{
    TestingUserServiceInterface user = null;
    /**
     * Сканнер.
     */
    Scanner scanner = null;

    /**
     * Введенное значение.
     */
    String inputedValue = new String();

    /**
     * Конструктор.
     */
    public TestingUserDialog()
    {
        user = new TestingUserService();
        dialog();
    }

    /**
     * Основной диалог.
     */
    private void dialog()
    {
        greeting();
    }

    /**
     * Выводит сообщение.
     * @param textMessage - текст сообщения.
     */
    private void print(String textMessage)
    {
        System.out.println(textMessage);
    }

    /**
     * Выводит сообщение об ошибке.
     * @param textMessage - текст сообщения.
     */
    private void printErr(String textMessage)
    {
        System.err.println(textMessage);
    }

    /**
     * Ввод.
     */
    private void input()
    {
        inputedValue = new String();
        scanner = new Scanner(System.in);
        inputedValue = scanner.nextLine();
    }

    /**
     * Добавляет разделитель.
     */
    private void addSeparator()
    {
        print(TestingConst.SEPARATOR);
    }

    private void greeting()
    {
        print("Здравствуйте! Добро пожаловать в приложение по тестированию!");
        addSeparator();
        selectActionInSystem();
    }

    /**
     * Выбор пользователем действия в системе.
     */
    public void selectActionInSystem()
    {

        try
        {
            print("\nЕсли Вы хотите войти в систему введите \"1\"");
            print("Если Вы хотите зарегистрироваться в системе введите \"2\"");

            input();


            if (inputedValue.charAt(0) == TestingConst.ONE)
            {
                loginDialog();
            }
            if (inputedValue.charAt(0) == TestingConst.TWO)
            {
                registerDialog();
            }
        }
        catch (Exception exception)
        {
            printErr(exception.getMessage());
            selectActionInSystem();
        }
    }

    /**
     * Ввод данных пользователя.
     */
    private void inputDataUser()
    {
        print("Введите логин");
        input();
        String login = inputedValue;
        user.setLogin(login);

        print("Введите пароль");
        input();
        user.setPassword(inputedValue);
    }

    /**
     * Диалог входа в систему.
     * @throws Exception - выбрасывыемое исключение.
     */
    private void loginDialog() throws Exception
    {
        print("Вход в систему");

        inputDataUser();
        user.login();

        print("Вход выполнен");
    }

    /**
     * Диалог регистрации в системе.
     */
    private void registerDialog()
    {
        print("Регистрация");

        inputDataUser();
        print("Как Вас зовут?");
        input();
        user.setName(inputedValue);

        user.register();
    }
}
