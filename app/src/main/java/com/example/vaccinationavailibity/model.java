package com.example.vaccinationavailibity;

public class model {

  private   String fees;
    private  String age;
    private String avail;
    private String center_name;
    private String location;
    private  String vaccine;
    private String time;
public model()
{

}
  public model(String fees, String age, String avail, String center_name, String location, String vaccine, String time) {
        this.fees = fees;
        this.age = age;
        this.avail = avail;
        this.center_name = center_name;
        this.location = location;
        this.vaccine = vaccine;
        this.time = time;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAvail() {
        return avail;
    }

    public void setAvail(String avail) {
        this.avail = avail;
    }

    public String getCenter_name() {
        return center_name;
    }

    public void setCenter_name(String center_name) {
        this.center_name = center_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
