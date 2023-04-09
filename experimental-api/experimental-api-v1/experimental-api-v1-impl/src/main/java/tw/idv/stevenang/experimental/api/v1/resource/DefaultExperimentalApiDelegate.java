package tw.idv.stevenang.experimental.api.v1.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tw.idv.stevenang.experimental.api.v1.model.ApiPing;
import tw.idv.stevenang.experimental.api.v1.model.ApiUsersPage;
import tw.idv.stevenang.experimental.api.v1.resource.ping.ExperimentalApiDelegateGetPing;
import tw.idv.stevenang.experimental.api.v1.resource.user.ExperimentalApiDelegateGetUsers;

@Primary
@Service
public class DefaultExperimentalApiDelegate implements ExperimentalApiDelegate {

    @Autowired
    private ExperimentalApiDelegateGetPing experimentalApiDelegateGetPing;

    @Autowired
    private ExperimentalApiDelegateGetUsers experimentalApiDelegateGetUsers;

    @Override
    public ResponseEntity<ApiPing> getPing() {
        return experimentalApiDelegateGetPing.getPing();
    }

    @Override
    public ResponseEntity<ApiUsersPage> getUsers() {
        return experimentalApiDelegateGetUsers.getUsers();
    }
}
