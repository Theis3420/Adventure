public class Food extends Item{
    private int healthRestoration;

    Food(String name, int healthRestoration){
        super(name);
        this.healthRestoration = healthRestoration;
    }

    public int getHealthRestoration() {
        return healthRestoration;
    }
}
