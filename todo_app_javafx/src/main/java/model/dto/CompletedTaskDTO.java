package model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompletedTaskDTO {

    private String date;
    private String title;
    private String description;

}
