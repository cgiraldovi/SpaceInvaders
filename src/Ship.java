abstract class Ship {
    private String _Forma;
    private int _health;

    public Ship (String forma, int health){
        _Forma = forma;
        _health = health;
    }

    public int get_health() {
        return _health;
    }

    public String get_Forma() {
        return _Forma;
    }

    public void set_Forma(String Forma) {
        _Forma = Forma;
    }

    public void set_health(int health) {
        _health = health;

    }
    public abstract void shoot();
}
