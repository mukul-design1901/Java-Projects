package com.currency;

public class Main {
    public static void main(String[] args) {

        UserInput input = new UserInput();
        APIServices api = new APIServices();
        CurrencyConverter converter = new CurrencyConverter();

        boolean again=true;

        do {
            String base = input.getCurrency("Enter base currency (e.g. INR): ");
            String target = input.getCurrency("Enter target currency (e.g. USD): ");
            double amount = input.getAmount();

            double rate = api.getExchangeRate(base, target);

            if (rate == -1) {
                System.out.println("Invalid currency or API error.");
                continue;
            }

            double result = converter.convert(amount, rate);

            System.out.println("Converted Amount: " + result + " " + target);

            again = input.playAgain();

        } while (again);

        System.out.println("Thank you!");
    }
}