package com.example;

import com.example.beans.Policy;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.net.URL;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;



/**
 * Created by shaun on 19/01/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PolicyApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class PolicyEndpointTest {

    private TestRestTemplate template;

    /*
    @Value("${local.server.port}")
    private int port;

    @Value("${context.path}")
    private String contextPath;

    @Value("${default.policy.id}")
    private String defaultPolicyId;

    @Value("${default.policy.name}")
    private String defaultPolicyName;

    private URL baseUrl;
    */

    @Before
    public void setUp() throws Exception {
        //this.baseUrl = new URL("http://localhost:" + port + "/" + contextPath);
        template = new TestRestTemplate();
    }

    @Ignore
    @Test
    public void getPolicy_returnsStatusCode200() {
        /*
        ResponseEntity<Policy> response =
                template.getForEntity(baseUrl.toString(), Policy.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        */
    }

    @Ignore
    @Test
    public void getPolicy_returnsDefaultPolicy() {
       /*
        ResponseEntity<Policy> response =
                template.getForEntity(baseUrl.toString(), Policy.class);

        assertThat(response.getBody().getName(), equalTo(defaultPolicyName));
        */
    }

    @Ignore
    @Test
    public void getPolicies_returnsList() {
        /*
        ResponseEntity<List<Policy>> policyResponse =
                template.exchange(baseUrl.toString().concat("/policies?customerId="),
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Policy>>() {
                        });
        List<Policy> policies = policyResponse.getBody();

        assertThat(policies, notNullValue());
        */
    }

    // TODO customer not found exception -- controller test -- see work laptop

    // TODO invalid customer id exception -- controller test -- see work laptop

    // TODO decide which layer should be responsible for CustomerNotFoundException

    // TODO decide which layer should be responsible for InvalidIdException

}
