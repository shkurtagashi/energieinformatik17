package com.example.shkurtagashi.energieinformatik.Papers;

import java.util.Date;

/**
 * Created by shkurtagashi on 9/19/17.
 */

public class Survey {

    public String _id;
    public String timestamp;
    public int paperId;
    public int question1;
    public int question2;
    public int question3;
    public int question4;
    public int question5;
    public int question6;
    public String question7;

    public Survey(){}

    public Survey(String id, String timestamp, int pId, int q1, int q2, int q3, int q4, int q5, int q6, String q7){
        setId(id);
        setTimestamp(timestamp);
        setPaperId(pId);
        setQuestion1(q1);
        setQuestion2(q2);
        setQuestion3(q3);
        setQuestion4(q4);
        setQuestion5(q5);
        setQuestion6(q6);
        setQuestion7(q7);
    }

    public Survey(String timestamp, int pId, int q1, int q2, int q3, int q4, int q5, int q6, String q7){
        setTimestamp(timestamp);
        setPaperId(pId);
        setQuestion1(q1);
        setQuestion2(q2);
        setQuestion3(q3);
        setQuestion4(q4);
        setQuestion5(q5);
        setQuestion6(q6);
        setQuestion7(q7);
    }

    public void setQuestion1(int q) {
        this.question1 = q;
    }
    public void setQuestion2(int q) {
        this.question2 = q;
    }
    public void setQuestion3(int q) {
        this.question3 = q;
    }
    public void setQuestion4(int q) {
        this.question4 = q;
    }
    public void setQuestion5(int q) {
        this.question5 = q;
    }
    public void setQuestion6(int q) {
        this.question6 = q;
    }
    public void setQuestion7(String q) {
        this.question7 = q;
    }

    public void setId(String id) {
        this._id = id;
    }

    public void setTimestamp(String t){
        this.timestamp = t;
    }

    private String get_id(){
        return this._id;
    }

    public int getQuestion1() {
        return question1;
    }

    public int getQuestion2() {
        return question2;
    }

    public int getQuestion3() {
        return question3;
    }

    public int getQuestion4() {
        return question4;
    }

    public int getQuestion5() {
        return question5;
    }

    public int getQuestion6() {
        return question6;
    }

    public String getQuestion7() {
        return question7;
    }

    public void setPaperId(int pID) {
        this.paperId = pID;
    }

    public int getPaperId() {
        return paperId;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
