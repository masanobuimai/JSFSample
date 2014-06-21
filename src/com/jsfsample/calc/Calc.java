package com.jsfsample.calc;

import java.io.Serializable;

public class Calc implements Serializable {
    private long left;
    private long right;
    private long answer;

    public Calc(long left, long right, long answer) {
        this.left = left;
        this.right = right;
        this.answer = answer;
    }

    public long getLeft() {
        return left;
    }

    public void setLeft(long left) {
        this.left = left;
    }

    public long getRight() {
        return right;
    }

    public void setRight(long right) {
        this.right = right;
    }

    public long getAnswer() {
        return answer;
    }

    public void setAnswer(long answer) {
        this.answer = answer;
    }
}
