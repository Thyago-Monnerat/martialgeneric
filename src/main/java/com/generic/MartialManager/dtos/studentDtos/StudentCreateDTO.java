package com.generic.MartialManager.dtos.studentDtos;

import java.time.LocalDate;

public record StudentCreateDTO (String name, int age, int belt, String email, String phoneNumber, LocalDate initialDate){

}
