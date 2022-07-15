

import com.unique.unique_api.controllers.dto.UserDTO;
import com.unique.unique_api.repositories.entities.User;

    User findByUsername(String username);

    User findById(Integer userId);

    User update(UserDTO userDTO, Integer userId);

    void delete(Integer userId);

    User save(UserDTO newUserDTO);
}
