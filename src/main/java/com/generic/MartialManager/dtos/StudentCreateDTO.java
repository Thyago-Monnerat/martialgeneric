package com.generic.MartialManager.dtos;

import java.time.LocalDate;

public record StudentCreateDTO (String name, int age, int belt, String email, String phoneNumber, LocalDate initialDate){

}
