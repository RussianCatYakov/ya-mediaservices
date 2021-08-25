package com.example.yamediaservices;

public class Rectangle {
    public double id, width, height;
    public String link;
    public Points pt;

    public Rectangle(int id, Points pt, double width, double height, String link) {
        this.id = id;
        this.pt = pt;
        this.width = width;
        this.height = height;
        this.link=link;
    }

    public boolean contains(Points pt) {
        return (this.get_top_left().x < pt.x && this.get_top_left().y < pt.y &&
                this.get_top_left().x + this.width > pt.x  &&
                this.get_top_left().y + this.height > pt.y);
    }

    public String getLink(){
        return this.link;
    }
    public Points get_top_left(){
        return new Points(this.pt.x, this.pt.y);
    }
    public Points get_top_right(){
        return new Points(this.pt.x + this.width, this.pt.y);
    }
    public Points get_bottom_left(){
        return new Points(this.pt.x, this.pt.y + this.height);
    }
    public Points get_bottom_right(){
        return new Points(this.pt.x + this.width, this.pt.y + this.height);
    }
}