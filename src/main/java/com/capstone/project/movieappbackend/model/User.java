package com.capstone.project.movieappbackend.model; 

/*
 * Create a User class with the following fields: username, password, emailId, and address.
 * Use the @Entity annotation to map the User class to the users table in the database.
 * Use @Data annotation to generate the getters and setters for the User class.
 * Use @Id annotation to specify the email as primary key of the users table.
 * Use @Document annotation to specify the collection name as users.
 * Use @NoArgsConstructor and @AllArgsConstructor annotations to generate the default constructor and parameterized constructor for the User class.
 * Generate tostring method
 * Use @Column annotation to specify the username, password, and address as columns in the users table.
 * 
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor()
@AllArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String emailId;
    private String username;
    private String password;
    private String address;
}