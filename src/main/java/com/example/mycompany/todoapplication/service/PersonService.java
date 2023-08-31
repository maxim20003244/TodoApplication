package com.example.mycompany.todoapplication.service;

import com.example.mycompany.todoapplication.constants.TodoConstants;
import com.example.mycompany.todoapplication.model.Person;
import com.example.mycompany.todoapplication.model.Role;
import com.example.mycompany.todoapplication.repository.PersonRepository;
import com.example.mycompany.todoapplication.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final RoleRepository roleRepository;
    public PersonService(PersonRepository personRepository, RoleRepository roleRepository) {
        this.personRepository = personRepository;

        this.roleRepository = roleRepository;
    }

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Role role = roleRepository.getByRoleName(TodoConstants.ADMIN);
        person.setRole(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;

    }
}
