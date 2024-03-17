package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.enums.ApplicationStatus;
import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.model.*;
import com.patika.kredinbizdenservice.service.ApplicationService;
import com.patika.kredinbizdenservice.service.LoanFactory;
import com.patika.kredinbizdenservice.service.UserService;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        List<Application> applications = initializeApplications();
        UserService userService = new UserService();
        ApplicationService applicationService = new ApplicationService();

        // Sifreleme
        String password = "password123";
        String encryptedPassword = UserService.encryptPasswordSHA512(password);
        System.out.println("Sifrelenmiş sifre: " + encryptedPassword);

        // En çok basvuru yapan kullanıcı
        User userWithMostApplications = ApplicationService.findUserWithMostApplications(applications);
        if (userWithMostApplications != null) {
            System.out.println("En çok basvuru yapan kullanıcı: " + userWithMostApplications.getName());
        }
        else {
            System.out.println("En çok basvuru yapan kullanıcı bulunamadi.");
        }

        // En yuksek kredi isteyen basvuru
        Application highestLoanApplication = ApplicationService.findHighestLoanApplication(applications);
        if (highestLoanApplication != null) {
            System.out.println("En yuksek kredi isteyen basvuru: " + highestLoanApplication.getLoan().getAmount() + " by " + highestLoanApplication.getUser().getName());
        }
        else {
            System.out.println("En yuksek kredi isteyen basvuru bulunamadi.");
        }

        // Son bir aydaki basvurular
        List<Application> lastMonthApplications = ApplicationService.findApplicationsLastMonth(applications);
        System.out.println("Son bir aydaki basvuru sayisi: " + lastMonthApplications.size());

        // cemdrman@gmail.com adresine sahip kullanıcının başvurularını listele
        String email = "cemdrman@gmail.com";
        List<Application> applicationsOfUser = applicationService.listApplicationsByEmail(applications, email);
        System.out.println(email + " adresine sahip kullanıcının basvurulari:");
        if (applicationsOfUser.isEmpty()) {
            System.out.println("Hic basvuru bulunamadı.");
        } else {
            for (Application application : applicationsOfUser) {
                Loan loan = application.getLoan();
                String loanType = "Unknown"; // default

                if (loan instanceof HouseLoan) {
                    loanType = ((HouseLoan) loan).getLoanType().toString();
                } else if (loan instanceof ConsumerLoan) {
                    loanType = ((ConsumerLoan) loan).getLoanType().toString();
                } else if (loan instanceof VechileLoan) {
                    loanType = ((VechileLoan) loan).getLoanType().toString();
                }
                System.out.println("Basvuru Tarihi: " + application.getLocalDateTime() +
                        ", Kredi Tipi: " + loanType +
                        ", Status: " + (application.getApplicationStatus()) +
                        ", Miktar: " + (application.getLoan().getAmount()) +
                        ", Taksit: " + (application.getLoan().getInstallment()) +
                        ", Faiz: " + (application.getLoan().getInterestRate()));
            }
        }
    }


    private static List<Application> initializeApplications() throws NoSuchAlgorithmException {
        List<Application> applications = new ArrayList<>();
        UserService userService = new UserService();

        User user1 = new User("Cem", "Dırman", LocalDate.of(1990, 1, 1), "cemdrman@gmail.com", "password123", "505", true);
        User user2 = new User("John", "Doe", LocalDate.of(2000, 3, 27), "john@example.com", "encrypted-password1", "545", true);
        User user3 = new User("Ali", "Veli", LocalDate.of(1990, 1, 1), "ali@example.com", "encrypted-password2", "555", true);

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        // try to add another user with a same email
        UserService.addUser(new User("Cem", "Dırman", LocalDate.of(1990, 1, 1), "cemdrman@gmail.com", "12345", "555", true));


        Loan consumerLoan = LoanFactory.createLoan(LoanType.IHTIYAC_KREDISI, new BigDecimal("10000"), 12, 1.2);
        Loan houseLoan = LoanFactory.createLoan(LoanType.KONUT_KREDISI, new BigDecimal("200000"), 24, 1.5);
        Loan vehicleLoan = LoanFactory.createLoan(LoanType.ARAC_KREDISI, new BigDecimal("50000"), 12, 1.3);

        Application application1 = new Application(consumerLoan, user1, LocalDateTime.now().minusDays(10));
        application1.setApplicationStatus(ApplicationStatus.INITIAL);

        Application application2 = new Application(houseLoan, user1, LocalDateTime.now().minusDays(60));
        application2.setApplicationStatus(ApplicationStatus.DONE);

        Application application3 = new Application(vehicleLoan, user2, LocalDateTime.now().minusDays(20));
        application3.setApplicationStatus(ApplicationStatus.IN_PROGRESS);

        applications.add(application1);
        applications.add(application2);
        applications.add(application3);

        return applications;
    }
}
