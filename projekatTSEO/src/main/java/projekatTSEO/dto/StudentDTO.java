package projekatTSEO.dto;

import projekatTSEO.app.model.Student;

public class StudentDTO {
	
	private Long id;
	private String cardNumber;
	private String name;
	private String lastname;
	
	
	public StudentDTO() {
		
	}
	
	public StudentDTO(Student student) {
		this(student.getId(), student.getCardNumber(), student.getName(), student.getLastname());
	}

	public StudentDTO(Long id, String cardNumber, String name, String lastname) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.name = name;
		this.lastname = lastname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	

}
