package calculator;

public class InvestmentCalculator {
    public static void main(String[] args) {
        double startingInvestment = 5000; 
        double monthlyInvestment = 2000; 
        double annualRate = 0.10; 
        double monthlyRate = annualRate / 12; 

        int[] years = {2, 5, 8, 10, 12, 15, 20, 25}; // Investment durations in years

        System.out.printf("%-10s %-20s %-20s %-20s %-20s%n", "Years", "Future Value (€)", "Total Invested (€)", "Starting Capital (€)", "Growth (€)");
        for (int year : years) {
            int n = year * 12; 
            double futureValue = calculateFutureValue(startingInvestment, monthlyInvestment, monthlyRate, n);
            
            double totalInvested = startingInvestment + (monthlyInvestment * n); // Total amount invested including starting capital
            double growth = futureValue - totalInvested;

            System.out.printf("%-10d %-20.2f %-20.2f %-20.2f %-20.2f%n", year, futureValue, totalInvested, startingInvestment, growth);
        }
    }

    private static double calculateFutureValue(double startingInvestment, double monthlyInvestment, double monthlyRate, int n) {
        // Future Value formula for an annuity with initial capital
        return startingInvestment * Math.pow(1 + monthlyRate, n) +
               monthlyInvestment * ((Math.pow(1 + monthlyRate, n) - 1) / monthlyRate) * (1 + monthlyRate);
   
    }
}
