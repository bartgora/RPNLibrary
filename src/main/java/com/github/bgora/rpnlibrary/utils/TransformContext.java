package com.github.bgora.rpnlibrary.utils;

public class TransformContext {

    private boolean lastWasDigit = false;
    private boolean lastWasOperator = false;
    private boolean lastWasWhiteSpace = false;
    private boolean lastWasLetter = false;
    private StringBuilder stringBuilder;

    public TransformContext() {
        this(false, false, false, false);
    }

    public TransformContext(final boolean lastWasDigit, final boolean lastWasOperator, final boolean lastWasWhiteSpace, final boolean lastWasLetter) {
        this.lastWasDigit = lastWasDigit;
        this.lastWasOperator = lastWasOperator;
        this.lastWasWhiteSpace = lastWasWhiteSpace;
        this.lastWasLetter = lastWasLetter;
        this.stringBuilder = new StringBuilder();
    }

    public void append(char character) {
        this.stringBuilder.append(character);
    }
    public void append(String string) {
        this.stringBuilder.append(string);
    }

    public String getResult(){
        return this.stringBuilder.toString();
    }

    public boolean lastWasDigit() {
        return lastWasDigit;
    }

    public void lastWasDigit(final boolean lastWasDigit) {
        this.lastWasDigit = lastWasDigit;
    }

    public boolean lastWasOperator() {
        return lastWasOperator;
    }

    public void lastWasOperator(final boolean lastWasOperator) {
        this.lastWasOperator = lastWasOperator;
    }

    public boolean lastWasWhiteSpace() {
        return lastWasWhiteSpace;
    }

    public void lastWasWhiteSpace(final boolean lastWasWhiteSpace) {
        this.lastWasWhiteSpace = lastWasWhiteSpace;
    }

    public boolean lastWasLetter() {
        return lastWasLetter;
    }

    public void lastWasLetter(final boolean lastWasLetter) {
        this.lastWasLetter = lastWasLetter;
    }


}
