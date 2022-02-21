package com.github.academiacapgemini.questions.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteLadder {
    private static final Scanner SCANNER = new Scanner(System.in);
    private final Integer ladderLengthAndHeight;
    private static final String STAR = "*";
    private static final String SPACE = " ";
    private final List<String> ladder = new ArrayList<>();

    public WriteLadder(int length) {
        isValidLength(length);
        this.ladderLengthAndHeight = length;
    }

    public WriteLadder() {
        System.out.println("Entre com o tamanho da escada:");
        this.ladderLengthAndHeight = this.inputLadderLengthAndHeight();
        isValidLength(this.ladderLengthAndHeight);
    }

    private void isValidLength(int length) {
        if (length < 2) {
            throw new IllegalArgumentException("A escada deve ter mais de 2 degraus!");
        }
    }

    public List<String> getLadder() {
        return ladder;
    }

    public StringBuilder printLadder() {
        StringBuilder ladderOut= new StringBuilder();
        this.generateLadder();
        for (String level : this.ladder) {
            System.out.println(level);
            ladderOut.append(level).append("\n");
        }

        return ladderOut;
    }

    private void generateLadder() {
        int cont = this.ladderLengthAndHeight;
        for (int i = 0; i < this.ladderLengthAndHeight; i++) {
            StringBuilder level = new StringBuilder();
            for (int j = 0; j < this.ladderLengthAndHeight; j++) {
                level.append(this.printCharacter(i, j, cont));
            }
            this.ladder.add(level.toString());
            cont--;
        }
    }

    private Integer inputLadderLengthAndHeight() {
        return Integer.parseInt(SCANNER.next());
    }


    private String printCharacter(int i, int j, int cont) {
        if (cont - 2 < j) {
            return STAR;
        }
        return SPACE;
    }
}
