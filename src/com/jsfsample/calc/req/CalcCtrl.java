package com.jsfsample.calc.req;

import com.jsfsample.calc.Calc;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

import static com.jsfsample.FaceUtils.*;

@Named
@ViewScoped
public class CalcCtrl implements Serializable {

    @PostConstruct
    private void postConstruct() {
        viewMap("results", new LinkedList<Calc>());
    }

    public String doInit() {
        reset();
        return "calc/calc-req";
    }

    public void doCalculation() {
        long l = Long.parseLong(requestMap("left").toString());
        long r = Long.parseLong(requestMap("right").toString());
        long a = l + r;

        if (l % 2 == 0) flash("left", "左辺 " + l + " は偶数です");
        if (r % 2 != 0) flash("right", "右辺 " + r + " は奇数です");

        List<Calc> results = (List<Calc>) viewMap("results");
        results.add(0, new Calc(l, r, a));
        reset();
    }

    private void reset() {
        Random rand = new Random(System.currentTimeMillis());
        requestMap("left", Math.abs(rand.nextInt() % 10) + 1);
        requestMap("right", Math.abs(rand.nextInt() % 10) + 1);
    }

}
