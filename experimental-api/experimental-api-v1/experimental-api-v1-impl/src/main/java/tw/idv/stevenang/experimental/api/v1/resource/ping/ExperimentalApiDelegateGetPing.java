package tw.idv.stevenang.experimental.api.v1.resource.ping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import tw.idv.stevenang.experimental.api.v1.model.ApiBuildVersion;
import tw.idv.stevenang.experimental.api.v1.model.ApiPing;
import tw.idv.stevenang.experimental.api.v1.resource.ExperimentalApiDelegate;

@Component
@Slf4j
public class ExperimentalApiDelegateGetPing implements ExperimentalApiDelegate {

    @Override
    public ResponseEntity<ApiPing> getPing() {

        log.info("Start getPing");
        ApiPing ping = new ApiPing();

        ping.setStatus("OK");
        ping.setCode(200);
        ping.setBuildVersion(createBuildVersion());

        log.info("End getPing");
        return ResponseEntity.ok(ping);
    }

    private ApiBuildVersion createBuildVersion() {
        return new ApiBuildVersion().buildVersion("TEST VERSION")
                .buildTime("Test Build Time")
                .branch("Test Branch")
                .commitHash("Test Hash");
    }
}

