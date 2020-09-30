package com.crashn.test.grpcito;

import com.crashn.test.grpcito.client.CheckAPIService;
import com.crashn.test.grpcito.rest.BaseApiChecker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@RunWith(SpringRunner.class)
@RestClientTest(BaseApiChecker.class)
public class ControllerTest {

    @TestConfiguration
    static class TestConfig{
        @Bean
        public CheckAPIService checkAPIService() {
            return new CheckAPIService();
        }
    }

    @Autowired
    private BaseApiChecker apiChecker;

//    @Autowired
//    private RestTemplate template;

    @Autowired
    private MockRestServiceServer mockServer;

//    @Before
//    public void setUp() {
//        mockServer = MockRestServiceServer.createServer(template);
//    }

    @Test
    public void testSimpleRequest() {
        mockServer.expect(ExpectedCount.once(), requestTo("/base"))
                .andRespond(withStatus(HttpStatus.OK));

        String check = apiChecker.check("main", "message1");

        mockServer.verify();

        assertEquals("done", check);
    }
}
