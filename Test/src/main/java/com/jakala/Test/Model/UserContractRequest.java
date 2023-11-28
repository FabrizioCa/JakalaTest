package com.jakala.Test.Model;

import java.sql.Date;
/**
 * Rappresenta un oggetto contratto con le proprietà necessarie per la sua ricerca
 * @author Fabri
 *
 */
public class UserContractRequest
{
    
    private String name;
    private Date startdate;
    private String contracttype;
    private String usertype;
    
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Date getStartdate()
	{
		return startdate;
	}
	public void setStartdate(Date startdate)
	{
		this.startdate = startdate;
	}
	public String getContracttype()
	{
		return contracttype;
	}
	public void setContracttype(String contracttype)
	{
		this.contracttype = contracttype;
	}
	public String getUsertype()
	{
		return usertype;
	}
	public void setUsertype(String usertype)
	{
		this.usertype = usertype;
	}

    
}
