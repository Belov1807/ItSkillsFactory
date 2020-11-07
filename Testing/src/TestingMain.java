/*Version 0.5.0*/

/**
 * Главный класс приложения по тестированию.
 */
public class TestingMain
{
    /**
     * Конструктор.
     */
    public TestingMain()
    {
        System.out.println("Здравствуйте! Добро пожаловать в приложение по тестированию!");

        TestingUser user = new TestingUser();
        user.selectActionInSystem();
    }
    public  static  void  main (String [] args)
    {
        new TestingMain();
    }
}
