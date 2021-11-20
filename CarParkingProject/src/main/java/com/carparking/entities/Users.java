package com.carparking.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import net.bytebuddy.utility.RandomString;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String confirmPass;
	private String address;
	@Column(unique=true)
	private String email;
	private String mobileNumber;
	private String carRegisNumber;
	private String role;
	@Column(name="one_time_password")
	private String oneTimePassword;
	@Column(name="otp_requested_time")
	private Date otpRequestedTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name="auth_provider")
	private AuthenticationProvider authProvider;
	
	public AuthenticationProvider getAuthProvider() {
		return authProvider;
	}

	public void setAuthProvider(AuthenticationProvider authProvider) {
		this.authProvider = authProvider;
	}

	public Users(int id, String firstName, String lastName, String userName, String password, String confirmPass,
			String address, String email, String mobileNumber, String carRegisNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.confirmPass = confirmPass;
		this.address = address;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.carRegisNumber = carRegisNumber;
		this.role = "ROLE_ADMIN";
		this.authProvider = AuthenticationProvider.LOCAL;
	}
	
	public Users() {
		super();
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", password=" + password + ", confirmPass=" + confirmPass + ", address=" + address + ", email="
				+ email + ", mobileNumber=" + mobileNumber + ", carRegisNumber=" + carRegisNumber + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPass() {
		return confirmPass;
	}
	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCarRegisNumber() {
		return carRegisNumber;
	}
	public void setCarRegisNumber(String carRegisNumber) {
		this.carRegisNumber = carRegisNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public String getOneTimePassword() {
		return oneTimePassword;
	}

	public void setOneTimePassword(String oneTimePassword) {
		this.oneTimePassword = oneTimePassword;
	}

	public Date getOtpRequestedTime() {
		return otpRequestedTime;
	}

	public void setOtpRequestedTime(Date otpRequestedTime) {
		this.otpRequestedTime = otpRequestedTime;
	}
	
	public boolean isOTPRequired() {
		
		return true;
	}
}
