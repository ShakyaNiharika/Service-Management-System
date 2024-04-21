
package assignment;

import java.time.LocalDate;

public class NewService {
	int service_id;
	String service_name;
	String description;
	Double price;
	
	public NewService(String service_name, String description, Double price) {
		
		this.service_id = 0;
		this.service_name = service_name;
		this.description = description;
		this.price = price;
	}
	
	public NewService(int service_id,String service_name, String description, Double price) {
		
		this.service_id = service_id;
		this.service_name = service_name;
		this.description = description;
		this.price = price;
		
	}

	
	public int getService_id() {
		return this.service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	

	@Override
	public String toString() {
		return "NewPerson [ service_id=" + service_id + ",service_name=" + service_name + ", description=" + description + ", price=" + price+ "]";
				
	}	
}


