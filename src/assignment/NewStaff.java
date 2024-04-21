
package assignment;

import java.time.LocalDate;

public class NewStaff {
	int customer_id;
	String username;
	String pass_word;
	String address;
	String phone_number; 
	String email_address;
	LocalDate join_date; 
	String gender;
	
	public NewStaff(String username, String pass_word, String address, String phone_number, String email_address, LocalDate join_date,
	        String gender) {
		
		this.customer_id = 0;
		this.username = username;
		this.pass_word = pass_word;
		this.address = address;
		this.phone_number = phone_number;
		this.email_address = email_address;
		this.join_date = join_date;
		this.gender = gender;
	}
	
	public NewStaff(int customer_id,String username, String pass_word, String address, String phone_number, String email_address, LocalDate join_date,
	        String gender) {
		
		this.customer_id = customer_id;
		this.username = username;
		this.pass_word = pass_word;
		this.address = address;
		this.phone_number = phone_number;
		this.email_address = email_address;
		this.join_date = join_date;
		this.gender = gender;
	}

	
	public int getCustomer_id() {
		return this.customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public LocalDate getJoin_date() {
		return join_date;
	}

	public void setJoin_date(LocalDate date_of_birth) {
		this.join_date = date_of_birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "NewPerson [ customer_id=" + customer_id + ",username=" + username + ", pass_word=" + pass_word + ", address=" + address
				+ ", phone_number=" + phone_number + ", email_address=" + email_address + ", join_date=" + join_date + ", gender=" + gender+"]";
				
	}	
}


