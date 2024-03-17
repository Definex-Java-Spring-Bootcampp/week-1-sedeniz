package com.patika.kredinbizdenservice.service;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.User;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ApplicationService {
    private List<Application> applicationList;

    public ApplicationService() {
        this.applicationList = new ArrayList<>();
    }

    public static User findUserWithMostApplications(List<Application> applications) {
        Map<User, Integer> userApplicationCount = new HashMap<>();
        for (Application app : applications) {
            userApplicationCount.put(app.getUser(), userApplicationCount.getOrDefault(app.getUser(), 0) + 1);
        }

        User mostApplicationsUser = null;
        int maxApplications = 0;
        for (Map.Entry<User, Integer> entry : userApplicationCount.entrySet()) {
            if (entry.getValue() > maxApplications) {
                mostApplicationsUser = entry.getKey();
                maxApplications = entry.getValue();
            }
        }
        return mostApplicationsUser;
    }

    public static Application findHighestLoanApplication(List<Application> applications) {
        return applications.stream()
                .filter(app -> app.getLoan() != null)
                .max(Comparator.comparing(app -> app.getLoan().getAmount()))
                .orElse(null);
    }

    public static List<Application> findApplicationsLastMonth(List<Application> applications) {
        return applications.stream()
                .filter(app -> app.getLocalDateTime().isAfter(LocalDateTime.now().minusMonths(1)))
                .collect(Collectors.toList());
    }
    public List<Application> listApplicationsByEmail(List<Application> applications, String email) {
        return applications.stream()
                .filter(app -> app.getUser().getEmail().equalsIgnoreCase(email))
                .collect(Collectors.toList());
    }

}

