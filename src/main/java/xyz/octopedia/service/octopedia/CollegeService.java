package xyz.octopedia.service.octopedia;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.octopedia.entity.octopedia.College;
import xyz.octopedia.repository.octopedia.CollegeRepo;

import java.util.List;
import java.util.Optional;

public class CollegeService {
    @Autowired
    private CollegeRepo collegeRepo;

    College getCollegeById(Integer id){
        Optional<College> optionalCollege = collegeRepo.findById(id);
        if (!optionalCollege.isPresent()) {
            throw new RuntimeException();
        }
        return optionalCollege.get();
    }

}
