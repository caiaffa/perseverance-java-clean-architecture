package com.caiaffa.perseverance.web.models.request;

import javax.validation.constraints.NotBlank;

public class CommandRequest {

    @NotBlank
    private String commands;

    public String getCommands() {
        return commands;
    }
}
