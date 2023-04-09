package tw.idv.stevenang.experimental.api.v1.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import tw.idv.stevenang.experimental.api.v1.model.ApiPing;
import tw.idv.stevenang.experimental.api.v1.resource.ping.ExperimentalApiDelegateGetPing;

public class DefaultExperimentalApiDelegate implements ExperimentalApiDelegate {

    @Autowired
    private ExperimentalApiDelegateGetPing experimentalApiDelegateGetPing;

    @Override
    public ResponseEntity<ApiPing> getPing() {
        return experimentalApiDelegateGetPing.getPing();
    }
}
