package com.employee.sb.entity;

import com.employee.sb.entity.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity
@Table(name="employees")
public class Employee {

	@Id
	private int eid;
	
	@Column(length=25, nullable= true)
	@NotBlank(message="Employee name cannot be blank")
	private String first_name;
	
	@Column(length=25, nullable= true)
	@NotBlank(message="Employee Surname cannot be blank")
	private String last_name;
	
	@Column(length=20, nullable= true, unique=true)
	@NotBlank(message="Employee Email ID cannot be blank")
	@Email(message="Email ID is not proper")
	private String email;
	
	@Column(length=11, nullable= true, unique=true)
	@NotNull(message="Phone number cannot be null")
	private long ephone;
	
	@Column(length=25, nullable= true, unique=true)
	@NotBlank(message="Designation cannot be blank")
	private String designation;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="did", referencedColumnName="did" )
	@JsonBackReference
	private Department department;
}
