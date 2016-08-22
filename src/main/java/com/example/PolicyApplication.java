package com.example;

import com.example.beans.Policy;
import com.example.repositories.PolicyDao;
import com.example.service.PolicyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PolicyApplication implements CommandLineRunner {

    @Autowired
    private PolicyDao repository;

    @Autowired
    private PolicyServiceImpl policyService;

    public static void main(String[] args) {
        SpringApplication.run(PolicyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // Save a couple of policies
        repository.save(new Policy("Asia Policy","56a72a35d4c671a5c288dc02"));
        repository.save(new Policy("Western Europe Policy","56a72a35d4c671a5c288dc02"));
        repository.save(new Policy("Africa Policy","56a72a35d4c671a5c288dc04"));

        // fetch all customers
        System.out.println("Policies found with findAll():");
        System.out.println("-------------------------------");
        Policy p = new Policy();
        for (Policy policy : repository.findAll()) {
            System.out.println(policy);
            p =policy;
        }
        System.out.println();

        // fetch one policy to update
        repository.findOne(p.getId());
        System.out.println("Policy: " + p);

        // set a new name on the policy
        p.setName("Central Africa Policy");

        // pass the policy to service layer for updating
        Policy updated = new Policy();
        try {
            updated = policyService.update(p);
        } catch(PolicyNotFoundException e) {
            System.out.println("PolicyNotFoundException thrown");
            // TODO -- rethrow PolicyNotFoundException
        }
        System.out.println("Updated Policy: "
                + updated);

    }
}
