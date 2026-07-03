import java.util.Random;

public class NaroFarmMonitor {
    public static void main(String[] args) {
        // Step A: Setup variables and array for 30 days
        double[] dailyRainfall = new double[30];
        Random random = new Random();
        
        double totalRainfall = 0;
        int wetDaysCount = 0;
        
        System.out.println("=== NARO Namulonge Maize Farm Daily Report ===");
        
        // Step B: Loop through 30 days to generate and evaluate readings
        for (int i = 0; i < dailyRainfall.length; i++) {
            // Generates a random double decimal from 0.0 up to 60.0 mm
            dailyRainfall[i] = random.nextDouble() * 60;
            
            // Print out each day's reading formatted neatly to two decimal places
            System.out.printf("Day %2d: %5.2f mm\n", (i + 1), dailyRainfall[i]);
            
            // Accumulate total rainfall metric
            totalRainfall += dailyRainfall[i];
            
            // Count if it counts as a designated "wet day" (> 30 mm)
            if (dailyRainfall[i] > 30.0) {
                wetDaysCount++;
            }
        }
        
        // Step C: Calculate the average monthly value
        double averageRainfall = totalRainfall / dailyRainfall.length;
        
        // Step D: Print aggregated statistics summary
        System.out.println("\n================ SUMMARY STATISTICS ================");
        System.out.printf("Total Monthly Rainfall   : %.2f mm\n", totalRainfall);
        System.out.printf("Average Daily Rainfall   : %.2f mm\n", averageRainfall);
        System.out.println("Number of 'Wet Days'     : " + wetDaysCount + " days");
        
        // Step E: Use conditional structure to classify the farm season risks
        System.out.print("Seasonal Classification  : ");
        if (totalRainfall <= 300.0) {
            System.out.println("DRY (High risk of dry spells, irrigation advised)");
        } else if (totalRainfall < 600.0) {
            System.out.println("NORMAL (Optimal conditions for maize growth)");
        } else {
            System.out.println("FLOOD-RISK (High risk of waterlogging, monitor drainage)");
        }
        System.out.println("====================================================");
    }
}