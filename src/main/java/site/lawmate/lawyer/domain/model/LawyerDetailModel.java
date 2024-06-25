package site.lawmate.lawyer.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "lawyer_details")
@Builder
@AllArgsConstructor
@ToString(exclude = "id")
@NoArgsConstructor
public class LawyerDetailModel {
    @Id
    String id;
    String belong;
    String address;
    String addressDetail;
    String belongPhone;
    String image;
    String law;
    String visitCost;
    String phoneCost;
    String videoCost;
    String university;
    String major;
    Boolean premium;


}
