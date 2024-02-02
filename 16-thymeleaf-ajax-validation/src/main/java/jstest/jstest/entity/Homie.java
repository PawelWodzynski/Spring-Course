package jstest.jstest.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Homie {


    @NotNull(message = "give name of homie")
    @Size(min=1, message = "give name of homie")
    private String homieName;

    @NotNull(message = "give gang name of homie")
    @Size(min=1, message = "give gang name of homie")
    private String homieGang;

    public String getHomieName() {
        return homieName;
    }

    public void setHomieName(String homieName) {
        this.homieName = homieName;
    }


    public String getHomieGang() {
        return homieGang;
    }

    public void setHomieGang(String homieGang) {
        this.homieGang = homieGang;
    }
}
