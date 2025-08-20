package MedicalCompney;


class Tablet {
    private static final double MAX_WEIGHT = 500.0; // Maximum allowed weight in mg
    private String name;
    private double weight;
    
    public Tablet(String name, double weight) throws TabletWeightExceededException {
        if (weight > MAX_WEIGHT) {
            throw new TabletWeightExceededException("Tablet weight exceeds the allowed limit of " + MAX_WEIGHT + " mg.");
        }
        this.name = name;
        this.weight = weight;
        System.out.println("Tablet " + name + " with weight " + weight + " mg is within the allowed limit.");
    }
}