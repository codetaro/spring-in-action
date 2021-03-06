package ch08.pizza.domain;

import java.io.Serializable;

public abstract class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    private float amount;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
