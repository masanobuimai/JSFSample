package com.jsfsample.calc.plain;

import com.jsfsample.calc.Calc;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

import static com.jsfsample.FaceUtils.*;

@Named
@ViewScoped
public class CalcView implements Serializable {

    private Calc calc;
    private List<Calc> results;

    @PostConstruct
    private void postConstruct() {
        results = new LinkedList<>();
        reset();
    }

    public Calc getCalc() {
        return calc;
    }

    public void setCalc(Calc calc) {
        this.calc = calc;
    }

    public List<Calc> getResults() {
        return results;
    }

    public void setResults(List<Calc> results) {
        this.results = results;
    }

    public void doCalculation() {
        long l = calc.getLeft();
        long r = calc.getRight();
        long a = l + r;

        if (l % 2 == 0) flash("left", "左辺 " + l + " は偶数です");
        if (r % 2 != 0) flash("right", "右辺 " + r + " は奇数です");

        results.add(0, new Calc(l, r, a));
        reset();
    }



    private void reset() {
        Random rand = new Random(System.currentTimeMillis());
        calc = new Calc(
                Math.abs(rand.nextInt() % 10) + 1,
                Math.abs(rand.nextInt() % 10) + 1,
                0
        );

    }

}
