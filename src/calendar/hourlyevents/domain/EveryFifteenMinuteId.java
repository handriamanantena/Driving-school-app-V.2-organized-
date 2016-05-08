/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar.hourlyevents.domain;

/**
 *
 * @author harrison
 */
public enum EveryFifteenMinuteId {
    ZERO_00(0,0),
    ZERO_15(0,15),
    ZERO_30(0,30),
    ZERO_45(0,45),
    ONE_00(1,0),
    ONE_15(1,15),
    ONE_30(1,30),
    ONE_45(1,45),
    TWO_00(2,0),
    TWO_15(2,15),
    TWO_30(2,30),
    TWO_45(2,45),
    THREE_00(3,0),
    THREE_15(3,15),
    THREE_30(3,30),
    THREE_45(3,45),
    FOUR_00(4,0),
    FOUR_15(4,15),
    FOUR_30(4,30),
    FOUR_45(4,45),
    FIVE_00(5,0),
    FIVE_15(5,15),
    FIVE_30(5,30),
    FIVE_45(5,45),
    SIX_00(6,0),
    SIX_15(6,15),
    SIX_30(6,30),
    SIX_45(6,45),
    SEVEN_00(7,0),
    SEVEN_15(7,15),
    SEVEN_30(7,30),
    SEVEN_45(7,45),
    EIGHT_00(8,0),
    EIGHT_15(8,15),
    EIGHT_30(8,30),
    EIGHT_45(8,45),
    NINE_00(9,0),
    NINE_15(9,15),
    NINE_30(9,30),
    NINE_45(9,45),
    TEN_00(10,0),
    TEN_15(10,15),
    TEN_30(10,30),
    TEN_45(10,45),
    ELEVEN_00(11,0),
    ELEVEN_15(11,15),
    ELEVEN_30(11,30),
    ELEVEN_45(11,45),
    TWELVE_00(12,0),
    TWELVE_15(12,15),
    TWELVE_30(12,30),
    TWELVE_45(12,45),
    THIRTEEN_00(13,0),
    THIRTEEN_15(13,15),
    THIRTEEN_30(13,30),
    THIRTEEN_45(13,45),
    FORTEEN_00(14,0),
    FORTEEN_15(14,15),
    FORTEEN_30(14,30),
    FORTEEN_45(14,45),
    FIFTEEN_00(15,0),
    FIFTEEN_15(15,15),
    FIFTEEN_30(15,30),
    FIFTEEN_45(15,45),
    SIXTEEN_00(16,0),
    SIXTEEN_15(16,15),
    SIXTEEN_30(16,30),
    SIXTEEN_45(16,45),
    SEVENTEEN_00(17,0),
    SEVENTEEN_15(17,15),
    SEVENTEEN_30(17,30),
    SEVENTEEN_45(17,45),
    EIGHTEEN_00(18,0),
    EIGHTEEN_15(18,15),
    EIGHTEEN_30(18,30),
    EIGHTEEN_45(18,45),
    NINETEEN_00(19,0),
    NINETEEN_15(19,15),
    NINETEEN_30(19,30),
    NINETEEN_45(19,45),
    TWENTY_00(20,0),
    TWENTY_15(20,15),
    TWENTY_30(20,30),
    TWENTY_45(20,45),
    TWENTYONE_00(21,0),
    TWENTYONE_15(21,15),
    TWENTYONE_30(21,30),
    TWENTYONE_45(21,45),
    TWENTYTWO_00(22,0),
    TWENTYTWO_15(22,15),
    TWENTYTWO_30(22,30),
    TWENTYTWO_45(22,45),
    TWENTYTHREE_00(23,0),
    TWENTYTHREE_15(23,15),
    TWENTYTHREE_30(23,30),
    TWENTYTHREE_45(23,45),
    TWENTYFOUR_00(24,0);
    
    
    private final int hour;
    private final int minute;
    
    EveryFifteenMinuteId(int hour, int minute){
        this.hour =hour;
        this.minute = minute;
    }
}
