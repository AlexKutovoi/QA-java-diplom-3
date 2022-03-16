import org.junit.Before;

public class BaseTest {

    @Before
    public void browserSetUp() {
        String browser = "chrome";
        switch (browser) {
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
                return;
            default:
                return;
        }
    }
}
