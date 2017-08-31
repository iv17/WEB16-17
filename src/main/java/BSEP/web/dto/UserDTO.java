package BSEP.web.dto;

import BSEP.beans.User;

public class UserDTO {

	private int id;
	private String username;
	private String password;
	private String repeated_password;
	private String name;
	private String surname;
	private String phoneNumber;
	private String email;
	private LocationDTO locationDTO; 
	private RoleDTO roleDTO;
	private ImageDTO imageDTO;
	private Boolean blocked;
	
	
	public UserDTO() {
		
	}

	public UserDTO(User user) {
		id = user.getId();
		username = user.getUsername();
		password = user.getPassword();
		name = user.getName();
		surname = user.getSurname();
		email = user.getEmail();
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocationDTO getLocationDTO() {
		return locationDTO;
	}

	public void setLocationDTO(LocationDTO locationDTO) {
		this.locationDTO = locationDTO;
	}

	public RoleDTO getRoleDTO() {
		return roleDTO;
	}

	public void setRoleDTO(RoleDTO roleDTO) {
		this.roleDTO = roleDTO;
	}

	public ImageDTO getImageDTO() {
		return imageDTO;
	}

	public void setImageDTO(ImageDTO imageDTO) {
		this.imageDTO = imageDTO;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	
	public String getRepeated_password() {
		return repeated_password;
	}

	public void setRepeated_password(String repeated_password) {
		this.repeated_password = repeated_password;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", surname=" + surname + ", phoneNumber=" + phoneNumber + ", email=" + email + ", locationDTO="
				+ locationDTO.toString() + ", roleDTO=" + roleDTO.getName() + ", imageDTO=" + imageDTO + ", blocked=" + blocked + "]";
	}
	
	
}
