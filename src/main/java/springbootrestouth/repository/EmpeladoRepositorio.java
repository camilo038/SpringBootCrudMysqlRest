

package springbootrestouth.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springbootrestouth.model.Empleado;

@Repository
public interface EmpeladoRepositorio  extends JpaRepository<Empleado, Long> {




	
}
