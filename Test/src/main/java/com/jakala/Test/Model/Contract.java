package com.jakala.Test.Model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
/**
 * La classe contiene i dettagli essenziali di un contratto, inclusi l'identificatore univoco.
 * Fornisce anche un metodo per verificare la validità del contratto
 * @author Fabri
 *
 */

@Entity
public class Contract
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="Userid")
	private User user;
	 
	private String contracttype;
	private Date startdate ,enddate;
	
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	public String getContracttype()
	{
		return contracttype;
	}
	public void setContracttype(String contracttype)
	{
		this.contracttype = contracttype;
	}
	public Date getStartdate()
	{
		return startdate;
	}

	public void setStartdate(Date startdate)
	{
		this.startdate = startdate;
	}
	public Date getEnddate()
	{
		return enddate;
	}
	public void setEnddate(Date enddate)
	{
		this.enddate = enddate;
	}
	
	public boolean isValid() 
	{
		return
		contracttype!= null		&&
		!contracttype.isBlank()	&&
		startdate!= null		&&
		enddate!= null			&&
		startdate.before(enddate);
	}
}
