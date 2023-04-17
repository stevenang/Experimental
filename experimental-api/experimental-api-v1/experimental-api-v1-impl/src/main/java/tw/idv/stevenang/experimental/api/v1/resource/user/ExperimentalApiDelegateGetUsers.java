package tw.idv.stevenang.experimental.api.v1.resource.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import tw.idv.stevenang.experimental.api.v1.entity.User;
import tw.idv.stevenang.experimental.api.v1.model.ApiUser;
import tw.idv.stevenang.experimental.api.v1.model.ApiUsersPage;
import tw.idv.stevenang.experimental.api.v1.resource.ExperimentalApiDelegate;
import tw.idv.stevenang.experimental.api.v1.service.UserService;
import tw.idv.stevenang.experimental.api.v1.util.ConvertUtil;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ExperimentalApiDelegateGetUsers implements ExperimentalApiDelegate {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<ApiUsersPage> getUsers() {
        return ResponseEntity.ok(getApiUsersPage());
    }

    private ApiUsersPage getApiUsersPage() {

        ApiUsersPage apiUsersPage = new ApiUsersPage();
        List<ApiUser> apiUsers = new ArrayList<>();

        // Get all users
        List<User> users = userService.getAllUsers();
        users.stream().forEach(user -> {
            apiUsers.add(ConvertUtil.convertToApiUser(user));
        });

        // Add apiUsers to apiUsersPage
        apiUsersPage.setUsers(apiUsers);

        return apiUsersPage;
    }
}
