package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

public class GMIBaseUrl {
    protected RequestSpecification spec03;

    @Before
    public void setUp(){
        spec03=new RequestSpecBuilder().setBaseUri("https://www.gmibank.com/api").build();
    }
}
