package project;

public class App {
    public static void main(String[] args) {
       
        Doctor d1 = new Doctor("Dr. Sharma", "sharma@hospital.com", "Cardiologist");
        Patient p1 = new Patient("Rahul", "rahul@mail.com", 1001);

        d1.viewProfile();
        p1.viewProfile();

       
        Prescription pres = new Prescription("Rahul", "Chest Pain", new String[]{"MedicineA", "MedicineB"});
        DiagnosisReport report = new DiagnosisReport("Rahul", "Checkup Required", "Heart Disease");

        pres.getDetails();
        report.getDetails();

       
        ConsultationService consultation = new ConsultationService(500);
        consultation.makePayment(600); 
        consultation.makePayment(300); 

        LabTestService labTest = new LabTestService(1200);
        labTest.makePayment(1500); 
        labTest.makePayment(800);  
    }
}
