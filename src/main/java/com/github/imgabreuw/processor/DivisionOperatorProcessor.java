package com.github.imgabreuw.processor;

import com.github.imgabreuw.Input;
import com.github.imgabreuw.token.Token;
import com.github.imgabreuw.token.operator.binary.DivisionBinaryOperatorToken;

public class DivisionOperatorProcessor implements TokenProcessor {

    @Override
    public Token process(Input input) {
        char currentChar = input.getCurrentCharacter();

        if (currentChar != '/') {
            return null;
        }

        input.next();
        return new DivisionBinaryOperatorToken();
    }

}
