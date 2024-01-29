package cm.customermanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.customermanagement.doa.CustomerServiceDoa;
import cm.customermanagement.entities.Customer;
import cm.customermanagement.exceptions.CustomerNotFound;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerServiceDoa customerServiceDoa ;
	
	@Override
	public Customer addCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return customerServiceDoa.save(cust);
	}

	@Override
	public void deleteCustomer(Long id) throws CustomerNotFound {
		// TODO Auto-generated method stub
		
		Customer c = this.customerServiceDoa.getById(id);
		System.out.println("::::customer data:::::"+c);
		if(c != null) 
		customerServiceDoa.delete(c);
		else
			throw new CustomerNotFound() ;

	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerServiceDoa.findAll();
	}

}
