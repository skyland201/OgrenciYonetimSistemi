public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;
    int sözlü;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;

        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;

        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;

        }

    }
    public void sözlü(int matSözlü,int fzkSözlü,int kmySözlü ){
        if (matSözlü>= 0 && matSözlü <= 100) {

            this.mat.sözlü=matSözlü;
        }

        if (fzkSözlü >= 0 && fzkSözlü <= 100) {

            this.fizik.sözlü=fzkSözlü;
        }

        if (kmySözlü >= 0 && kmySözlü <= 100) {
            this.kimya.sözlü=kmySözlü;
        }
    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.avarage = ((this.fizik.note*0.8+this.fizik.sözlü*0.2) + (this.kimya.note*0.8+this.kimya.sözlü*0.2) + (this.mat.note*0.8+this.mat.sözlü*0.2)) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Matematik sözlü notu :"+this.mat.sözlü);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Fizik sözlü notu : "+this.fizik.sözlü);
        System.out.println("Kimya Notu : " + this.kimya.note);
        System.out.println("Kimya sözlü notu : "+this.kimya.sözlü);
    }
}
