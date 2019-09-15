package com.StrategyDemo;

public abstract class ValidationStrategy {
    public abstract boolean isValid(CreditCard creditCard);

    protected boolean passesLuhn(CreditCard creditCard) {
        int[] ints = new int[creditCard.getNumber().length()];
        for (int i = 0; i < creditCard.getNumber().length(); i++)
            ints[i] = Integer.parseInt(creditCard.getNumber().substring(i, i + 1));

        for (int i = ints.length - 2; i >= 0; i = i - 2) {
            int j = ints[i];
            j = j * 2;
            if (j > 9)
                j = j % 10 + 1;

            ints[i] = j;
        }
        int sum = 0;
        for (int i = 0; i < ints.length; i++)
            sum += ints[i];

        return sum % 10 == 0;
    }

}
