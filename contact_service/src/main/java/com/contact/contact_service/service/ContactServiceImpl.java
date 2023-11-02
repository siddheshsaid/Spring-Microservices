package com.contact.contact_service.service;

import com.contact.contact_service.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service

public class ContactServiceImpl implements  ContactService{

    //FAKE LIST OF CONTACTS
    List<Contact> list=List.of(
          new Contact(1L,"durgesh123@gmail.com","Durgesh",13111L),
            new Contact(2L,"anil123@gmail.com","Anil",13111L),
            new Contact(3L,"rohan123@gmail.com","Rohan",13112L),

            new Contact(4L,"sameer123@gmail.com","Sameer",13113L)

    );
List<Contact> list1=new ArrayList<>();



    @Override
    public List<Contact> getContactsUser(Long userId) {
        return list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());

    }
}
