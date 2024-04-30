
package domain;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class Tarjeta_Credito extends DomainEntity {

	private String	nombreTitular;
	private String	marca;
	private String	numero;
	private int		mes;
	private int		anio;
	private Integer	codigoCVV;


	//-----------------Titular

	@NotBlank
	public String getNombreTitular() {
		return this.nombreTitular;
	}

	public void setNombreTitular(final String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	//-----------------Marca

	@NotBlank
	public String getMarca() {
		return this.marca;
	}

	public void setMarca(final String marca) {
		this.marca = marca;
	}

	//-----------------Numero

	@NotBlank
	@CreditCardNumber
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(final String numero) {
		this.numero = numero;
	}

	//-----------------Mes

	@Range(min = 1, max = 12)
	public int getMes() {
		return this.mes;
	}

	public void setMes(final int mes) {
		this.mes = mes;
	}

	//-----------------Año

	@Min(2024)
	public int getAnio() {
		return this.anio;
	}

	public void setAnio(final int anio) {
		this.anio = anio;
	}

	//-----------------CVV

	@Range(min = 0, max = 999)
	public Integer getCodigoCVV() {
		return this.codigoCVV;
	}

	public void setCodigoCVV(final Integer codigoCVV) {
		this.codigoCVV = codigoCVV;
	}
}
