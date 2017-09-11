package com.example.shkurtagashi.energieinformatik.Rating;

/**
 * Created by shkurtagashi on 9/11/17.
 */

public class Rating {

    public String _paperId;
    public String _ratingValue;

    public Rating(String paperId, String ratingValue){
        setPaperId(paperId);
        setRatingValue(ratingValue);
    }

    public void setPaperId(String paperId) {
        this._paperId = paperId;
    }

    public String getPaperId(){
        return this._paperId;
    }

    public String getRatingValue(){
        return this._ratingValue;
    }

    public void setRatingValue(String ratingValue) {
        this._ratingValue = ratingValue;
    }
}
