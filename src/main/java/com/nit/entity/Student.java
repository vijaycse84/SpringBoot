package com.nit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student_dtls")
@XmlRootElement
public class Student {
	@Id
	@Column(name="student_id")
	private Integer studentId;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="student_email")
	private String studentEmail;
	
	@Column(name="student_age")
	private Integer studentAge;

}
