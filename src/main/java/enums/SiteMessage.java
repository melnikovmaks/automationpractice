package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum SiteMessage {
  MESSAGE_TO_CUSTOMER_SERVICE("I have a problem with my order. Could you help me"),
  COMMENT_TO_REVIEW("Faded short sleeve t-shirt with high neckline."
      + " Soft and stretchy material for a comfortable fit. Accessorize with a straw hat and you're ready for summer!"),
  MESSAGE_AFTER_REVIEW("Your comment has been added and will be available once approved by a moderator"),
  MESSAGE_AFTER_ADD_TO_WISHLIST("Added to your wishlist."),
  REVIEW_TITLE_MESSAGE("High quality product"),
  PRIORITY_ON_WISHLIST("Medium"),
  QUANTITY_ON_WISHLIST("1"),
  START_MESSAGE_TEXT("Your order on My Store is complete.\n" +
      "Please send us a bank wire with\n" +
      "- Amount $28.00\n" +
      "- Name of account owner Pradeep Macharla\n" +
      "- Include these details xyz\n" +
      "- Bank name RTP\n" +
      "- Do not forget to insert your order reference"),

  ENDS_MESSAGE_TEXT("in the subject of your bank wire.\n" +
      "An email has been sent with this information.\n" +
      "Your order will be sent as soon as we receive payment.\n" +
      "If you have questions, comments or concerns, please contact our expert customer support team. .");

  private final String value;
}
