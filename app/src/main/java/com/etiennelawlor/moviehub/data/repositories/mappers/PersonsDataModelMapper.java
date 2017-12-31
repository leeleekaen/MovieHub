package com.etiennelawlor.moviehub.data.repositories.mappers;

import com.etiennelawlor.moviehub.data.network.response.Person;
import com.etiennelawlor.moviehub.data.network.response.PersonsEnvelope;
import com.etiennelawlor.moviehub.data.repositories.models.PersonsDataModel;

import java.util.Calendar;
import java.util.List;

/**
 * Created by etiennelawlor on 12/30/17.
 */

public class PersonsDataModelMapper implements DataModelMapper<PersonsEnvelope, PersonsDataModel> {

    // region Constants
    private static final int PAGE_SIZE = 20;
    private static final int SEVEN_DAYS = 7;
    // endregion

    @Override
    public PersonsDataModel mapToDataModel(PersonsEnvelope personsEnvelope) {
        PersonsDataModel personsDataModel = new PersonsDataModel();

        List<Person> persons = personsEnvelope.getPersons();
        personsDataModel.setLastPage(persons.size() < PAGE_SIZE ? true : false);
        personsDataModel.setPageNumber(personsEnvelope.getPage());
        personsDataModel.setPersons(persons);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, SEVEN_DAYS);
        personsDataModel.setExpiredAt(calendar.getTime());

        return personsDataModel;
    }
}