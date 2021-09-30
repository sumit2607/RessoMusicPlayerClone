package com.example.ressomusicplayerclone.Model;

public class model
{
  String name,course,email,purl;
    model()
    {

    }
    public model(String name,  String purl) {
        this.name = name;

        this.purl = purl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
