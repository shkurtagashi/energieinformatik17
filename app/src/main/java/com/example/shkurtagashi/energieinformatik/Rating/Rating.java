package com.example.shkurtagashi.energieinformatik.Rating;

/**
 * Created by shkurtagashi on 9/11/17.
 */

public class Rating {

    public String _paperId;
    public int _ratingValue;

    public Rating(){

    }

    public Rating(String paperId, int ratingValue){
        setPaperId(paperId);
        setRatingValue(ratingValue);
    }

    public void setPaperId(String paperId) {
        this._paperId = paperId;
    }

    public String getPaperId(){
        return this._paperId;
    }

    public int getRatingValue(){
        return this._ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this._ratingValue = ratingValue;
    }
}
