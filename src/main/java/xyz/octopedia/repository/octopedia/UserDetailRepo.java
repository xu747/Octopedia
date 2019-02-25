package xyz.octopedia.repository.octopedia;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.octopedia.entity.octopedia.UserDeatil;

public interface UserDetailRepo extends JpaRepository<UserDeatil, Integer> {

}
