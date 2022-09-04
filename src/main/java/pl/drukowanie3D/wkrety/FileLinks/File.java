package pl.drukowanie3D.wkrety.FileLinks;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class File {
    private String wymiar1;
    private String wymiar2;
    private String wymiar3;
    private String linktofile;
}
