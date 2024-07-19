package karate;

import com.example.itxtechnicaltest.LauncherApplication;
import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {LauncherApplication.class})
public class PriceRunner {

    @Karate.Test
    Karate priceTest() {
        return Karate.run("classpath:karate/price.feature");
    }
}
