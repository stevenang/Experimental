package tw.idv.stevenang.experimental.api.v1.resource.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import tw.idv.stevenang.experimental.api.v1.model.ApiUser;
import tw.idv.stevenang.experimental.api.v1.resource.ExperimentalApiDelegate;

@Component
public class ExperimentalApiDelegateGetUser implements ExperimentalApiDelegate {

    @Override
    public ResponseEntity<ApiUser> getUser(String userId) {
        return ResponseEntity.ok(createApiUser());
    }

    private ApiUser createApiUser() {
        return new ApiUser()
                .firstName("Steven")
                .lastName("Ang")
                .userId("sang")
                .address01("23030 58th Rd")
                .city("Oakland Gardens")
                .state("New York")
                .zipCode("11364")
                .country("USA")
                .email("ang.steve@icloud.com")
                .phone("929-319-0725");
    }
}
