import java.util.ArrayList;
import java.util.Collections;

/**
 * Класс самого теста.
 */
public class TestingTheTest
{
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
    public void createQuestionList()
    {
        TestingUser user = new TestingUser();

        //Вопрос № 1
        String textQuestion = new String("Что такое ООП ?");
        TestingQuestion question = new TestingQuestion(textQuestion,TestingTypesOfQuestion.SINGLE_TRUE_OPTION,
                TestingComplexityOfTheQuestion.LOW, user);

        question.addAnswerOption(true, "Объектно-ориентированное программирование — " +
                "методология программирования основанная на представлении программы в виде совокупности объектов, " +
                "каждый из которых является экземпляром определенного класса, " +
                "а классы образуют иерархию наследования.");
        question.addAnswerOption("Объектно-ориентированное программирование — " +
                "так называют любой тип программирования, в котором используются понятия высокого уровня и, " +
                "в отличие от Assembler, в котором не работают напрямую с ячейками памяти ПК.");
        question.addAnswerOption("Объектно-ориентированное программирование — просто красивое понятие. " +
                "Если вдуматься, оно не несет дополнительной смысловой нагрузки, " +
                "просто программисты любят аббревиатуры, так области их знаний выглядят сложнее.");
        question.addAnswerOption("Очень одинокий программист.");

        questionsList.add(question);

        //Вопрос № 2
        textQuestion = new String("Что такое класс в Java ?");

        question = new TestingQuestion(textQuestion,TestingTypesOfQuestion.MULTIPLE_TRUE_OPTIONS,
                TestingComplexityOfTheQuestion.LOW, user);

        question.addAnswerOption("Уровень сложности программы. " +
                "Все операторы делятся на классы в зависимости от сложности их использования.");
        question.addAnswerOption(true, "Базовый элемент объектно-ориентированного " +
                "программирования в языке Java.");
        question.addAnswerOption(true,"Просто одно из возможных названий переменной.");
        question.addAnswerOption("Такое понятие есть только в C++, в Java такого понятия нет.");

        questionsList.add(question);

        //Вопрос № 3
        textQuestion = new String("Как объявить класс в коде ?");
        question = new TestingQuestion(textQuestion,TestingTypesOfQuestion.SINGLE_TRUE_OPTION,
                TestingComplexityOfTheQuestion.LOW, user);

        question.addAnswerOption("class MyClass {}");
        question.addAnswerOption("new class MyClass {}");
        question.addAnswerOption("select * from class MyClass {}");
        question.addAnswerOption("MyClass extends class {}");

        questionsList.add(question);

        //Вопрос № 4
        textQuestion = new String("Для чего используется оператор NEW ?");
        question = new TestingQuestion(textQuestion,TestingTypesOfQuestion.SINGLE_TRUE_OPTION,
                TestingComplexityOfTheQuestion.LOW, user);

        question.addAnswerOption("Для создания новой переменной.");
        question.addAnswerOption("Для объявления нового класса.");
        question.addAnswerOption("Для создания экземпляра класса.");
        question.addAnswerOption("Это антагонист оператора OLD.");

        questionsList.add(question);

        //Вопрос № 5
        textQuestion = new String("Что означает ключевое слово extends ?");
        question = new TestingQuestion(textQuestion,TestingTypesOfQuestion.SINGLE_TRUE_OPTION,
                TestingComplexityOfTheQuestion.LOW, user);

        question.addAnswerOption("Что данные класс наследуется от другого.");
        question.addAnswerOption("Что это дополнительный модуль класса, " +
                "который расширяет его свойства.");
        question.addAnswerOption("Что два класса делают одно и то же.");
        question.addAnswerOption("Что это самый большой класс в программе.");

        questionsList.add(question);

        //Вопрос № 6
        textQuestion = new String("Что означает перегрузка метода в Java (overload) ?");
        question = new TestingQuestion(textQuestion,TestingTypesOfQuestion.SINGLE_TRUE_OPTION,
                TestingComplexityOfTheQuestion.LOW, user);

        question.addAnswerOption("Изменение поведения метода класса относительно родительского.");
        question.addAnswerOption("Изменение поведения метода класса относительно дочернего.");
        question.addAnswerOption("Несколько методов с одинаковым названием, но разным набором параметров.");
        question.addAnswerOption("Несколько разных классов с одинаковым методом.");

        questionsList.add(question);

        //Вопрос № 7
        textQuestion = new String("Что означает переопределение метода в Java (override) ?");
        question = new TestingQuestion(textQuestion,TestingTypesOfQuestion.SINGLE_TRUE_OPTION,
                TestingComplexityOfTheQuestion.LOW, user);

        question.addAnswerOption("Изменение поведения метода класса относительно родительского.");
        question.addAnswerOption("Изменение поведения метода класса относительно дочернего.");
        question.addAnswerOption("Несколько методов с одинаковым названием, но разным набором параметров.");
        question.addAnswerOption("Несколько разных классов с одинаковым методом.");

        questionsList.add(question);

        //Вопрос № 8
        textQuestion = new String("Чем отличаются static-метод класса от обычного метода класса ?");
        question = new TestingQuestion(textQuestion,TestingTypesOfQuestion.SINGLE_TRUE_OPTION,
                TestingComplexityOfTheQuestion.LOW, user);

        question.addAnswerOption("Обычный метод класса можно перегрузить, а static-метод нельзя.");
        question.addAnswerOption("Обычный метод класса можно переопределить, а static-метод нельзя.");
        question.addAnswerOption("Обычный метод класса работает от объекта класса, " +
                "а static-метод от всего класса.");
        question.addAnswerOption("Static-метод класса можно вызывать только внутри класса, " +
                "а обычный - в любой части кода.");

        questionsList.add(question);

        //Вопрос № 9
        textQuestion = new String("Как вызвать static-метод внутри обычного ?");
        question = new TestingQuestion(textQuestion,TestingTypesOfQuestion.SINGLE_TRUE_OPTION,
                TestingComplexityOfTheQuestion.LOW, user);

        question.addAnswerOption("Никак, static-метод можно вызвать только от объекта класса.");
        question.addAnswerOption("Можно, надо перед этим перегрузить обычный метод класса.");
        question.addAnswerOption("Можно, надо перед этим переопределить обычный метод класса.");
        question.addAnswerOption("Можно, ничего дополнительно делать не надо.");

        questionsList.add(question);

        //Вопрос № 10
        textQuestion = new String("Как вызвать обычный метод класса внутри static-метода ?");
        question = new TestingQuestion(textQuestion,TestingTypesOfQuestion.SINGLE_TRUE_OPTION,
                TestingComplexityOfTheQuestion.LOW, user);

        question.addAnswerOption("Никак, static-метод не работает с объектом класса.");
        question.addAnswerOption("Можно, надо перед этим перегрузить обычный метод класса.");
        question.addAnswerOption("Можно, надо перед этим переопределить обычный метод класса.");
        question.addAnswerOption("Можно, ничего дополнительно делать не надо.");

        questionsList.add(question);

        //Вопрос № 11
        textQuestion = new String("Как вызвать обычный метод класса внутри static-метода ?");
        question = new TestingQuestion(textQuestion,TestingTypesOfQuestion.SINGLE_TRUE_OPTION,
                TestingComplexityOfTheQuestion.LOW, user);

        question.addAnswerOption("Это указатель на переопределенный метод класса. " +
                "Его нельзя опускать при вызове, иначе переопределение не сработает.");
        question.addAnswerOption("Это указатель на текущий объект класса внутри самого класса. " +
                "Его можно опускать при вызове метода класса, но лучше этого не делать.");
        question.addAnswerOption( "Это не ключевое слово.");
        question.addAnswerOption("Это ключевое слово для вызова обычного метода внутри static-метода. " +
                "Его нельзя опускать, иначе вызов не сработает и будет ошибка.");

        questionsList.add(question);

        //Вопрос № 12
        textQuestion = new String("Что вернет метод, объявленный следующим образом:\n" +
                "public static int getAmount() ?");
        question = new TestingQuestion(textQuestion,TestingTypesOfQuestion.SINGLE_TRUE_OPTION,
                TestingComplexityOfTheQuestion.LOW, user);

        question.addAnswerOption("Не ясно, надо смотреть код метода.");
        question.addAnswerOption("Вернет static-поле класса.");
        question.addAnswerOption("Вернет ссылку на объект класса this.");
        question.addAnswerOption("Вернет целочисленное значение.");

        questionsList.add(question);

        // Перемешивает список вопросов.
        Collections.shuffle(questionsList);
    }
}
