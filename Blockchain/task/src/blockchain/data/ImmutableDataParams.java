package blockchain.data;

import java.util.Objects;

public class ImmutableDataParams implements DataParams {
    protected final long id;

    public ImmutableDataParams(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableDataParams that = (ImmutableDataParams) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ImmutableDataParams{" +
                "id=" + id +
                '}';
    }
}
