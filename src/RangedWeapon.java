public class RangedWeapon extends Weapon{

    private int ammo;
    
    RangedWeapon(String name ,int damage, boolean ranged, int ammo){
        super(name, damage, ranged);
        setAmmo(ammo);
    }

    public void setAmmo(int ammo) {
        this.ammo += ammo;
    }
    public int getAmmo() {
        return ammo;
    }
}