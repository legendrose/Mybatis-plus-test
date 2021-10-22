package com.nj.innerClass;

import javax.print.attribute.standard.Destination;

public class ParCell {
    class Contents{
        private int i = 11;
        public int value(){
            return i;
        }
    }

    class Distination{
        private String label;
        public Distination(String whereto){
            label = whereto;
        }

        String readlabel(){
            return label;
        }
    }

    public Distination to(String s){
        return new Distination(s);
    }
    public Contents contents(){
        return new Contents();
    }

    public void ship(String dest){
        Contents c = new Contents();
        Distination d = new Distination(dest);
        System.out.println(d.readlabel());
    }

    public void main (String[] args){
        ParCell p = new ParCell();
        p.ship("胜多负少的");
        ParCell.Contents pc = p.contents();
        ParCell.Distination dd= p.to("指向内部类Distination的引用");
    }
}
