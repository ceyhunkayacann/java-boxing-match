public class Main {
    public static void main(String[] args) throws InterruptedException {
        Fighter tyson = new Fighter("Mike Tyson",100,90,10,20);
        Fighter lewis = new Fighter("Lennox Lewis",100,90,10,20);

        Match m1 = new Match(tyson,lewis,100,80);

        m1.run();


    }
}
