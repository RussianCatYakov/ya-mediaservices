package com.example.yamediaservices;

import java.util.ArrayList;

public class ToSendListOfRects {
    public ToSendListOfRects(){}

    public ArrayList<Rectangle> get_ArrayList_of_rects_point_inside_of(ArrayList<Rectangle> rects,
                                                                       Points pt){
        ArrayList<Rectangle> in_rects = new ArrayList<Rectangle>();
        for (Rectangle rect : rects) {
            if(rect.contains(pt)){
                in_rects.add(rect);
            }
        }
        return in_rects;
    }

}
