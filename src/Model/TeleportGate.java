package Model;

import java.util.HashMap;

public class TeleportGate implements DestinationObject {
    public TeleportGate() {
        setInventory();
    }

    private boolean isActive;
    private boolean isPlaced;
    private TeleportGate pair;
    private Asteroid asteroid;
    private static final Inventory inventory = new Inventory();

    public TeleportGate(Inventory i, Settler s) {
        Logger.getInstance().printCommandCall(this);
        setInventory();
        if(inventory.ContainsAllElementsIn(i))
            {
                this.pair = new TeleportGate();
                this.isPlaced = false;
                this.isActive = false;
                s.AddGate(this);
            }
        Logger.getInstance().printReturnCommand();
    }

    private void setInventory() {
        Logger.getInstance().printCommandCall(this);

        HashMap<MaterialName, Integer> m = new HashMap<MaterialName, Integer>();
        m.put(NormalMaterialName.IRON, 2);
        m.put(SublimableMaterialName.ICEWATER, 1);
        m.put(RadioactiveMaterialName.URAN, 1);

        inventory.init(m);

        Logger.getInstance().printReturnCommand();
    }

    public Asteroid Accept(Character c) {
        Logger.getInstance().printCommandCall(this);

        if (isActive) {
            pair.GetAsteroid().Accept(c);
        }

        Logger.getInstance().printReturnCommand(pair.GetAsteroid().getClass().getSimpleName());
        return this.pair.GetAsteroid();
    }

    public void Place(Asteroid asteroid) {
        Logger.getInstance().printCommandCall(this);
        this.asteroid = asteroid;
        isPlaced = true;
        if (pair.GetPlaced()) {
            this.pair.Activate();
            this.Activate();
        }

        Logger.getInstance().printReturnCommand();
    }

    public boolean GetPlaced() {
        Logger.getInstance().printCommandCall(this);
        Logger.getInstance().printReturnCommand(pair.isPlaced);

        return pair.isPlaced;
    }

    public Asteroid GetAsteroid() {
        Logger.getInstance().printCommandCall(this);
        Logger.getInstance().printReturnCommand(asteroid.getClass().getSimpleName());

        return this.asteroid;
    }

    public TeleportGate GetPair() {
        Logger.getInstance().printCommandCall(this);
        Logger.getInstance().printReturnCommand(pair.getClass().getSimpleName());

        return this.pair;
    }

    public void Activate() {
        Logger.getInstance().printCommandCall(this);

        this.isActive = true;

        Logger.getInstance().printReturnCommand();
    }

    public void Deactivate() {
        Logger.getInstance().printCommandCall(this);

        this.isActive = false;

        Logger.getInstance().printReturnCommand();
    }

    public void HitByExplosion(Asteroid a) {
        Logger.getInstance().printCommandCall(this);

        this.Destroy();

        Logger.getInstance().printReturnCommand();
    }

    public void Destroy() {
        Logger.getInstance().printCommandCall(this);

        this.Deactivate();
        pair.Deactivate();
        this.isPlaced = false;

        Logger.getInstance().printReturnCommand();
    }

}