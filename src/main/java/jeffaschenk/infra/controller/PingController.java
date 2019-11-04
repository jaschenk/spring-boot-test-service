package jeffaschenk.infra.controller;

import io.swagger.annotations.Api;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * InfoController
 *
 * @author schenkje
 */
@Api(tags = "Ping Service API")
@RestController
public class PingController {
    /**
     * Common Logger
     */
    private static final org.slf4j.Logger LOGGER =
            LoggerFactory.getLogger(PingController.class);

    @GetMapping(value = "/ping")
    public ResponseEntity<String> ping() {
        LOGGER.info("Ping Request");
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

}
