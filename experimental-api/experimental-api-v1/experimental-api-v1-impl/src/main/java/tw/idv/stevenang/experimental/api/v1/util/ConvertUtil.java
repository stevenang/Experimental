package tw.idv.stevenang.experimental.api.v1.util;

import tw.idv.stevenang.experimental.api.v1.entity.User;
import tw.idv.stevenang.experimental.api.v1.model.ApiUser;

import java.util.Objects;

public class ConvertUtil {

    public static ApiUser convertToApiUser(User user) {

        if (Objects.isNull(user)) {
            return null;
        }

        ApiUser apiUser = new ApiUser();
        apiUser.setUserId(user.getUserId());
        apiUser.setFirstName(user.getFirstName());
        apiUser.setLastName(user.getLastName());
        apiUser.setBirthday(user.getBirthday());
        apiUser.setAddress01(user.getAddress_01());
        apiUser.setAddress02(user.getAddress_02());
        apiUser.setCity(user.getCity());
        apiUser.setState(user.getState());
        apiUser.setZipCode(user.getZipCode());
        apiUser.setCountry(user.getCountry());
        apiUser.setEmail(user.getEmail());
        apiUser.setPhone(user.getPhone());

        return apiUser;
    }

    public static User convertToUser(ApiUser apiUser) {

        if (Objects.isNull(apiUser)) {
            return null;
        }

        User user = new User();
        user.setUserId(apiUser.getUserId());
        user.setFirstName(apiUser.getFirstName());
        user.setLastName(apiUser.getLastName());
        user.setBirthday(apiUser.getBirthday());
        user.setAddress_01(apiUser.getAddress01());
        user.setAddress_02(apiUser.getAddress02());
        user.setCity(apiUser.getCity());
        user.setState(apiUser.getState());
        user.setZipCode(apiUser.getZipCode());
        user.setCountry(apiUser.getCountry());
        user.setEmail(apiUser.getEmail());
        user.setPhone(apiUser.getPhone());

        return user;
    }

}
