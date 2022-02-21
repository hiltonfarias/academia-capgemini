package com.github.academiacapgemini.questions.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class WriteLadderTest {

    @Test
    void shouldGenerateALadderWithSisLevels() {

        ArrayList<String> ladderRef = new ArrayList<>();
        ladderRef.add("     *");
        ladderRef.add("    **");
        ladderRef.add("   ***");
        ladderRef.add("  ****");
        ladderRef.add(" *****");
        ladderRef.add("******");

        WriteLadder one = new WriteLadder(6);
        one.printLadder();

        Assertions.assertArrayEquals(new List[]{List.of(ladderRef)}, new List[]{List.of(one.getLadder())});
    }

    @Test
    void shouldThrowAnExceptionIfItHasLessThanTwoLevels() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new WriteLadder(1));
    }

}