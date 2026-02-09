package com.example.introspection;

import com.example.ContactRepository;
import entities.Contact;
import io.micronaut.core.beans.BeanIntrospection;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledInNativeImage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
public class ContactIntrospectionTest {
    @DisabledInNativeImage
    @Test
    void loadCsvAndInstantiateObjectsViaBeanIntrospection() throws Exception {
        var resource = getClass().getClassLoader().getResource("apple.csv");
        assertNotNull(resource, "app.csv not found!");
        var path = Path.of(resource.toURI());

        List<String> lines = Files.readAllLines(path);


        //this is the bean introspection api for a particular class
        var introspection = BeanIntrospection.getIntrospection(Contact.class);

        List<Contact> contacts = lines.stream()
                // instanciating the class in a reflection free way
                .map((String l) -> introspection.instantiate((Object []) l.split(",")))
                .toList();

        List<Contact> expected = List.of(
                new Contact("Tim Cook", "CEO", "Apple Inc."),
                new Contact("Craig Federighi",
                        "Senior Vice President - Software Engineering",
                        "Apple Inc.")
        );
    }



    @Test
    void dataTest(){
        var introspection = BeanIntrospection.getIntrospection(Contact.class);
        var contact = new Contact("Test", "Test Title", "Test Company");
        assertEquals("Test", introspection.getRequiredProperty("name", String.class).get(contact));
        assertEquals("Test Title", introspection.getRequiredProperty("jbt ", String.class).get(contact));
        assertEquals("Test Company", introspection.getRequiredProperty("company", String.class).get(contact));
    }

    // create new testing method mocking the Contact repository test

    @Inject
    ContactRepository contactRepository;

    @Test
    void mockedContactRepositoryTest() {
        ContactRepository repository = mock(ContactRepository.class);
        Contact contact = new Contact("Mocked Name", "Mocked Title", "Mocked Company");
        List<Contact> expectedContacts = List.of(contact);

        when(repository.findAll()).thenReturn(expectedContacts);

        List<Contact> actualContacts = repository.findAll();
        assertEquals(expectedContacts, actualContacts);
        assertEquals(1, actualContacts.size());
        assertEquals("Mocked Name", actualContacts.get(0).getName());

        verify(repository).findAll();
    }



}
