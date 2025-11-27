package model.dto;


import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskDTO {

    @Id
    private int id;
    private String date;
    private String title;
    private String Description;

}
