package controller;

import view.CapacityView;
import model.Restaurant;
public class CapacityController {

    public CapacityView view;
    public Restaurant model;

    public CapacityController(CapacityView view) {
        this.view = view;

    }

    public void plot(){
        view.plot(Restaurant.getCapacity(), Restaurant.getOccupancy());
    }
}
