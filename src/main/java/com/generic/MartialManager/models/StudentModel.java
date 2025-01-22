package com.generic.MartialManager.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_students")
public class StudentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private int age;

	private int geub;

	private String email;

	private String telnumber;

	private String initialDate;
}
