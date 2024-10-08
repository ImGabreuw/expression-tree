package com.github.imgabreuw;

import com.github.imgabreuw.token.Token;
import com.github.imgabreuw.token.number.NumberToken;
import com.github.imgabreuw.token.operator.binary.SubtractionBinaryOperatorToken;
import com.github.imgabreuw.token.operator.unary.NegativeOperatorToken;
import com.github.imgabreuw.tree.BinaryExpressionTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class ParserTest {

    private Parser underTest;

    @BeforeEach
    void setUp() {
        underTest = new Parser();
    }

    @Test
    void shouldParseWithUnaryOperator1() {
        Deque<Token> tokens = new LinkedList<>(List.of(
                new NumberToken("9"),
                new NegativeOperatorToken(),
                new NumberToken("8"),
                new NegativeOperatorToken(),
                new SubtractionBinaryOperatorToken()
        ));

        BinaryExpressionTree tree = underTest.parse(tokens);
        tree.traverseInOrder();
        System.out.println("\n" + tree.calculate());
    }

    @Test
    void shouldParseWithUnaryOperator2() {
        Deque<Token> tokens = new LinkedList<>(List.of(
                new NumberToken("4"),
                new NegativeOperatorToken(),
                new NumberToken("3"),
                new NegativeOperatorToken(),
                new NegativeOperatorToken(),
                new SubtractionBinaryOperatorToken()
        ));

        BinaryExpressionTree tree = underTest.parse(tokens);
        tree.traverseInOrder();
        System.out.println("\n" + tree.calculate());
    }
}