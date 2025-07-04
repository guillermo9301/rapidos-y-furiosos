package pe.com.rapidosyfuriosos.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //genera los metodos GET y SET
@AllArgsConstructor //metodo constructor con parametros
@NoArgsConstructor //metodo constructor sin parametros
@Builder //genera la clase constructora
@Entity(name = "DistritoEntity") //define la entidad
@Table(name = "distrito") //define la tabla de la BD
public class DistritoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id //define la clave primaria
	@Column(name = "coddis") //columna de la tabla
	@GeneratedValue(strategy = GenerationType.IDENTITY) //define el auto incremento
	private long codigo;
	@Column(name = "nomdis",length = 50,nullable = false)
	private String nombre;
	@Column(name = "estdis",nullable = false)
	private boolean estado;
}
