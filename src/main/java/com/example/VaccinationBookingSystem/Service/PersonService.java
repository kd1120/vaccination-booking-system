package com.example.VaccinationBookingSystem.Service;

import com.example.VaccinationBookingSystem.Model.Person;
import com.example.VaccinationBookingSystem.Repository.PersonRepository;
import com.example.VaccinationBookingSystem.dto.RequestDto.AddPersonRequestDto;
import com.example.VaccinationBookingSystem.dto.ResponseDto.AddPersonResponseDto;
import com.example.VaccinationBookingSystem.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public AddPersonResponseDto addPerson(AddPersonRequestDto addPersonRequestDto) {

        // Convert Request Dto -> Enttity
        Person person = new Person();
        person.setName(addPersonRequestDto.getName());
        person.setAge(addPersonRequestDto.getAge());
        person.setEmailId(addPersonRequestDto.getEmailId());
        person.setGender(addPersonRequestDto.getGender());
//        person.setDose1Taken(false);
//        person.setDose2Taken(false);
//        person.setCertificate(null);

        Person savedPerson = personRepository.save(person);

        // saved entity -> response dto
        AddPersonResponseDto addPersonResponseDto = new AddPersonResponseDto();
        addPersonResponseDto.setName(savedPerson.getName());
        addPersonResponseDto.setMessage("Congrats! You have been registered");
        return addPersonResponseDto;
    }

    public String updateEmail(String oldEmail, String newEmail) {

        Person person = personRepository.findByEmailId(oldEmail);
        if(person == null){
            throw new PersonNotFoundException("Sorry email doesn't exist");
        }

        person.setEmailId(newEmail);
        personRepository.save(person);
        return "Congrats!! Your email has been updated successfully";
    }
}
