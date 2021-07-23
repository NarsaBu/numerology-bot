package com.fategen.NumerologyBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class NumerologyBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(NumerologyBotApplication.class, args);
	}

	@PostConstruct
	public void init() {
		String dianaDate = "18.09.2001";
		String maratDate = "10.03.1999";
		String userFullName = "Саламоне Диана Массимовна";
		String partnerFullName = "Усманов Марат Равшанович";
		String userName = "Диана";
		int year = 2021;
		int month = 9;
		String interestingDate = "18.09.2021";

		ServiceProvider serviceProvider = new ServiceProvider();

//		System.out.println(serviceProvider.getBirthMeaning(dianaDate));
//        System.out.println();
//		System.out.println(serviceProvider.getBirthMeaning(maratDate));
//        System.out.println();
//
//		System.out.println(serviceProvider.getCompatibility(dianaDate, maratDate));
//        System.out.println();
//
//        System.out.println(serviceProvider.getCompatibilityAndKarmaRelations(userFullName, partnerFullName));
//        System.out.println();
//
//        System.out.println(serviceProvider.getMyDestiny(dianaDate, maratDate));
//        System.out.println();
//
//		System.out.println(serviceProvider.getAllCompatibilityServices(dianaDate, maratDate, userFullName, partnerFullName));
//		System.out.println();
//
//        System.out.println(serviceProvider.getKarmaRelation(dianaDate, maratDate));
//        System.out.println();
//
//        System.out.println(serviceProvider.getPersonAndMind(userFullName, userName, dianaDate));
//        System.out.println();

//        System.out.println(serviceProvider.getYearForecast(dianaDate, year));
//        System.out.println();
//
//        System.out.println(serviceProvider.getMonthForecast(dianaDate, year, month));
//        System.out.println();
//
//        System.out.println(serviceProvider.getDayForecast(dianaDate, interestingDate));
//        System.out.println();

//        System.out.println(serviceProvider.getTalents(userFullName));
//        System.out.println();

//        System.out.println(serviceProvider.getHealth(dianaDate));
//        System.out.println();

//        System.out.println(serviceProvider.getMythicalAbility(dianaDate));
//        System.out.println();

//        System.out.println(serviceProvider.getKarmaDebt(dianaDate, userFullName));
//        System.out.println();

//		System.out.println(serviceProvider.getProfessionAssist(dianaDate));
//		System.out.println();
//
//		System.out.println(serviceProvider.getCvAssistAndInterviewDate(dianaDate, "15.02.2021"));
//		System.out.println();
//
//		System.out.println(serviceProvider.getPartnerAssist(dianaDate));
//		System.out.println();
	}

}
