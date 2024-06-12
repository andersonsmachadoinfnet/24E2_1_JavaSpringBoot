package appdr1tp3.model.domain;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="materialdidatico")
public class MaterialDidatico {
    @Id
    private String id;
    private String material;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public MaterialDidatico assign(MaterialDidatico _de) {
        this.setMaterial(_de.getMaterial());
        return this;
    }
}
