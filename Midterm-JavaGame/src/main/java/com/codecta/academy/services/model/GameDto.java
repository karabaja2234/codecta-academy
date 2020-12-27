package com.codecta.academy.services.model;
import com.codecta.academy.repository.entity.Player;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class GameDto {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
