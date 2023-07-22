package com.example.VaccinationBookingSystem.Model;

import com.example.VaccinationBookingSystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {

    @Id
            @GeneratedValue(
                    strategy = GenerationType.IDENTITY
            )
    int id;

    String name;

    int age;

    @Column(unique = true)
    String emailId;

    @Enumerated(EnumType.STRING)
    Gender gender;
    boolean isdose1taken = false;
    boolean isdose2taken = false;

    @OneToMany(mappedBy = "person",cascade =  CascadeType.ALL)
    List<Dose> dosesTaken = new ArrayList<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    List<Appointment> appointments  = new ArrayList<>();

    @OneToMany(mappedBy = "person", cascade =  CascadeType.ALL)
    Certificate certificate;




}
