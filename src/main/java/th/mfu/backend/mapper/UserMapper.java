package th.mfu.backend.mapper;

import th.mfu.backend.dto.UserDto;
import th.mfu.backend.model.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        return new UserDto(
            user.getId(),
            user.getFirstName(),
            user.getLastName()
        );
    }

    public static User mapToUserDto(UserDto userDto
    ){
        return new User(
            userDto.getId(),
            userDto.getFirstName(),
            userDto.getLastName()
        );
    }

    
}
