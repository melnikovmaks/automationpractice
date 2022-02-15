package builders;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CreateAccountBuilder {

  String firstName;
  String lastName;
  String passwd;
  String company;
  String address;
  String city;
  String postcode;
  String additionalInformation;
  String homePhone;
  String mobilePhone;
  String addressAlias;
}
