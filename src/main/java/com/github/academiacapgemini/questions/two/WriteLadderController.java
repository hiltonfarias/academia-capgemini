package com.github.academiacapgemini.questions.two;

import com.github.academiacapgemini.questions.one.WriteLadder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WriteLadderController {

    WriteLadder writeLadder;

    public WriteLadderController() {
        writeLadder = new WriteLadder();
    }

    @GetMapping("/ladders")
    public StringBuilder getStrongPassword() {
        return writeLadder.printLadder();
    }
}
