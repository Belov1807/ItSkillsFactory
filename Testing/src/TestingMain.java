/*Version 0.10.0*/

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

        TestingUserService userService = new TestingUserService();
        userService.selectActionInSystem();
    }
    public  static  void  main (String [] args)
    {
        new TestingMain();
    }
}
