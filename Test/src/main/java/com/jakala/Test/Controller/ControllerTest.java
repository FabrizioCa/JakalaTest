package com.jakala.Test.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.jakala.Test.Model.Contract;
import com.jakala.Test.Model.User;
import com.jakala.Test.Model.UserContractRequest;
import com.jakala.Test.Repository.ContractRepository;
import com.jakala.Test.Repository.UserRepository;


@RestController
public class ControllerTest
{
	@Autowired
	UserRepository userRepository;
	@Autowired
	ContractRepository contractRepository;
	
	/**
	 * 
	 *Develop one API to insert new contracts. 
	 * @author Fabri
	 */
	 @PostMapping("/addUserContracts/{id}")
	 public ResponseEntity<String> addUserContracts
	 (@PathVariable("id") int id, @RequestBody Contract contract) 
	 {
		 Optional<User> matchedUser = userRepository.findById(id);
		 if (matchedUser.isEmpty())
			return new ResponseEntity<>("Utente non valido", HttpStatus.BAD_REQUEST);
		 
		 contract.setUser(matchedUser.get());
		 contractRepository.save(contract);
		 
		 return new ResponseEntity<String> ("contratto aggiunto con successo", HttpStatus.OK);
		 /*try 
	 	{
			// Estrai informazioni utente e contratto dalla richiesta
			User user = userContractRequest.getUser();
	        Contract contract = userContractRequest.getContract();
	        
	        // Verifica che l'utente e il contratto siano validi
	     //if(user.isValid() && contract.isValid()) 
        	{
            // Salva l'utente nel repository
            //User savedUser = userRepository.save(user);

            // Collega l'utente al contratto e salva il contratto
            contract.setUser(user);
            contractRepository.save(contract);
            return new ResponseEntity<>("Utente e contratto aggiunti con successo", HttpStatus.OK);
        	}
	    // else
		  //   {
		    	// return new ResponseEntity<>("Dati utente o contratto non validi", HttpStatus.BAD_REQUEST);
		    // }
	     
	 	}
	 catch (Exception e) 
	 	{
         return new ResponseEntity<>("Errore durante l'aggiunta di utente e contratto", HttpStatus.INTERNAL_SERVER_ERROR);
	 	}*/
	 }
	 
	 
	 /**
		 * 
		 *Develop one API to search contracts with the possibility to search by:
		 * @author Fabri
		 */
	 @GetMapping("/searchContracts")
	    public ResponseEntity<List<Contract>> searchContracts(@RequestBody UserContractRequest filter) {

	        List<Contract> contracts = contractRepository.searchContracts
	        	   (
	                filter.getName(),
	                filter.getStartdate(),
	                filter.getContracttype(),
	                filter.getUsertype()
	               );

	        if (contracts.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } else {
	            return new ResponseEntity<>(contracts, HttpStatus.OK);
	        }
	    }
	/* Metodo per la ricerca con parametri combinabili
	    @GetMapping("/searchContracts")
	    public ResponseEntity<List<Contract>> searchContracts
    	(
          @RequestParam(required = false) String name,
          @RequestParam(required = false) Date startdate,
          @RequestParam(required = false) String contracttype,
          @RequestParam(required = false) String usertype
        ) 
	    {
	    	  if (name == null && startdate == null && contracttype == null && usertype == null) 
	              return 
	            		 new ResponseEntity<>("Almeno un parametro di ricerca deve essere fornito.", HttpStatus.BAD_REQUEST);
	          
	    	
	        List<Contract> contracts = contractRepository.searchByParameters(name, startdate, contracttype, usertype);

	        if (contracts.isEmpty()) 
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        else 
	            return new ResponseEntity<>(contracts, HttpStatus.OK);
	        
	    }*/
	 /**
	  * Develop one API that retrieves the contracts of one user. 
	  * @param userId
	  * @return
	  */
	 
	 @GetMapping("/user/{userId}")
	    public ResponseEntity<List<Contract>> getContractsByUserId(@PathVariable int userId) 
	 	{
	        Optional<User> userOptional = userRepository.findById(userId);

	        if (userOptional.isEmpty()) 
	        {
	            return ResponseEntity.notFound().build();
	        }

	        User user = userOptional.get();
	        List<Contract> contracts = contractRepository.findByUser(user);

	        return ResponseEntity.ok(contracts);
	 	}
	 
}
