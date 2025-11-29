package model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskDTO {

    private String date;
    private String title;
    private String Description;

}
