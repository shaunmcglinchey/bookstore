package com.example;

import com.example.beans.Policy;
import com.example.repositories.PolicyDao;
import com.example.service.PolicyService;
import com.example.service.PolicyServiceImpl;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class PolicyServiceTest {

    private static final Logger log = LoggerFactory.getLogger(PolicyServiceTest.class);

    @Mock
    private PolicyDao policyDaoMock;

    @InjectMocks
    private PolicyServiceImpl classUnderTest;

    @Before
    public void initTests() {
        MockitoAnnotations.initMocks(this);
        classUnderTest = new PolicyServiceImpl(policyDaoMock);
    }

    @Test
    public void shouldGetPolicyList() {

        List<Policy> testList = Arrays.<Policy>asList(new Policy() {{
                this.setCustomerId(new ObjectId("56a72a35d4c671a5c288dc04"));
                this.setName("European Policy");
        }});
        given(policyDaoMock.findByCustomerId(new ObjectId("56a72a35d4c671a5c288dc04")))
                .willReturn(testList);

        PolicyService srv = new PolicyServiceImpl(policyDaoMock);

        List<Policy> policyList = srv.list("56a72a35d4c671a5c288dc04");

        assertThat(policyList.get(0).getName(), is("European Policy"));
        assertThat(policyList.size(), is(1));

        log.info("Results list size:"+policyList.size());
        log.info("Res:"+policyList);
    }


    @Test
    public void updatePolicy_shouldReturnUpdatedPolicy() throws PolicyNotFoundException {
        Policy p = new Policy();
        p.setId(new ObjectId("56a72a35d4c671a5c288dc05"));
        given(policyDaoMock.findOne(p.getId()))
                .willReturn(p);

        Policy updated = classUnderTest.update(p);
        System.out.println("Updated policy:" + updated);
    }




}
