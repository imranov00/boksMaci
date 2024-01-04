public class Main {
    public static void main(String[] args) {
        Fighter f1 = new Fighter("Emin", 15, 100, 90,30 );
        Fighter f2 = new Fighter("Khabib", 10, 95, 100,40);

        Match match = new Match(f1, f2, 70, 100);
        match.baslayanOyuncuyuBulma();
        match.run();

    }
}