package project;

// Base User
class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void viewProfile() {
        System.out.println("Name: " + name + ", Email: " + email);
    }
}


class Doctor extends User {
    private String specialization;

    public Doctor(String name, String email, String specialization) {
        super(name, email);
        this.specialization = specialization;
    }

    @Override
    public void viewProfile() {
        System.out.println("Doctor Profile -> Specialization: " + specialization);
        super.viewProfile();
    }
}


class Patient extends User {
    private int patientId;

    public Patient(String name, String email, int patientId) {
        super(name, email);
        this.patientId = patientId;
    }

    @Override
    public void viewProfile() {
        System.out.println("Patient Profile -> ID: " + patientId);
        super.viewProfile();
    }
}

//Abstract Medical Record 
abstract class MedicalRecord {
    protected String patientName;
    protected String description;

    public MedicalRecord(String patientName, String description) {
        this.patientName = patientName;
        this.description = description;
    }

    public abstract void getDetails();
}


class Prescription extends MedicalRecord {
    private String[] medicines;

    public Prescription(String patientName, String description, String[] medicines) {
        super(patientName, description);
        this.medicines = medicines;
    }

    @Override
    public void getDetails() {
        System.out.print("Prescription for " + patientName + ": " + description + " | Medicines: ");
        for (String med : medicines) {
            System.out.print(med + " ");
        }
        System.out.println();
    }
}

//diagnor report
class DiagnosisReport extends MedicalRecord {
    private String disease;

    public DiagnosisReport(String patientName, String description, String disease) {
        super(patientName, description);
        this.disease = disease;
    }

    @Override
    public void getDetails() {
        System.out.println("Diagnosis Report for " + patientName + ": " + description + " | Disease: " + disease);
    }
}

//Payable Interface 
interface Payable {
    void makePayment(double amount);
}


class ConsultationService implements Payable {
    private double fee;

    public ConsultationService(double fee) {
        this.fee = fee;
    }

    @Override
    public void makePayment(double amount) {
        if (amount >= fee) {
            System.out.println("Consultation payment successful! Fee: " + fee);
        } else {
            System.out.println("Consultation payment failed! Need at least: " + fee);
        }
    }
}


class LabTestService implements Payable {
    private double testCost;

    public LabTestService(double testCost) {
        this.testCost = testCost;
    }

    @Override
    public void makePayment(double amount) {
        if (amount >= testCost) {
            System.out.println("Lab test payment successful! Cost: " + testCost);
        } else {
            System.out.println("Lab test payment failed! Need at least: " + testCost);
        }
    }
}
