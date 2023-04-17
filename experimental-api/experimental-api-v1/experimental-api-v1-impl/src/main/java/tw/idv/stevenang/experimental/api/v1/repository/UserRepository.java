package tw.idv.stevenang.experimental.api.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tw.idv.stevenang.experimental.api.v1.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("Select u from User u where u.userId = ?1")
    User finUserByUserId(String userId);
}
