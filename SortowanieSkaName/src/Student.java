public class Student extends Osoba {
    private String numerIndeksu;

    public void setNumerIndeksu(String numerIndeksu) {
        this.numerIndeksu = numerIndeksu;
    }

    public Student(String numerIndeksu, String imie, String nazwisko, int rokUrodzenia) {
        super(imie, nazwisko, rokUrodzenia);
        this.numerIndeksu = numerIndeksu;
    }

    @Override
    public String toString() {
        return super.toString()+ "Student{" +
                "numerIndeksu='" + numerIndeksu + '\'' +
                '}';
    }

    public String getNumerIndeksu() {
        return numerIndeksu;
    }
}
