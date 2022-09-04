package pl.drukowanie3D.wkrety;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    private int id;
    private double wymiar1;
    private double wymiar2;
    private double wymiar3;
    private String nick;

}
