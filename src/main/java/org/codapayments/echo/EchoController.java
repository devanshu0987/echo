package org.codapayments.echo;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EchoController {

    @PostMapping(value = "/echo", consumes = "application/json", produces = "application/json")
    public ObjectNode echo(@RequestBody ObjectNode message) {
        return message;
    }

    @PostMapping(value = "/v2/echo", consumes = "application/json", produces = "application/json")
    public ObjectNode echoV2(@RequestBody ObjectNode message, @RequestParam Map<String, String> req) {
        if (req.containsKey("delay")) {
            int delay = Integer.parseInt(req.get("delay"));
            try {
                Thread.sleep(delay * 1000);
            } catch (InterruptedException e) {

            }
        }
        return message;
    }
}
