/*
 * UserAccount.java
 *
 * Copyright (C) 2018 Universidad de Sevilla
 *
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import domain.DomainEntity;

@Entity
@Access(AccessType.PROPERTY)
public class UserAccount extends DomainEntity implements UserDetails {

	// Constructors -----------------------------------------------------------

	private static final long serialVersionUID = 7254823034213841482L;


	public UserAccount() {
		super();

		this.authorities = new ArrayList<Authority>();
	}

	// Attributes -------------------------------------------------------------


	// UserDetails interface --------------------------------------------------

	private String					username;
	private String					password;
	private Collection<Authority>	authorities;


	@Size(min = 5, max = 32)
	@Column(unique = true)
	@Override
	public String getUsername() {
		return this.username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	@Size(min = 5, max = 32)
	@Override
	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@NotEmpty
	@Valid
	@ElementCollection
	@Override
	public Collection<Authority> getAuthorities() {
		// WARNING: Should return an unmodifiable copy, but it's not possible with hibernate!
		return this.authorities;
	}

	public void setAuthorities(final Collection<Authority> authorities) {
		this.authorities = authorities;
	}

	public void addAuthority(final Authority authority) {
		Assert.notNull(authority);
		Assert.isTrue(!this.authorities.contains(authority));

		this.authorities.add(authority);
	}

	public void removeAuthority(final Authority authority) {
		Assert.notNull(authority);
		Assert.isTrue(this.authorities.contains(authority));

		this.authorities.remove(authority);
	}

	@Transient
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Transient
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Transient
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Transient
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Transient
	public String getAuth() {
		String result = "";

		for (final Authority authority : this.getAuthorities())
			if (authority.getAuthority().equalsIgnoreCase("ALUMNO"))
				result = "ALUMNO";
			else if (authority.getAuthority().equalsIgnoreCase("ACADEMIA"))
				result = "ACADEMIA";
			else if (authority.getAuthority().equalsIgnoreCase("ADMINISTRADOR"))
				result = "ADMINISTRADOR";

		return result;
	}

	@Transient
	public static void generateMD5Hash(final String input, final UserAccount us) {
		try {
			// Crear una instancia de MessageDigest con el algoritmo MD5
			final MessageDigest md = MessageDigest.getInstance("MD5");

			// Calcular el hash de la entrada
			final byte[] hashBytes = md.digest(input.getBytes());

			// Convertir los bytes del hash a una representación hexadecimal
			final StringBuilder hexString = new StringBuilder();
			for (final byte b : hashBytes) {
				final String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			us.setPassword(hexString.toString());

		} catch (final NoSuchAlgorithmException e) {
			//Fallo
		}
	}

}
