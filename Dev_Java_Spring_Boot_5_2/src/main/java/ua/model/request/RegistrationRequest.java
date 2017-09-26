package ua.model.request;

import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import ua.validation.annotation.PasswordEqual;
import ua.validation.annotation.UniqueUser;

@PasswordEqual(message="Passwords must be equal")
public class RegistrationRequest {

	@NotBlank(message="This field should be not empty")
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})+| *$",
	message="This is not correct email")
	@UniqueUser
	private String email;
	
	@NotBlank(message="This field should be not empty")
	@Pattern(regexp="^(?=.*?\\d)(?=.*?[a-zA-Z])(?=.*?[^\\w]).{3,}+| *$",
	message="Password must have numbers, letters and symbol(like ! etc.)")
	@Size(min=5, max=30, message="The password should be more than 5")
	private String password;
	
	@NotBlank(message="This field should be not empty")
	private String repeatPassword;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	
	
}
