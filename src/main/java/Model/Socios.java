package Model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Socios {

	private int id_s;
	private String nombre;
	private String apellido;
	private int dni;
	private String email;
	private boolean estado;
	private LocalDate fecha_alta;
	

}
