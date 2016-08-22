package com.example.service;

import com.example.PolicyNotFoundException;
import com.example.beans.Policy;
import com.example.repositories.PolicyDao;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyServiceImpl implements PolicyService {


    @Value("${default.policy.name}")
    private String defaultPolicyName;

    //@Autowired
    private PolicyDao policyDao;


    @Autowired
    public PolicyServiceImpl(PolicyDao policyDao){
        this.policyDao = policyDao;
    }


    public Policy getDefaultPolicy() {
        Policy p = new Policy(defaultPolicyName, "56a72a35d4c671a5c288dc04");
        return p;
    }

    public List<Policy> list(String customerId) {
        return policyDao.findByCustomerId(new ObjectId(customerId));
    }

    public Policy update(Policy policy) throws PolicyNotFoundException {
        if(policyDao.findOne(policy.getId()) == null) {
            throw new PolicyNotFoundException();
        }
        return policyDao.save(policy);
    }

}

