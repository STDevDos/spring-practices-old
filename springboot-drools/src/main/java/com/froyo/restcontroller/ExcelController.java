package com.froyo.restcontroller;

import com.froyo.dto.Order;
import lombok.AllArgsConstructor;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ExcelController {

    private final KieSession session;

    @PostMapping("/order")
    public Order orderNow(@RequestBody Order order) {
        session.insert(order);
        session.fireAllRules();
        return order;
    }

}
