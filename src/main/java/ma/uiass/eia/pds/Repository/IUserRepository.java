package ma.uiass.eia.pds.Repository;

import ma.uiass.eia.pds.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query("from User where username =:username")
    User findByUsername(@Param("username") String username);

}
