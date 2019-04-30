package springbootrestouth.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.easynotes.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootrestouth.model.Empleado;
import springbootrestouth.repository.EmpeladoRepositorio;

@RestController
@RequestMapping("/api")
public class EmpleadoController {

@Autowired
EmpeladoRepositorio empeladoRepositorio;

@GetMapping("/notes")
public List<Empleado> getAllNotes() {
    return empeladoRepositorio.findAll();
}


@PostMapping("/notes")
public Empleado creaarEmpelado(@Valid @RequestBody Empleado empleado) {
    return empeladoRepositorio.save(empleado);
}


@GetMapping("/notes/{id}")
public Empleado getEmpleado(@PathVariable(value = "id") Long empleadoid) {
    return empeladoRepositorio.findById(empleadoid)
            .orElseThrow(() -> new ResourceNotFoundException("Empelado", "id", empleadoid));
}
	

@PutMapping("/notes/{id}")
public Empleado updateEmpleado(@PathVariable(value = "id") Long empleadoiId,
                                       @Valid @RequestBody Empleado empleadoDetails) {

	Empleado empleado = empeladoRepositorio.findById(empleadoiId)
            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", empleadoiId));

	empleado.setNombre(empleado.getNombre());
	empleado.setDesignacion(empleado.getDesignacion());
 
    Empleado  updateEmpleado = empeladoRepositorio.save(empleado);
    return updateEmpleado;
}

@DeleteMapping("/notes/{id}")
public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long empleadoiId) {
	Empleado empleado = empeladoRepositorio.findById(empleadoiId)
            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", empleadoiId));

    empeladoRepositorio.delete(empleado);

    return ResponseEntity.ok().build();
}


}
