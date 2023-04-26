package com.rolexapp.rolexreclamosapp.models;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "reclamos")
public class Reclamos {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message="*Ingrese su nombre")
	private String nomClie;
	@NotEmpty(message="*Ingrese su apellido")
	private String apeClie;
	@NotEmpty(message="*Ingrese su correo electronico")
	private String email;
	private int numCel;
	@NotEmpty(message="*Ingrese su direccion")
	private String direccion;
	@NotEmpty(message="*Ingrese el motivo de su reclamo")
	private String motReclamo;
    @NotEmpty(message="*Ingrese el nivel: Nuevo || Recurrente")
	private String nivel;

    public Reclamos(String nomClie, String apeClie, String email, int numCel, String direccion, String motReclamo, String nivel) {
        this.nomClie = nomClie;
        this.apeClie = apeClie;
        this.email = email;
        this.numCel = numCel;
        this.direccion = direccion;
        this.motReclamo = motReclamo;
        this.nivel = nivel;
    }

    
    public Reclamos() {
    }

    public Reclamos(int id, String nomClie, String apeClie, String email, int numCel, String direccion, String motReclamo, String nivel) {
        this.id = id;
        this.nomClie = nomClie;
        this.apeClie = apeClie;
        this.email = email;
        this.numCel = numCel;
        this.direccion = direccion;
        this.motReclamo = motReclamo;
        this.nivel = nivel;
    }
    

   

   


    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomClie() {
		return nomClie;
	}
	public void setNomClie(String nomClie) {
		this.nomClie = nomClie;
	}
	public String getApeClie() {
		return apeClie;
	}
	public void setApeClie(String apeClie) {
		this.apeClie = apeClie;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumCel() {
		return numCel;
	}
	public void setNumCel(int numCel) {
		this.numCel = numCel;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getMotReclamo() {
		return motReclamo;
	}
	public void setMotReclamo(String motReclamo) {
		this.motReclamo = motReclamo;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamos other = (Reclamos) obj;
        return Objects.equals(this.nomClie, other.nomClie);
    }

	
	
}
