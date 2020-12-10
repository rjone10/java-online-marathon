package task5_2;

class Plant {
    private String name;
    private Color color;
    private Type type;

    public Plant(String type, String color, String name) throws IllegalArgumentException, ColorException, TypeException {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
        try {
            this.type = Type.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new TypeException("Invalid value " + type + " for field type");
        }
        try {
            this.color = Color.valueOf(color.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ColorException("Invalid value " + color + " for field color");
        }
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "{type: " + type +
                ", color: " + color +
                ", name: " + name + "}";
    }

    public static void main(String[] args) throws TypeException, ColorException {
        Plant plant = new Plant("Rare", "Red", "MyPlant");
        Plant plant2 = new Plant("Rare", "GREEN", "MyPlant");
    }
}

class ColorException extends Exception {
    public ColorException(String message) {
        super(message);
    }
}

class TypeException extends Exception {
    public TypeException(String message) {
        super(message);
    }
}

enum Color {
    WHITE("WHITE"), RED("RED"), BLUE("BLUE");

    private String color;

    Color(String color) {
        this.color = color;
    }
}

enum Type {
    RARE("RARE"), ORDINARY("ORDINATY");

    private String type;

    Type(String type) {
        this.type = type;
    }
}


