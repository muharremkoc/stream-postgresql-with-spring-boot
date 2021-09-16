package com.example.streamwithspringboot.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NonNull
    @Length(max = 100)
    String name;

    @Min(value = 18)
    @Length(max = 100)
    @NonNull
    int age;

    @Email
    @Length(max = 100)
    @NonNull
    String mail;

}
