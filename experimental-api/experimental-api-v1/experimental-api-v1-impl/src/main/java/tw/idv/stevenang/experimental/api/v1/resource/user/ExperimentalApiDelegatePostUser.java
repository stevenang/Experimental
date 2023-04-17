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

@Component
@Slf4j
public class ExperimentalApiDelegatePostUser implements ExperimentalApiDelegate {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<ApiUser> addUser(ApiUser apiUser) {
        try {
            return ResponseEntity.ok(createApiUser(apiUser));
        } catch (Exception e) {
            log.error("{}", e);
            return ResponseEntity.status(500).build();
        }
    }

    private ApiUser createApiUser(ApiUser apiUser) {

        User user = ConvertUtil.convertToUser(apiUser);
        userService.addUser(user);

        return apiUser;
    }
}
