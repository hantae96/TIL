package inheritance06;

import java.util.ArrayList;

public interface IUserDAO {

    void insert();
    UserDTO findById();
    ArrayList<UserDTO> findAllById();
    void updatePasswordById(String id);
    void delete(String id);
}
