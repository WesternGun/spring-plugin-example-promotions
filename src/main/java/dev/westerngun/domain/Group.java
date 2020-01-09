package vptech.checkout.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** User group */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    private String groupName;
    private String residenceCountry;
    private Boolean firstTimeBuyer;
}
