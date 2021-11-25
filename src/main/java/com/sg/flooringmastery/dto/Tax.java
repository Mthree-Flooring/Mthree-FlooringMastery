/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dto;

import java.util.Objects;

/**
 *
 * @author cd
 */
public class Tax {
    
    private String stateAbbrv;
    private String stateName;
    private BigDecimal taxRate;
    
    public Tax(String stateAbbrv) {
        this.stateAbbrv = stateAbbrv;
    }
    
    public String getStateAbbrv() {
        return stateAbbrv;
    }
    
    public String getStateName() {
        return stateName;
    }
    
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
    public BigDecimal getTaxRate() {
        return taxRate;
    }
    
    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
    
        @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.stateAbbrv);
        hash = 89 * hash + Objects.hashCode(this.stateName);
        hash = 89 * hash + Objects.hashCode(this.taxRate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tax other = (Tax) obj;
        if (!Objects.equals(this.stateAbbrv, other.stateAbbrv)) {
            return false;
        }
        if (!Objects.equals(this.stateName, other.stateName)) {
            return false;
        }
        if (!Objects.equals(this.taxRate, other.taxRate)) {
            return false;
        }
        return true;
    }
    
        @Override
    public String toString() {
        return "Tax{" + "stateAbbrv=" + stateAbbrv + ", stateName=" + stateName + ", taxRate=" + taxRate + '}';
    }
}
