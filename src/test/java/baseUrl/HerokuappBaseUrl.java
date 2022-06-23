package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuappBaseUrl {

    protected RequestSpecification spec05;

    @Before
    public void setUp() {
        spec05 = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }


}
