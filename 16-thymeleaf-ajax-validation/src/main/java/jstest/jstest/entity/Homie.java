package jstest.jstest.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Homie {


    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String homieName;

    public String getHomieName() {
        return homieName;
    }

    public void setHomieName(String homieName) {
        this.homieName = homieName;
    }
}
