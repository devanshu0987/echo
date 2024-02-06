package org.codapayments.echo;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @PostMapping(value = "/echo", consumes = "application/json", produces = "application/json")
    public ObjectNode echo(@RequestBody ObjectNode message) {
        return message;
    }
}
