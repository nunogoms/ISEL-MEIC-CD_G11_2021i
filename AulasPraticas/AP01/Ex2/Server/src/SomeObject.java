import java.io.Serializable;

public class SomeObject implements Serializable {

    String id;
    String description;
    float value;

    public SomeObject(String id, String description, float value) {
        this.setId(id);
        this.setDescription(description);
        this.setValue(value);
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public float getValue() {
        return this.value;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(float value) {
        this.value = value;
    }

}
