/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package organizeapp.interfaces;

import java.text.DecimalFormat;

/**
 *
 * @author harrison
 */
public interface DefaultPricesInterface {
    public final double NEW_PROGRAM_DEFAULT_PRICE =800;
    public final double DEFAULT_COST_PER_DRIVING_CLASS = 35;
    public final double DEFAULT_COST_PER_THEORY_CLASS = 18;
    public final double DEFAULT_COST_FOR_BOOK = 60;
    public final String BLANK = ""; 
    public final DecimalFormat CURRENCY_FORMATER = new DecimalFormat("0.00");
    
}
