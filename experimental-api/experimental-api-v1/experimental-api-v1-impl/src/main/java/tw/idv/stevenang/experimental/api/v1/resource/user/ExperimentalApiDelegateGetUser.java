package tw.idv.stevenang.experimental.api.v1.resource.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import tw.idv.stevenang.experimental.api.v1.entity.User;
import tw.idv.stevenang.experimental.api.v1.model.ApiUser;
import tw.idv.stevenang.experimental.api.v1.resource.ExperimentalApiDelegate;
import tw.idv.stevenang.experimental.api.v1.service.UserService;
import tw.idv.stevenang.experimental.api.v1.util.ConvertUtil;

import java.util.Objects;

@Component
@Slf4j
public class ExperimentalApiDelegateGetUser implements ExperimentalApiDelegate {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<ApiUser> getUser(String userId) {
        return ResponseEntity.ok(createApiUser(userId));
    }

    private ApiUser createApiUser(String userId) {

        User user = userService.getUserByUserId(userId);
        ApiUser apiUser = new ApiUser();

        if (Objects.nonNull(user)) {
            return ConvertUtil.convertToApiUser(user);
        } else {
            log.error("User with user id {} not found", userId);
        }

        return null;
    }
}
