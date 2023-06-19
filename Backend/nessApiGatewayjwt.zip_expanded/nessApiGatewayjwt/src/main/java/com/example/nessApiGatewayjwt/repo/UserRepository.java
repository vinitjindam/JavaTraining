package  com.example.nessApiGatewayjwt.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nessApiGatewayjwt.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String emial);
    
   public User findByEmailAndSecQuestionAndSecAnswer(String email,String secQuestion,String secAnswer);

}
