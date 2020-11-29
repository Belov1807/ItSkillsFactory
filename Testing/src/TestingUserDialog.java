import java.util.Scanner;

/**
 * Диалог с пользователем.
 */
public class TestingUserDialog
{
    /**
     * Интерфейс сервиса взаимодействия с пользователем.
     */
    private TestingUserServiceInterface user = null;
    /**
     * Интерфейс сервиса по работе с тестами.
     */
    private TestingTestServiceInterface test = null;
    /**
     * Сканнер.
     */
    private Scanner scanner = null;

    /**
     * Введенное значение.
     */
    private String inputedString = new String();
    /**
     * Целочисленное введенное значение.
     */
    private int inputedNumber = 0;
    /**
     * Введенный символ.
     */
    private char inputedSymbol = 0;

    /**
     * Конструктор.
     */
    public TestingUserDialog()
    {
        user = new TestingUserService();
        test = new TestingTestService();
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
     * Ввод строки.
     */
    private void inputString()
    {
        inputedString = new String();
        scanner = new Scanner(System.in);
        inputedString = scanner.nextLine();
    }
    /**
     * Ввод символа.
     */
    private void inputSymbol()
    {
        inputString();
        inputedSymbol = inputedString.charAt(0);
    }
    /**
     * Ввод целого числа.
     */
    private void inputNumber()
    {
        inputedNumber = 0;
        scanner = new Scanner(System.in);
        inputedNumber = scanner.nextInt() - 1;
    }

    /**
     * Добавляет разделитель.
     */
    private void addSeparator()
    {
        print(TestingConst.SEPARATOR);
    }

    /**
     * Приветствие.
     */
    private void greeting()
    {
        print("Здравствуйте! Добро пожаловать в приложение по тестированию!");
        addSeparator();
        selectActionInSystemSelectionDialog();
    }

    /**
     * Выбор пользователем действия в системе.
     */
    public void selectActionInSystemSelectionDialog()
    {

        try
        {
            print("\nЕсли Вы хотите войти в систему введите \"1\"");
            print("Если Вы хотите зарегистрироваться в системе введите \"2\"");

            inputSymbol();

            if (inputedSymbol == TestingConst.ONE)
            {
                loginDialog();
            }
            else if (inputedSymbol == TestingConst.TWO)
            {
                registerDialog();
            }
        }
        catch (Exception exception)
        {
            printErr(exception.getMessage());
            selectActionInSystemSelectionDialog();
        }
    }

    /**
     * Ввод данных пользователя.
     */
    private void inputDataUser()
    {
        print("Введите логин");
        inputString();
        String login = inputedString;
        user.setLogin(login);

        print("Введите пароль");
        inputString();
        user.setPassword(inputedString);
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

        actionsAfterLoginSelectionDialog();
    }

    /**
     * Диалог регистрации в системе.
     */
    private void registerDialog()
    {
        print("Регистрация");

        inputDataUser();
        print("Как Вас зовут?");
        inputString();
        user.setName(inputedString);

        user.register();
    }

    /**
     * Диалог выбора после входа пользователя в систему.
     * @throws Exception - выбрасываемое исключение.
     */
    private void actionsAfterLoginSelectionDialog() throws Exception
    {
        print("1 Показать список доступных тестов");
        print("\n0 Выйти из системы");
        inputSymbol();

        if (inputedSymbol == TestingConst.ONE)
        {
            showTestsList();
        }
        else if (inputedSymbol == '0')
        {
            return;
        }
    }

    /**
     * Диалог выбора теста.
     * @throws Exception - выбрасываемое исключение.
     */
    private void selectTestDialog() throws Exception
    {
        print("Введите номер теста");
        inputNumber();
        print("Вы выбрали тест \"" + test.getTestNameAt(inputedNumber) + "\"");
        selectedTestSelectionDialog(inputedNumber);
    }

    /**
     * Диалог добавление теста.
     * @throws Exception - выбрасываемое исключение.
     */
    private void addTestDialog() throws Exception
    {
        print("Введите название теста");
        inputString();
        test.addTest(inputedString);
        print("Тест под названием \"" + inputedString + "\" успешно добавлен");

        actionsAfterLoginSelectionDialog();

    }

    /**
     * Выводит список тестов.
     * @throws Exception - выбрасываемое исключение.
     */
    private void showTestsList() throws Exception
    {
        if (test.getTestsCount() == 0)
        {
            print("Нет доступных тестов для просмотра");
        }
        for (int i = 0; i < test.getTestsCount(); i ++)
        {
            print((i + 1) + " " + test.getTestNameAt(i));
        }
        actionsTestSelectionDialog();
    }

    /**
     * Возможные действия с тестом.
     * @throws Exception - выбрасываемое исключение.
     */
    private void actionsTestSelectionDialog() throws Exception
    {
        print("1 Выбрать тест из списка");
        print("2 Добавить тест в список");
        print("\n0 Назад");

        inputSymbol();

        if (inputedSymbol == TestingConst.ONE)
        {
            selectTestDialog();
        }
        else if (inputedSymbol == TestingConst.TWO)
        {
            addTestDialog();
        }
        else if (inputedSymbol == '0')
        {
            return;
        }
    }

    /**
     * Диалог выбора выбранного теста.
     * @param indexTest - индекс выбранного теста.
     * @throws Exception - выбрасываемое исключение.
     */
    private void selectedTestSelectionDialog(int indexTest) throws Exception
    {
        print("1 Просмотреть список вопросов в тесте ");
        print("2 Добавить в тест список вопросов из xml-файла");
        print("3 Переименовать тест");
        print("4 Удалить тест");
        print("\n0 Назад к списку тестов");

        inputSymbol();

        if (inputedSymbol == TestingConst.ONE)
        {
            selectTestDialog();
        }
        else if (inputedSymbol == TestingConst.TWO)
        {
            return;
        }
        else if (inputedSymbol == '3')
        {
            renameTestDialog(indexTest);
        }
        else if (inputedSymbol == '4')
        {
            removeTestSelectionDialog(indexTest);
        }
        else if (inputedSymbol == '0')
        {
            showTestsList();
        }
    }

    /**
     * Диалог переименования теста.
     * @param indexTest - индекс теста.
     * @throws Exception - выбрасываемое исключение.
     */
    private void renameTestDialog(int indexTest) throws Exception
    {
        String oldName = test.getTestNameAt(indexTest);

        print("Введите новое имя теста");
        inputString();
        test.renameTest(indexTest, inputedString);

        print("Имя теста изменено с \"" + oldName + "\" на \"" + inputedString + "\"");

        selectedTestSelectionDialog(indexTest);
    }

    /**
     * Диалог выбора удаления теста.
     * @param indexTest индекс теста.
     * @throws Exception - выбрасываемое исключение.
     */
    private void removeTestSelectionDialog(int indexTest) throws Exception
    {
        String testName = test.getTestNameAt(indexTest);

        print("Вы действительно хотите удалить тест \"" + testName + "\" ?");
        print("1 Да");
        print("2 Нет");
        inputSymbol();

        if (inputedSymbol == TestingConst.ONE)
        {
            test.removeTestAt(indexTest);
            print("Тест \"" + testName + "\" был успешно удален");

            showTestsList();
        }
        else if (inputedSymbol == TestingConst.TWO)
        {
            print("Тест \"" + testName + "\" не был удален");

            selectedTestSelectionDialog(indexTest);
        }

    }
}
