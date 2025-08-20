package MedicalCompney;

public class MedicalCompany {
    public static void main(String[] args) {
        try {
            Tablet tablet1 = new Tablet("dolo", 450.0);
            Tablet tablet2 = new Tablet("paracitamol", 520.0); // This will trigger the exception
        } catch (TabletWeightExceededException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}