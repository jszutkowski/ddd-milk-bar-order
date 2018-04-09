package pl.szutkowski.milkbarorder.domain.ValueObject;

public abstract class EntityId{
    private String id;


    public EntityId(String id) {
        this.id = id;
    }

    private boolean equals(EntityId entityId) {
        return id.equals(entityId.id());
    }

    public String id() {
        return id;
    }
}
