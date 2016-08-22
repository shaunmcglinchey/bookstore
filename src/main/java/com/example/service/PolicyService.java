package com.example.service;

import com.example.PolicyNotFoundException;
import com.example.beans.Policy;

import java.util.List;

public interface PolicyService {

    Policy getDefaultPolicy();

    List<Policy> list(String customerId);

    Policy update(Policy policy) throws PolicyNotFoundException;
}
