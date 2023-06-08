package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "child")
public class Child {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int babyId;
	private String babyFirstName;
	private String babyLastName;
	private String fatherName;
	private String MotherName;
	private String address;

	public int getBabyId() {
		return babyId;
	}

	public void setBabyId(int babyId) {
		this.babyId = babyId;
	}

	public String getBabyFirstName() {
		return babyFirstName;
	}

	public void setBabyFirstName(String babyFirstName) {
		this.babyFirstName = babyFirstName;
	}

	public String getBabyLastName() {
		return babyLastName;
	}

	public void setBabyLastName(String babyLastName) {
		this.babyLastName = babyLastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return MotherName;
	}

	public void setMotherName(String motherName) {
		MotherName = motherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Child [babyId=" + babyId + ", babyFirstName=" + babyFirstName + ", babyLastName=" + babyLastName
				+ ", fatherName=" + fatherName + ", MotherName=" + MotherName + ", address=" + address + "]";
	}

}
