import java.util.ArrayList;
import java.util.Collections;

/**
 * Класс самого теста.
 */
public class TestingTheTest
{
    /**
     * Общее количество баллов за все вопросы.
     */
    private int allScores = 0;
    /**
     * Список вопросов.
     */
    public ArrayList<TestingQuestion> questionsList = new ArrayList<TestingQuestion>();

    /**
     * Конструктор.
     */
    public TestingTheTest()
    {
        createQuestionList();
        setAllScores();
    }

    /**
     * Возвращает список вопросов.
     * @return список вопросов.
     */
    public ArrayList<TestingQuestion> getQuestionsList()
    {
        return questionsList;
    }

    /**
     * Создает список вопросов.
     */
    private void createQuestionList()
    {
        TestingUser user = new TestingUser();

        //Вопрос № 1
        String textQuestion = new String("методология программирования основанная на представлении программы в виде " +
                "совокупности объектов " +
                "каждый из которых является экземпляром определенного класса," +
                "а классы образуют иерархию наследования - это...");
        TestingQuestion question = new TestingQuestion(textQuestion, TestingComplexityOfTheQuestion.HARD, user);
        question.addAnswerOption(true,"ООП");

        questionsList.add(question);

        //Вопрос № 2
        textQuestion = new String("Что такое класс в Java ?");

        question = new TestingQuestion(textQuestion, TestingComplexityOfTheQuestion.LOW, user);

        question.addAnswerOption("Уровень сложности программы. " +
                "Все операторы делятся на классы в зависимости от сложности их использования.");
        question.addAnswerOption(true, "Базовый элемент объектно-ориентированного " +
                "программирования в языке Java.");
        question.addAnswerOption("Просто одно из возможных названий переменной.");
        question.addAnswerOption("Такое понятие есть только в C++, в Java такого понятия нет.");

        questionsList.add(question);

        //Вопрос № 3
        textQuestion = new String("Какие варианты инициализации массива правильные ?");
        question = new TestingQuestion(textQuestion, TestingComplexityOfTheQuestion.MEDIUM, user);

        question.addAnswerOption("int[] array = new int[];");
        question.addAnswerOption("int[] array = int[];");
        question.addAnswerOption(true,"int[] array = new int[]{1,2,3,4,5};");
        question.addAnswerOption("int[] array = 1,2,3,4,5;");
        question.addAnswerOption(true,"int[] array = new int[5];;");
        question.addAnswerOption(true,"int[] array = {1,2,3,4,5};");

        questionsList.add(question);

        //Вопрос № 4
        textQuestion = new String("Как объявить класс в коде ?");
        question = new TestingQuestion(textQuestion, TestingComplexityOfTheQuestion.LOW, user);

        question.addAnswerOption("new class MyClass {}");
        question.addAnswerOption(true,"class MyClass {}");
        question.addAnswerOption("select * from class MyClass {}");
        question.addAnswerOption("MyClass extends class {}");

        questionsList.add(question);

        Collections.shuffle(questionsList);
    }

    /**
     * Задает общее количество баллов за все вопросы.
     */
    private void setAllScores()
    {
        for (int i = 0; i < questionsList.size(); i ++)
        {
            allScores += questionsList.get(i).getComplexity().getScore();
        }
    }

    /**
     * Возвращает общее количество баллов за все вопросы.
     * @return общее количество баллов за все вопросы.
     */
    public int getAllScores()
    {
        return allScores;
    }
}
