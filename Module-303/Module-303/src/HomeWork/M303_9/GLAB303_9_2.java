package HomeWork.M303_9;

public class GLAB303_9_2 {
    public class Doctor {
    }

    String DoctorName;
    String Department;

    public void Doctor_Details() {
        System.out.println("Doctor Details");
    }

    public class Hospital {
        public void main(String[] args) {
            Surgeon s = new Surgeon();
            s.Surgeon_Details();
        }
    }

    public class Surgeon extends Doctor {
        void Surgeon_Details() {
            System.out.println("Surgeon Details....");
            System.out.println(Department = "cardio");
        }
    }
}
