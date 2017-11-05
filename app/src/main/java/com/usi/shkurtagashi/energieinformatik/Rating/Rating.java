package com.usi.shkurtagashi.energieinformatik.Rating;

/**
 * Created by shkurtagashi on 9/11/17.
 */

public class Rating {


    public int _paperId;
    public float _ratingValue;
    String timestamp;
    String presence;

    public Rating(){

    }

    public Rating(int paperId, float ratingValue, String t){
        setPaperId(paperId);
        setRatingValue(ratingValue);
        setTimestamp(t);
    }


    public void setPaperId(int paperId) {
        this._paperId = paperId;
    }
    public int getPaperId(){
        return this._paperId;
    }

    public float getRatingValue(){
        return this._ratingValue;
    }
    public void setRatingValue(float ratingValue) {
        this._ratingValue = ratingValue;
    }

    public void setTimestamp(String t){
        this.timestamp = t;
    }
    public String getTimestamp() {
        return timestamp;
    }

}
