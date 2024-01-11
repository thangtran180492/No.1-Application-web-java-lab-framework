package com.example.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	private String firstName, lastName, country, favoriteLanguage;
	private String[] oprerationSystems;
	private LinkedHashMap<String, String> countryOptions;
	
	public Student() {
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("JPN", "Japan");
		countryOptions.put("USK", "The UK");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String[] getOprerationSystems() {
		return oprerationSystems;
	}

	public void setOprerationSystems(String[] oprerationSystems) {
		this.oprerationSystems = oprerationSystems;
	}
	
}
