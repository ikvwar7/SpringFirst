package mypack.domain;

public class Account {
    private Long id;
    private String name;
    private Long ownerId;
    private Double volume;

    public Account(Long id, String name, Long ownerId, Double volume) {
        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner='" + ownerId + '\'' +
                ", volume=" + volume +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }
}

