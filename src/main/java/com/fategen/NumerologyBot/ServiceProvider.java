package com.fategen.NumerologyBot;

import com.fategen.NumerologyBot.service.DayForecast;
import com.fategen.NumerologyBot.service.Health;
import com.fategen.NumerologyBot.service.KarmaDebt;
import com.fategen.NumerologyBot.service.MonthForecast;
import com.fategen.NumerologyBot.service.MythicalAbility;
import com.fategen.NumerologyBot.service.Talents;
import com.fategen.NumerologyBot.service.YearForecast;
import com.fategen.NumerologyBot.service.birthMeaning.BirthMeaning;
import com.fategen.NumerologyBot.service.compatibility.Compatibility;
import com.fategen.NumerologyBot.service.compatibility.CompatibilityAndKarmaRelations;
import com.fategen.NumerologyBot.service.compatibility.KarmaRelations;
import com.fategen.NumerologyBot.service.compatibility.MyDestiny;
import com.fategen.NumerologyBot.service.personAndMind.MindNumber;
import com.fategen.NumerologyBot.service.personAndMind.PersonNumber;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ServiceProvider {

    public List<String> getBirthMeaning(String date) {
        BirthMeaning birthMeaning = new BirthMeaning(date);
        return birthMeaning.calculate();
    }

    public List<String> getCompatibility(String userDate, String partnerDate) {
        Compatibility compatibility = new Compatibility(userDate, partnerDate);
        return compatibility.calculate();
    }

    public String getCompatibilityAndKarmaRelations(String userFullName, String partnerFullName) {
        CompatibilityAndKarmaRelations service = new CompatibilityAndKarmaRelations(userFullName, partnerFullName);
        return String.valueOf(service.calculate());
    }

    public String getMyDestiny(String userDate, String partnerDate) {
        MyDestiny myDestiny = new MyDestiny(userDate, partnerDate);
        return String.valueOf(myDestiny.calculate());
    }

    public String getKarmaRelation(String userDate, String partnerDate) {
        KarmaRelations karmaRelations = new KarmaRelations(userDate, partnerDate);
        return String.valueOf(karmaRelations.calculate());
    }

    public List<List<String>> getAllCompatibilityServices(
            String userDate,
            String partnerDate,
            String userFullName,
            String partnerFullName)
    {
        List<List<String>> list = new ArrayList<>();
        list.add(getCompatibility(userDate, partnerDate));
        list.add(Collections.singletonList(getCompatibilityAndKarmaRelations(userFullName, partnerFullName)));
        list.add(Collections.singletonList(getMyDestiny(userDate, partnerDate)));
        list.add(Collections.singletonList(getKarmaRelation(userDate, partnerDate)));

        return list;
    }

    public List<String> getPersonAndMind(String fullName, String name, String date) {
        List<String> list = new ArrayList<>();

        PersonNumber personNumber = new PersonNumber(fullName);
        list.add(String.valueOf(personNumber.calculate()));

        MindNumber mindNumber = new MindNumber(name, date);
        list.add(String.valueOf(mindNumber.calculate()));

        return list;
    }

    public String getYearForecast(String date, int year) {
        YearForecast yearForecast = new YearForecast(date, year);
        return String.valueOf(yearForecast.calculate());
    }

    public String getMonthForecast(String date, int year, int month) {
        YearForecast yearForecast = new YearForecast(date, year);
        MonthForecast monthForecast = new MonthForecast(yearForecast, month);
        return String.valueOf(monthForecast.calculate());
    }

    public String getDayForecast(String date, String interestingDate) {
        DayForecast dayForecast = new DayForecast(date, interestingDate);
        return String.valueOf(dayForecast.calculate());
    }

    public String getTalents(String fullName) {
        Talents talents = new Talents(fullName);
        return String.valueOf(talents.calculate());
    }

    public String getKarmaDebt(String date, String fullName) {
        KarmaDebt karmaDebt = new KarmaDebt(date, fullName);
        return karmaDebt.calculate();
    }

    public String getHealth(String date) {
        Health health = new Health(date);
        return String.valueOf(health.calculate());
    }

    public String getMythicalAbility(String date) {
        MythicalAbility mythicalAbility = new MythicalAbility(date);
        return String.valueOf(mythicalAbility.calculate());
    }
}
