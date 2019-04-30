package springbootrestouth.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name= "Empleado")
@EntityListeners(AuditingEntityListener.class)


public class Empleado {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private  Long id;
	
	@NotBlank
	private String nombre;

	@NotBlank
	private String funcion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date creadoAt;
	

	private  String Designacion;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDesignacion() {
		return Designacion;
	}
	public void setDesignacion(String designacion) {
		Designacion = designacion;
	}
	public String getFuncion() {
		return funcion;
	}
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	
	public Date getCreadoAt() {
		return creadoAt;
	}
	public void setCreadoAt(Date creadoAt) {
		this.creadoAt = creadoAt;
	}

	
}
