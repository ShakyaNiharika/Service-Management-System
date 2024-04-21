
package assignment;

import java.time.LocalDate;

public class NewBooking {
	int booking_id;
	NewService services;
	//String service_name;
	Float estimated_hour;
	LocalDate booking_date;
	String booking_time; 
	Float price;
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public NewService getServices() {
		return services;
	}
	public void setServices(NewService services) {
		this.services = services;
	}
	public Float getEstimated_hour() {
		return estimated_hour;
	}
	public void setEstimated_hour(Float estimated_hour) {
		this.estimated_hour = estimated_hour;
	}
	public LocalDate getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(LocalDate booking_date) {
		this.booking_date = booking_date;
	}
	public String getBooking_time() {
		return booking_time;
	}
	public void setBooking_time(String booking_time) {
		this.booking_time = booking_time;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public NewBooking(int booking_id, NewService services, Float estimated_hour, LocalDate booking_date,
			String booking_time, Float price) {
		super();
		this.booking_id = booking_id;
		this.services = services;
		this.estimated_hour = estimated_hour;
		this.booking_date = booking_date;
		this.booking_time = booking_time;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "NewBooking [booking_id=" + booking_id + ", services=" + services + ", estimated_hour=" + estimated_hour
				+ ", booking_date=" + booking_date + ", booking_time=" + booking_time + ", price=" + price + "]";
	}
				
	
	/*public NewBooking(String service_name, Float estimated_hour, LocalDate booking_date, String booking_time, Float price) 
	{
		
		this.booking_id = 0;
		this.service_name = service_name;
		this.estimated_hour = estimated_hour;
		this.booking_date = booking_date;
		this.booking_time = booking_time;
		this.price = price;
		
	};
	
	public NewBooking(int booking_id,String service_name, Float estimated_hour, LocalDate booking_date, String booking_time, Float price) 
	{
	
	this.booking_id = booking_id;
	this.service_name = service_name;
	this.estimated_hour = estimated_hour;
	this.booking_date = booking_date;
	this.booking_time = booking_time;
	this.price = price;
	
}

	
	public int getBooking_id() {
		return this.booking_id;
	}

	public void setCustomer_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public Float getEstimated_hour() {
		return estimated_hour;
	}

	public void setEstimated_hour(Float estimated_hour) {
		this.estimated_hour = estimated_hour;
	}

	public LocalDate getBooking_date() {
		return booking_date;
	}

	public void setBookingdate(LocalDate booking_date) {
		this.booking_date = booking_date;
	}

	public String getBooking_time() {
		return booking_time;
	}

	public void setTime(String booking_time) {
		this.booking_time = booking_time;
	}

	public Float getPrice() {
		return price;
	}

	public void setTotal_cost(Float price) {
		this.price = price;
	}

	


	@Override
	public String toString() {
		return "NewPerson [ booking_id=" + booking_id + ",service_name=" + service_name + ", estimated_hour=" + estimated_hour + ", booking_date=" + booking_date
				+ ", booking_time=" + booking_time + "]";
				
	}*/	
}
class NewBookingWithStatus extends NewBooking {
    private String customerName;
    private String status;

    public NewBookingWithStatus(int booking_id, String customerName, NewService services, Float estimated_hour, LocalDate booking_date,
            String booking_time, Float price, String status) {
        super(booking_id, services, estimated_hour, booking_date, booking_time, price);
        this.customerName = customerName;
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() + ", customerName=" + customerName + ", status=" + status;
    }
}
 class NewBookingWithTotalCost extends NewBooking {
    private Float total_cost;

    public NewBookingWithTotalCost(int booking_id, NewService services, Float estimated_hour, LocalDate booking_date,
            String booking_time, Float price, Float total_cost) {
        super(booking_id, services, estimated_hour, booking_date, booking_time, price);
        this.total_cost = total_cost;
    }

    // Getter method for total_cost
    public Float getTotalCost() {
        return total_cost;
    }
}






