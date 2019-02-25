package xyz.octopedia.repository.octopedia;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.octopedia.entity.octopedia.College;

public interface CollegeRepo extends JpaRepository<College, Integer> {
}
