package com.jsfsample.calc.uibind;

import com.jsfsample.calc.Calc;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static com.jsfsample.FaceUtils.message;

@Named
@ViewScoped
public class CalcUI implements Serializable {

    private HtmlInputText left = new HtmlInputText();
    private HtmlInputText right = new HtmlInputText();
    private List<Calc> results;

    @PostConstruct
    private void postConstruct() {
        results = new LinkedList<>();
        reset();
    }

    public HtmlInputText getLeft() {
        return left;
    }

    public void setLeft(HtmlInputText left) {
        this.left = left;
    }

    public HtmlInputText getRight() {
        return right;
    }

    public void setRight(HtmlInputText right) {
        this.right = right;
    }

    public List<Calc> getResults() {
        return results;
    }

    public void setResults(List<Calc> results) {
        this.results = results;
    }


    public void doCalculation() {
        long l = Long.parseLong(left.getValue().toString());
        long r = Long.parseLong(right.getValue().toString());
        long a = l + r;

        if (l % 2 == 0) {
            left.setDisabled(true);
            message(left, "偶数なので不活性にした");
        }
        else {
            left.setDisabled(false);
        }

        if (r % 2 > 0) {
            right.setStyle("background-color:lightpink");
            message(right, "奇数なので赤くした");
        }
        else {
            right.setStyle("");
        }

        results.add(0, new Calc(l, r, a));
        reset();
    }

    private void reset() {
        Random rand = new Random(System.currentTimeMillis());
        left.setValue(Math.abs(rand.nextInt() % 10) + 1);
        right.setValue(Math.abs(rand.nextInt() % 10) + 1);
    }

}
