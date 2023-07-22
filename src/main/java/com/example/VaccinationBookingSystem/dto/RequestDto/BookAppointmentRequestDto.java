package com.example.VaccinationBookingSystem.dto.RequestDto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookAppointmentRequestDto {

    int personId;

    int doctorId;
}
