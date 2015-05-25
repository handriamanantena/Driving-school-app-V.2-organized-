/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package organizeapp.controller.model;

import java.time.LocalDate;

/**
 *
 * @author harrison
 */
public class Payments {
    
    private LocalDate datePaymentMade;
    private double amountPayed;

    public Payments(LocalDate datePaymentMade, double amountPayed) {
        this.datePaymentMade = datePaymentMade;
        this.amountPayed = amountPayed;
    }

    public LocalDate getDatePaymentMade() {
        return datePaymentMade;
    }

    public void setDatePaymentMade(LocalDate datePaymentMade) {
        this.datePaymentMade = datePaymentMade;
    }

    public double getAmountPayed() {
        return amountPayed;
    }

    public void setAmountPayed(double amountPayed) {
        this.amountPayed = amountPayed;
    }
    
    
    
    
    
}
