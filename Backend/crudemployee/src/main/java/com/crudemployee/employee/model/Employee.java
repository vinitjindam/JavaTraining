package com.crudemployee.employee.model;

import java.sql.Date;

import java.util.List;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor


@Entity
public class Employee {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	int empId;
	String empName;
	Date dob; 
	String dept;
	String city;
	String mobilenumber;
	int salary;
	

	@Type(type="yes_no")
	boolean isActive;
	
	@Column(name="user_name")
	String use;
	
	@Transient
	int someCalc;
	
	@Embedded
	Address homeAddress;
	
	@AttributeOverrides({
		@AttributeOverride(name="village",column=@Column(name="off_city")),
		@AttributeOverride(name="state",column=@Column(name="off_state"))
	})
	@Embedded
	Address officeAddress;
	
	@Embedded
	@ElementCollection
	List<Department> department;
}
