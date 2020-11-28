import java.util.ArrayList;
import java.util.Scanner;

/**
 * Сервис по работе с вопросами.
 */
public class TestingQuestionService
{
    /**
     * Список вопросов.
     */
    private ArrayList<TestingQuestion> questionsList = new ArrayList<TestingQuestion>();

    /**
     * Добавить вопрос.
     */
    private  void addQuestion()
    {

        System.out.println("\nВведите текст вопроса");
        Scanner in = new Scanner(System.in);
        String questionText = in.nextLine();

        System.out.println("\nВыберите сложность вопроса:\n");

        for (int i = 0; i < TestingComplexityOfTheQuestion.complexitysCount(); i ++)
        {
            System.out.println((i + 1 + " ") + TestingComplexityOfTheQuestion.getComplexityNameAt(i));
        }

        System.out.println("\nВведите номер сложности вопроса");
        in = new Scanner(System.in);

        TestingComplexityOfTheQuestion complexity = TestingComplexityOfTheQuestion.getComplexityOfTheQuestionAt(in.nextInt()  - 1);
        System.out.println("Сложность = " + complexity.getComplexityOfTheQuestion());
    }

    /**
     * Удалить вопрос.
     */
    private  void removeQuestion(int index)
    {
        questionsList.remove(index);
    }

    /**
     * Просмотреть вопрос.
     */
    private void showQuestion(int index)
    {
        showQuestionText(index);
        System.out.print("Сложность вопроса: ");
        System.out.println(getQuestionsListAt(index).getComplexity().getComplexityOfTheQuestion());
        System.out.print("Вид вопроса: ");
        System.out.println(getQuestionsListAt(index).getType().getType());

        System.out.print("Автор вопроса: ");
        System.out.println(getQuestionsListAt(index).getAuthor().getLogin());
        showAnswerOptions(index);
        showRightAnswerOptions(index);
    }

    public TestingQuestion getQuestionsListAt(int index)
    {
        return questionsList.get(index);
    }

    /**
     * Возвращает количество вопросов в тесте.
     * @return количество вопросов в тесте.
     */
    public int questionsCount()
    {
        return questionsList.size();
    }

    /**
     * Добавляет список вопросов из xml-файла.
     * @param xmlFilePath
     * @throws Exception
     */
    public void addQuestionsListFromXml(String xmlFilePath) throws Exception
    {
        TestingXmlDataReader reader = new TestingXmlDataReader(xmlFilePath);
        questionsList.addAll(reader.getQuestionsList());
    }

    /**
     * Выводит список вопросов.
     */
    public void showQuestionsList()
    {
        if (questionsCount() == 0)
        {
            System.out.print("В этом тесте еще нет вопросов ");
            System.out.println("но вы можете их добавить");
        }
        for (int i = 0; i < questionsCount(); i ++)
        {
            System.out.println((i+1) + " " + getQuestionsListAt(i).getQuestionText());
        }
    }

    /**
     * Действия после вывода списка вопросов.
     */
    public void showQuestionsListAndSelect()
    {
        showQuestionsList();

        System.out.println("\n1 Добавить вопрос");

        if (questionsCount() != 0)
        {
            System.out.println("2 Выбрать вопрос");
        }
        System.out.println("\n0 Назад к тесту");


        Scanner scanner = new Scanner(System.in);

        String inputedValue = scanner.nextLine();

        if (inputedValue.charAt(0) == TestingConst.ONE)
        {
            System.out.println("Добавление вопроса");

            addQuestion();
        }
        else if (questionsCount() != 0 && inputedValue.charAt(0) == TestingConst.TWO)
        {
            selectQuestion();
        }
        if (inputedValue.charAt(0) == '0')
        {
            System.out.println("Назад к тесту ");
        }
    }

    /**
     * Выводит текст выбранного вопроса.
     * @param index - индекс вопроса в списке.
     */
    public void showQuestionText(int index)
    {
        System.out.println("\nВопрос № " + (index + 1));
        System.out.println(getQuestionsListAt(index).getQuestionText());
    }

    /**
     * Выводит список варинтов ответа у выбранного вопроса.
     * @param index - индекс вопроса в списке.
     */
    public void showAnswerOptions(int index)
    {
        System.out.println("Варианты ответа:");

        for (int i = 0; i < getQuestionsListAt(index).getAnswerOptionsList().size(); i ++)
        {
            System.out.println("\nВариант № " + (i + 1));
            System.out.println(getQuestionsListAt(index).getAnswerOption(i));
        }
    }

    /**
     * Выводит правильный ответ у выбранного вопроса.
     * @param index - индекс вопроса в списке.
     */
    public void showRightAnswerOptions(int index)
    {
        System.out.println("\nПравильный ответ:");

        for (int i = 0; i < getQuestionsListAt(index).getRightAnswerOptionsList().size(); i ++)
        {
            System.out.println(getQuestionsListAt(index).getRightAnswerOptionsList().get(i));
        }
    }

    /**
     * Выбор вопроса.
     */
    public void selectQuestion()
    {
        System.out.println("Введите номер вопроса который хотите выбрать");

        Scanner scanner = new Scanner(System.in);
        int inputedValue = scanner.nextInt();

        showQuestion( inputedValue - 1);

        actionsOnTheQuestion(inputedValue - 1);
    }

    /**
     * Действия над выбранным вопросом.
     * @param index
     */
    public void actionsOnTheQuestion(int index)
    {
        System.out.println("\n1 Редактировать вопрос");
        System.out.println("2 Удалить вопрос");
        System.out.println("\n0 Назад к списку вопросов");

        Scanner scanner = new Scanner(System.in);
        String inputedValue = scanner.nextLine();

        if (inputedValue.charAt(0) == TestingConst.ONE)
        {

        }
        else if (inputedValue.charAt(0) == TestingConst.TWO)
        {
            questionsList.remove(index);
            System.out.println("Вопрос удален из теста");
        }
        else if (inputedValue.charAt(0) == '0')
        {
            showQuestionsListAndSelect();
        }
    }
}
