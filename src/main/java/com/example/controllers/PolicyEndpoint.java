package com.example.controllers;

import com.example.PolicyNotFoundException;
import com.example.service.PolicyService;
import com.example.service.PolicyServiceImpl;
import com.example.beans.Policy;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by shaun on 12/12/2015.
 */
@RestController
public class PolicyEndpoint {

    private static final Logger log = LoggerFactory.getLogger(PolicyEndpoint.class);

    @Autowired
    private PolicyService policyService;

    @RequestMapping("/policy")
    public Policy policy() {
        return policyService.getDefaultPolicy();
    }

    @RequestMapping("/policies")
    public List<Policy> policyList(@RequestParam(value="customerId") String customerId) {
        log.info("Fetching policies for customer id: " + customerId);
        List<Policy> res = policyService.list(customerId);
        log.info("Results list size:"+res.size());
        return res;
    }

    @RequestMapping(value = "policy/{id}", method = RequestMethod.PUT)
    public Policy update(@RequestBody Policy policy) throws PolicyNotFoundException {
        return policyService.update(policy);
    }

}
