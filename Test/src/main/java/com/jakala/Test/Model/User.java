package com.jakala.Test.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
/**
 * La classe contiene i dettagli essenziali di un utente, inclusi l'identificatore univoco.
 * Fornisce anche un metodo per verificare la validità dell'utente
 * @author Fabri
 *
 */
@Entity
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name, surname, usertype;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getUserType()
	{
		return usertype;
	}

	public void setUserType(String usertype)
	{
		this.usertype = usertype;
	}
	
	public boolean isValid() 
	{
		return
		name!=null  			&&
		!name.isBlank() 		&&
		surname!=null  			&&
		!surname.isBlank() 		&&
		usertype!=null			&&
		!usertype.isBlank()		;

	}
	
}
