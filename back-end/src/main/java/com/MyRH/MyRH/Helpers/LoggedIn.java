package com.MyRH.MyRH.Helpers;

import com.MyRH.MyRH.Entities.ResHuman;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class LoggedIn {
    private ResHuman rh;
    private String Token;

}
