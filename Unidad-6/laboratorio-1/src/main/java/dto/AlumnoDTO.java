package dto;

import java.time.LocalDate;

import domain.entities.Alumno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoDTO {
    private int id;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String numeroDocumento;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;
    
    public AlumnoDTO(Alumno alumno) {
    	
    }
}
