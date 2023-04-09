package tw.idv.stevenang.experimental.api.v1.resource.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import tw.idv.stevenang.experimental.api.v1.model.ApiUsersPage;
import tw.idv.stevenang.experimental.api.v1.resource.ExperimentalApiDelegate;

@Component
public class ExperimentalApiDelegateGetUsers implements ExperimentalApiDelegate {

    @Override
    public ResponseEntity<ApiUsersPage> getUsers() {
        return ResponseEntity.ok(getApiUsersPage());
    }

    private ApiUsersPage getApiUsersPage() {

        ApiUsersPage apiUsersPage = new ApiUsersPage();
        // TODO: Complete the implementation

        return apiUsersPage;
    }
}
