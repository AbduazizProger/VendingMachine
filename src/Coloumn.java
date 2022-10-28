public class Coloumn {
    private int id, number;
    private String name;

    public Coloumn(int id, String name, int number){
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void reduce() {
        this.number --;
    }
}
