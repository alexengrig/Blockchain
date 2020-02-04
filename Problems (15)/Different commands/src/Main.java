interface Movable {
    int getX();

    void setX(int newX);

    int getY();

    void setY(int newY);
}

interface Storable {
    int getInventoryLength();

    String getInventoryItem(int index);

    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();
}

class CommandMove implements Command {
    Movable entity;
    int xMovement;
    int yMovement;

    @Override
    public void execute() {
        entity.setX(xMovement);
        entity.setY(yMovement);
    }
}

class CommandPickItem implements Command {
    Storable entity;
    String item;

    @Override
    public void execute() {
        for (int i = 0; i < entity.getInventoryLength(); i++) {
            if (entity.getInventoryItem(i) == null) {
                entity.setInventoryItem(i, item);
                break;
            }
        }
    }
}